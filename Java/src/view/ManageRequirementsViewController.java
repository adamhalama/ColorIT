package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ManageRequirementsViewController {
  private ObservableList<String> teamMemberOptions;
  private TeamMember[] teamMembers;
  @FXML private ChoiceBox RequirementResponsibleMember;
  @FXML private TextField requirementName;
  @FXML private TextArea requirementDescription;
  @FXML private DatePicker requirementDeadline;
  private Project currentProject;
  private Requirement currentRequirement;

  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;

  public ManageRequirementsViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model,Region root,boolean edit){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    reset(edit);
  }

  public void reset(boolean edit){
    if (edit){
      this.currentRequirement = viewHandler.getCurrentRequirement();
    } else {
      this.currentRequirement = null;
    }
    this.currentProject = viewHandler.getCurrentProject();
    this.teamMembers = model.getAllTeamMembers();
    this.teamMemberOptions = FXCollections.observableArrayList();
    for (TeamMember teamMember:
         teamMembers)
    {
      this.teamMemberOptions.add(model.getName(teamMember));
    }
    this.RequirementResponsibleMember.setItems(teamMemberOptions);
    requirementDeadline.setDayCellFactory(picker -> new DateCell() {
      public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        LocalDate today = LocalDate.now();

        setDisable(empty || date.compareTo(today) < 0 );
      }
    });
    if (edit){
      this.requirementName.setText(model.getName(currentRequirement));
      this.requirementDescription.setText(model.getDescription(currentRequirement)[0]); //TODO check if it is functional or non functional
      /*System.out.println(new TimeClass(model.getDeadlineTime(currentRequirement)).getFormattedDate().split("."));
      Integer[] datum = Arrays.stream(new TimeClass(model.
          getDeadlineTime(currentRequirement)).getFormattedDate().split(".")).
          map(Integer::valueOf).toArray(Integer[]::new);*/
      this.requirementDeadline.setValue(LocalDate.now());
    } else {
      this.requirementDeadline.setValue(LocalDate.now());
      this.requirementDescription.setText("");
      this.requirementName.setText("");
    }
  }

  public Region getRoot(){
    return root;
  }

  public void confirm(ActionEvent actionEvent)
  {
    //TODO implement functional and non functional version
    if (viewHandler.getCurrentRequirement() == null){
      LocalDate date = this.requirementDeadline.getValue();
      TeamMember newTeamMember = teamMembers[this.RequirementResponsibleMember.getSelectionModel().getSelectedIndex()];
      String stringDate = date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
      model.addRequirement(
          currentProject,
          this.requirementName.getText(),
          this.requirementDescription.getText(),
          new TimeClass(stringDate).getTime(), //TODO make it to take entire date
          newTeamMember);
      System.out.println(
          Arrays.toString(model.getAllRequirements(currentProject)));
      viewHandler.openView("RequirementView");
    } else {
      Integer[] datum = Arrays.stream(new TimeClass(model.
          getDeadlineTime(currentRequirement)).getFormattedDate().split(".")).
          map(Integer::valueOf).toArray(Integer[]::new);

    }
  }

  public void openRequirementView(ActionEvent actionEvent)
  {
    this.viewHandler.openView("RequirementView");
  }
}
