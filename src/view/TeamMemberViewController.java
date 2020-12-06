package view;

import javafx.scene.layout.Region;
import model.ProjectManagementModel;

public class TeamMemberViewController {
  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;

  public TeamMemberViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    //nothing
  }
}
