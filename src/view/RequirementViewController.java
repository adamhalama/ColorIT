package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectManagementModel;
import model.Requirement;

public class RequirementViewController {
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

  public RequirementViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.cb.setItems(searchOptions);
  }

  public void reset(){
    cb.setTooltip(new Tooltip("Select search category"));
    //TODO parameter of the project that will be showed will be added
    requirementListView.getItems().clear();
    this.currentProject = viewHandler.getCurrentProject();

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
  }

  public void openRequirement(ActionEvent actionEvent)
  {
  }

  public void editRequirement(ActionEvent actionEvent)
  {
  }

  public void deleteRequirement(ActionEvent actionEvent)
  {
  }
}
