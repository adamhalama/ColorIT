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
  @FXML private TableView<ProjectTeamViewModel> projectTeamList;

  public TableView<RequirementViewModel> requirementTable;
  public TableColumn<RequirementViewModel, String> reqNameColumn;
  public TableColumn<RequirementViewModel, String> reqStatusColumn;
  public TableColumn<RequirementViewModel, String> reqEstiTimeColumn;
  public TableColumn<RequirementViewModel, String> reqUsedTimeColumn;
  private RequirementListViewModel viewModel2;

  @FXML private ChoiceBox<String> chooseRoleBox;

  private ProjecTeamListViewModel viewModel;

  @FXML private TextField searchValue;
  @FXML private ChoiceBox<String> cb;
  @FXML private Label description;
  @FXML private Label projectName;
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
    nameColumn.setSortable(false);
    roleColumn.setSortable(false);
  }

  public void reset(){

    cb.setTooltip(new Tooltip("Select search category"));
    this.currentProject = viewHandler.getCurrentProject();
    requirementDetailsViewController.reset();

    if (this.currentProject != null)
    {
      this.requirements = model.getAllRequirements(this.currentProject);

      this.viewModel = new ProjecTeamListViewModel(model,currentProject);
      this.viewModel2 = new RequirementListViewModel(model,currentProject);

        nameColumn.setCellValueFactory(
            cellDate -> cellDate.getValue().getNameProperty()
        );
        roleColumn.setCellValueFactory(
            cellData -> cellData.getValue().getRoleProperty()
        );

      projectTeamList.setItems(viewModel.getTeamList());

      projectTeam = model.getTeamMembers(currentProject);

      this.viewModel2 = new RequirementListViewModel(model,currentProject);

      reqNameColumn.setCellValueFactory(
          cellDate -> cellDate.getValue().getNameProperty()
      );
      reqEstiTimeColumn.setCellValueFactory(
          cellDate -> cellDate.getValue().getReqEstiTimeProperty()
      );
      reqStatusColumn.setCellValueFactory(
          cellDate -> cellDate.getValue().getStatusProperty()
      );
      reqUsedTimeColumn.setCellValueFactory(
          cellDate -> cellDate.getValue().getReqUsedTimeProperty()
      );

      requirementTable.setItems(viewModel2.getReqList());

      this.projectName.setText(currentProject.getProjectName());
      this.description.setText(currentProject.getProjectDescription());
      this.description.prefHeight(Region.USE_COMPUTED_SIZE);
    }
  }

  public Region getRoot(){
    return root;
  }

  public void openProject()
  {
    viewHandler.openView("ProjectView");
  }

  public void search()
  {
    //TODO make search :P
  }

  public void morePriority()
  {
    int i = requirementTable.getSelectionModel().getFocusedIndex();
    try {
      model.reorderRequirements(currentProject,i,i-1);
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("not possible");
      alert.setHeaderText("Sorry but it is not possible to move the requirement more up.");
      alert.show();
    }
    reset();
  }

  public void lessPriority()
  {
    int i = requirementTable.getSelectionModel().getFocusedIndex();
    try {
      model.reorderRequirements(currentProject,i,i+1);
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("not possible");
      alert.setHeaderText("Sorry but it is not possible to move the requirement more down.");
      alert.show();
    }
    reset();
  }

  public void addRequirement()
  {
    this.viewHandler.setCurrentRequirement(null);
    stackPane.getChildren().get(0).setVisible(false);
    this.viewHandler.openView("AddRequirement");
  }

  public void openRequirement()
  {
    this.viewHandler.setCurrentRequirement(requirements[requirementTable.getSelectionModel().getFocusedIndex()]);
    stackPane.getChildren().get(0).setVisible(true);
    requirementDetailsViewController.reset();
  }

  public void editRequirement()
  {
    this.viewHandler.setCurrentRequirement(
        requirements[requirementTable.getSelectionModel().getFocusedIndex()]
    );
    this.viewHandler.openView("ManageRequirement");
  }

  public void deleteRequirement()
  {
    int index = this.requirementTable.getSelectionModel().getFocusedIndex();
    try {
      model.deleteRequirement(currentProject,requirements[index]);
      viewModel2.remove(requirements[index]);
      stackPane.getChildren().get(0).setVisible(false);
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("unable to delete");
      alert.setHeaderText("It was not able to remove it, please try it later.");
      alert.show();
    }
  }

  public void addTeamMember()
  {
    viewHandler.setCurrentProject(currentProject);
    viewHandler.openView("AddTeamMemberToProject");
  }

  public void deleteTeamMember()
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
