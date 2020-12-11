package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;

public class TaskViewController {
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;

  public TaskViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset(){
    //nothing
  }

  public Region getRoot(){
    return root;
  }

  public void openRequirements()
  {
    viewHandler.openView("RequirementView");
  }
}
