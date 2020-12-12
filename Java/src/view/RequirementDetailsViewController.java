package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;
import model.Requirement;

public class RequirementDetailsViewController
{
  @FXML private Label requirementName;
  @FXML private Label requirementID;
  @FXML private Label reasTeamMember;
  @FXML private Label deadline;
  @FXML private Label status;
  @FXML private Label description;

  private ViewHandler viewHandler;
  private ProjectManagementModel model;
  private Region root;
  private Requirement currentRequirement;

  public RequirementDetailsViewController() {
    //just to have own constructor
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset(){
    currentRequirement = viewHandler.getCurrentRequirement();
    if (currentRequirement == null){
      return;
    }
    this.requirementName.setText(model.getName(currentRequirement));
    this.requirementID.setText(String.valueOf(model.getRequirementID(currentRequirement)));
    String [] desc = model.getDescription(currentRequirement);
    if (model.isFunctional(currentRequirement)){
      String finalDescription = "";
      finalDescription += "As a "+desc[0]+
          "I want to " + desc[1] +
          " such that " + desc[2];
      this.description.setText(finalDescription);
    } else {
      this.description.setText(desc[0]);
    }
    this.reasTeamMember.setText(currentRequirement.getResponsibleTeamMember().getName());
    this.status.setText(currentRequirement.getStatus().toString());
    this.deadline.setText(String.valueOf(currentRequirement.getDeadlineTime()));
    //TODO add estimated time
  }
  
  public Region getRoot(){
    return root;
  }

  public void addTask(ActionEvent actionEvent)
  {
  }

  public void openTask(ActionEvent actionEvent)
  {
  }

  public void editTask(ActionEvent actionEvent)
  {
  }

  public void deleteTask(ActionEvent actionEvent)
  {
  }
}
