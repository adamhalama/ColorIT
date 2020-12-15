package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;
import model.Task;
import model.TimeClass;

public class TaskViewController {
  public Label taskName;
  public Label taskID;
  public Label requirementID;
  public Label taskStatus;
  public Label taskDescription;
  public Label estimatedTime;
  public Label deadline;
  public Label totalTimeSpend;
  public TableColumn<TaskTrackViewModel, String> nameColumn;
  public TableView<TaskTrackViewModel> teamTable;
  public TableColumn<TaskTrackViewModel, Number> timeColumn;
  public Label responsiblePerson;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;
  private Task currentTask;
  private TaskTrackListViewController viewModel;

  public TaskViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.nameColumn.setSortable(false);
    this.timeColumn.setSortable(false);
    reset();
  }

  public void reset(){
    this.currentTask = viewHandler.getCurrentTask();
    if (currentTask == null){
      return;
    }
    this.responsiblePerson.setText(model.getName(model.getResponsibleTeamMember(currentTask)));
    this.taskName.setText(model.getName(currentTask));
    this.taskID.setText(String.valueOf(model.getTaskID(currentTask)));
    this.requirementID.setText(String.valueOf(model.getRequirementID(currentTask)));
    this.taskStatus.setText(model.getStatus(currentTask));
    this.deadline.setText(new TimeClass(model.getDeadlineTime(currentTask)).getFormattedDate());
    this.estimatedTime.setText(new TimeClass(model.getEstimatedTime(currentTask)).getFormattedTime());
    this.taskDescription.setText(model.getDescription(currentTask));
    this.totalTimeSpend.setText(String.valueOf(model.getTimeSpend(currentTask)));

    this.viewModel = new TaskTrackListViewController(model,currentTask);

    nameColumn.setCellValueFactory(
        cellDate -> cellDate.getValue().getNameProperty()
    );
    timeColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTimeProperty()
    );

    teamTable.setItems(viewModel.getTeamList());

  }

  public Region getRoot(){
    return root;
  }

  public void openRequirements()
  {
    viewHandler.openView("RequirementView");
  }

  public void add(ActionEvent actionEvent)
  {
    viewHandler.setCurrentTask(currentTask);
    viewHandler.openView("AddTeamMemberToTask");
  }

  public void delete(ActionEvent actionEvent)
  {
  }

  public void makeResponsible(ActionEvent actionEvent)
  {
  }

  public void setTimeWorked(ActionEvent actionEvent)
  {
  }
}
