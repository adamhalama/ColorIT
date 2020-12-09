package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectManagementModel;

public class RequirementViewController {
  @FXML private Label description;
  @FXML private Label projectName;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;
  private Project currentProject;

  public RequirementViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset(){
    //TODO parameter of the project that will be showed will be added
    this.errorLabel.setText("");
    this.currentProject = this.viewHandler.getCurrentProject();
    if (currentProject != null){
      this.projectName.setText(currentProject.getProjectName());
      this.description.setText(currentProject.getProjectDescription());
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
}
