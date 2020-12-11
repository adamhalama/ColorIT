package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;

public class ManageRequirementsViewController {
  @FXML private TextField requirementName;
  @FXML private TextArea requirementDescription;
  @FXML private DatePicker requirementDeadline;
  @FXML private TextField RequirementResponsibleMember;
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
    // nothing so far but TODO reset manageReqView
  }

  public Region getRoot(){
    return root;
  }

  public void confirm(ActionEvent actionEvent)
  {
    //TODO implement functional and non functional version

  }

  public void openRequirementView(ActionEvent actionEvent)
  {
  }
}
