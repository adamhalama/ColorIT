package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Project;
import model.ProjectManagementModel;
import model.TeamMember;

public class ProjectTeamViewModel
{
  private StringProperty nameProperty;
  private StringProperty roleProperty;

  public ProjectTeamViewModel(TeamMember teamMember, Project currentProject, ProjectManagementModel model){
    nameProperty = new SimpleStringProperty(teamMember.getName());
    if (model.getProductOwner(currentProject)!=null && model.getProductOwner(currentProject).equals(teamMember)){
      roleProperty = new SimpleStringProperty("product owner");
    } else if (model.getScrumMaster(currentProject)!=null && model.getScrumMaster(currentProject).equals(teamMember)){
      roleProperty = new SimpleStringProperty("scrum master");
    } else {
      roleProperty = new SimpleStringProperty("");
    }
  }

  public StringProperty getRoleProperty()
  {
    return roleProperty;
  }

  public StringProperty getNameProperty(){
    return nameProperty;
  }
}
