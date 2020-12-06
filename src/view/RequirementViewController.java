package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;

public class RequirementViewController {
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;

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
