package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Project;
import model.ProjectManagementModel;
import model.Requirement;
import model.TeamMember;

public class RequirementViewController {
  public StackPane stackPane;
  public TableColumn<ProjectTeamViewModel, String> nameColumn;
  public TableColumn<ProjectTeamViewModel, String> roleColumn;
  @FXML private ChoiceBox chooseRoleBox;
  @FXML private TableView<ProjectTeamViewModel> projectTeamList;
  private ProjecTeamListViewModel viewModel;

  @FXML private TextField searchValue;
  @FXML private ChoiceBox cb;
  @FXML private ListView<String> requirementListView;
  @FXML private Label description;
  @FXML private Label projectName;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;
  private Project currentProject;
  private Requirement[] requirements;
  @FXML private RequirementDetailsViewController requirementDetailsViewController;
  private TeamMember[] projectTeam;

  public RequirementViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    requirementDetailsViewController.init(viewHandler, model, root);
    this.chooseRoleBox.getItems().addAll("Scrum master","Product owner");
    this.cb.getItems().addAll("status","days before deadline","name");
  }

  public void reset(){

    cb.setTooltip(new Tooltip("Select search category"));
    requirementListView.getItems().clear();
    this.currentProject = viewHandler.getCurrentProject();
    requirementDetailsViewController.reset();

    if (this.currentProject != null)
    {
      this.requirements = model.getAllRequirements(this.currentProject);
      for (Requirement requirement: requirements)
      {
        requirementListView.getItems().add(requirement.getName());
      }

      this.viewModel = new ProjecTeamListViewModel(model,currentProject);

      nameColumn.setCellValueFactory(
          cellDate -> cellDate.getValue().getNameProperty()
      );
      roleColumn.setCellValueFactory(
          cellData -> cellData.getValue().getRoleProperty()
      );

      projectTeamList.setItems(viewModel.getTeamList());

      projectTeam = model.getTeamMembers(currentProject);
    }

    //this.errorLabel.setText("");
    this.currentProject = this.viewHandler.getCurrentProject();
    if (currentProject != null){
      this.projectName.setText(currentProject.getProjectName());
      this.description.setText(currentProject.getProjectDescription());
      this.description.prefHeight(Region.USE_COMPUTED_SIZE);
    } else {
      errorLabel.setText("error have occurred");
    }
  }

  public Region getRoot(){
    return root;
  }

  public void openTasks()
  {
    viewHandler.openView("TaskView");
  }

  public void openProject()
  {
    viewHandler.openView("ProjectView");
  }

  public void search(ActionEvent actionEvent)
  {
  }

  public void morePriority(ActionEvent actionEvent)
  {
  }

  public void lessPriority(ActionEvent actionEvent)
  {
  }

  public void addRequirement(ActionEvent actionEvent)
  {
    this.viewHandler.setCurrentRequirement(null);
    stackPane.getChildren().get(0).setVisible(false);
    this.viewHandler.openView("AddRequirement");
  }

  public void openRequirement()
  {
    this.viewHandler.setCurrentRequirement(requirements[requirementListView.getSelectionModel()
        .getSelectedIndices().get(0)]);
    stackPane.getChildren().get(0).setVisible(true);
    requirementDetailsViewController.reset();
  }

  public void editRequirement(ActionEvent actionEvent)
  {
    this.viewHandler.setCurrentRequirement(
        requirements[this.requirementListView.getSelectionModel().getSelectedIndex()]
    );
    this.viewHandler.openView("ManageRequirement");
  }

  public void deleteRequirement(ActionEvent actionEvent)
  {
    int index = this.requirementListView.getSelectionModel().getSelectedIndex();
    try {
      model.deleteRequirement(currentProject,requirements[index]);
      requirementListView.getItems().remove(index);
      stackPane.getChildren().get(0).setVisible(false);
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("unable to delete");
      alert.setHeaderText("It was not able to remove it, please try it later.");
      alert.show();
    }
  }

  public void addTeamMember(ActionEvent actionEvent)
  {
    viewHandler.setCurrentProject(currentProject);
    viewHandler.openView("AddTeamMemberToProject");
  }

  public void deleteTeamMember(ActionEvent actionEvent)
  {
    int index = this.projectTeamList.getSelectionModel().getSelectedIndex();
    model.removeTeamMember(currentProject,projectTeam[index]);
    viewModel.remove(projectTeam[index]);
    projectTeamList.getSelectionModel().clearSelection();
    this.reset();
  }

  public void changeRole()
  {
    int index = this.projectTeamList.getSelectionModel().getFocusedIndex();
    if (index < 0){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("select team member");
      alert.setHeaderText("You need to select team member to which you want to change role.");
      alert.show();
      return;
    }
    switch (this.chooseRoleBox.getSelectionModel().getSelectedIndex()) {
      case 0:/*scrum master*/ model.setScrumMaster(currentProject,projectTeam[index]); break;
      case 1:/*product owner*/ model.setProductOwner(currentProject,projectTeam[index]); break;
      default: Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("select what new role");
        alert.setHeaderText("You need to select new role that you want to be assigned.");
        alert.show();
    }
    this.reset();
  }
}
