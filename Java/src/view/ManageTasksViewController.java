package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.time.LocalDate;

public class ManageTasksViewController {
  public TextField taskName;
  public TextArea taskDescription;
  public DatePicker deadline;
  public ChoiceBox choiceBoxTeam;
  public TextField estimatedHour;
  public TextField estimatedMinutes;
  public TextField estimatedSeconds;

  private ProjectManagementModel model;
  private Region root;
  private ViewHandler viewHandler;
  private Task currentTask;
  private Requirement currentRequirement;
  private ObservableList<String> teamMemberOptions;
  private TeamMember[] teamMembers;

  public ManageTasksViewController(){
    //nothing
  }


  public void init(ViewHandler viewHandler,ProjectManagementModel model, Region root, boolean edit)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    reset(edit);
  }

  public void reset(boolean edit){
    currentRequirement = viewHandler.getCurrentRequirement();
    currentTask = viewHandler.getCurrentTask();

    this.teamMemberOptions = FXCollections.observableArrayList();
    this.teamMembers = model.getAllTeamMembers();
    this.choiceBoxTeam.getItems().clear();
    for (TeamMember teamMember: teamMembers){
      teamMemberOptions.add(teamMember.getName());
    }
    this.choiceBoxTeam.getItems().addAll(teamMemberOptions);
    deadline.setDayCellFactory(picker -> new DateCell() {
      public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        LocalDate today = LocalDate.now();

        setDisable(empty || date.compareTo(today) < 0 );
      }
    });

    if (currentRequirement == null){
      return;
    }
    if (edit){
      this.taskName.setText(model.getName(currentTask));
      this.taskDescription.setText(model.getDescription(currentTask));
      String time =new TimeClass(model.getEstimatedTime(currentTask)).getFormattedTime() ;
      this.deadline.setAccessibleText(new TimeClass(model.getDeadlineTime(currentTask)).getFormattedDate());
      this.choiceBoxTeam.getSelectionModel().clearSelection();
    } else {
      currentTask = null;
      this.taskName.setText("");
      this.taskDescription.setText("");
      this.deadline.setValue(LocalDate.now());
      this.choiceBoxTeam.getSelectionModel().clearSelection();
    }
  }

  public Region getRoot()
  {
    return root;
  }

  public void confirmTask(ActionEvent actionEvent)
  {
    int time = 0;
    try {
      time += Integer.parseInt(this.estimatedHour.getText()) * 60 * 60;
      time += Integer.parseInt(this.estimatedMinutes.getText()) * 60;
      time += Integer.parseInt(this.estimatedSeconds.getText());
    } catch (Exception e){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("select a team member");
      alert.setHeaderText("You need to select team member that you want to edit first.");
      alert.show();
      return;
    }
    if (currentTask == null){
      if (this.choiceBoxTeam.getValue() == null){
        model.addTask(currentRequirement,this.taskName.getText(),model.getRequirementID(currentRequirement),
            (int)new TimeClass(time).getTime(), this.taskDescription.getText(),
            new TimeClass(""+this.deadline.getValue().getDayOfMonth()+"."+
                this.deadline.getValue().getMonthValue()+"." +
                this.deadline.getValue().getYear()).getTime());
      } else {
        model.addTask(currentRequirement,this.taskName.getText(),model.getRequirementID(currentRequirement),
            (int)new TimeClass(time).getTime(), this.taskDescription.getText(),
            new TimeClass(""+this.deadline.getValue().getDayOfMonth()+"."+
                this.deadline.getValue().getMonthValue()+"." +
                this.deadline.getValue().getYear()).getTime(),
            teamMembers[this.choiceBoxTeam.getSelectionModel().getSelectedIndex()]);
      }
      this.cancel();
    } else {
      if (this.choiceBoxTeam.getValue() == null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("select a team member");
        alert.setHeaderText("You need to select responsible team member.");
        alert.show();
      } else {
        model.changeTask(this.currentTask,this.taskName.getText(),(int)new TimeClass(time).getTime(),
            this.taskDescription.getText(),
            (int)new TimeClass(""+this.deadline.getValue().getDayOfMonth()+"."+ //TODO this should be long
                this.deadline.getValue().getMonthValue()+"." +
                this.deadline.getValue().getYear()).getTime(),
            teamMembers[this.choiceBoxTeam.getSelectionModel().getSelectedIndex()]);
        this.cancel();
      }

    }
  }

  public void cancel()
  {
    viewHandler.openView("RequirementView");
  }
}
