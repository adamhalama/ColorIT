package view;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;

public class ProjectViewController {
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;

  public ProjectViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset(){
    //TODO parameter to reset will be added
  }

  public Region getRoot(){
    return root;
  }

  public void openRequirement()
  {
    viewHandler.openView("RequirementView");
  }

  public void openTeam()
  {
    viewHandler.openView("TeamMemberView");
  }
}
