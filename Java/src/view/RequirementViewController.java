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

public class RequirementViewController {
  public StackPane stackPane;

  ObservableList<String> searchOptions = FXCollections.observableArrayList("status","days before deadline","name");
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

  public RequirementViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    requirementDetailsViewController.init(viewHandler, model, root);
    this.cb.setItems(searchOptions);
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
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("unable to delete");
      alert.setHeaderText("It was not able to remove it, please try it later.");
      alert.show();
    }
  }
}
