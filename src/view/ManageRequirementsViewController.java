package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectManagementModel;
import model.TeamMember;

import java.time.LocalDate;
import java.util.Arrays;

public class ManageRequirementsViewController {
  private ObservableList<String> teamMemberOptions;
  private TeamMember[] teamMembers;
  @FXML private ChoiceBox RequirementResponsibleMember;
  @FXML private TextField requirementName;
  @FXML private TextArea requirementDescription;
  @FXML private DatePicker requirementDeadline;
  private Project currentProject;

  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;

  public ManageRequirementsViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model,Region root,boolean edit){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    reset(edit);
  }

  public void reset(boolean edit){
    this.currentProject = viewHandler.getCurrentProject();
    this.teamMembers = model.getAllTeamMembers();
    this.teamMemberOptions = FXCollections.observableArrayList();
    for (TeamMember teamMember:
         teamMembers)
    {
      this.teamMemberOptions.add(teamMember.getName());
    }
    this.RequirementResponsibleMember.setItems(teamMemberOptions);
  }

  public Region getRoot(){
    return root;
  }

  public void confirm(ActionEvent actionEvent)
  {
    //TODO implement functional and non functional version
    if (viewHandler.getCurrentRequirement() == null){
      LocalDate date = this.requirementDeadline.getValue();
      TeamMember newTeamMember = teamMembers[this.RequirementResponsibleMember.getSelectionModel().getSelectedIndex()];
      model.addRequirement(
          currentProject,
          this.requirementName.getText(),
          this.requirementDescription.getText(),
          date.getYear(), //TODO make it to take entire date
          newTeamMember);
      System.out.println(
          Arrays.toString(model.getAllRequirements(currentProject)));
      viewHandler.openView("RequirementView");
    }
  }

  public void openRequirementView(ActionEvent actionEvent)
  {
    this.viewHandler.openView("RequirementView");
  }
}
