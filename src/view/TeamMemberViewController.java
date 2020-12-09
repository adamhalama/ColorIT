package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectManagementModel;
import model.TeamMember;
import model.TeamMemberList;

public class TeamMemberViewController {
  @FXML private Label errorLabel;
  @FXML private TableView<TeamMemberViewModel> teamMemberList;
  @FXML private TableColumn<TeamMemberViewModel, String> nameColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> emailColumn;
  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private TeamMemberListViewModel viewModel;

  public TeamMemberViewController(){
    //nothing
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model, Region root){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    this.viewModel = new TeamMemberListViewModel(model);

    nameColumn.setCellValueFactory(
        cellDate -> cellDate.getValue().getNameProperty()
    );
    emailColumn.setCellValueFactory(
        cellData -> cellData.getValue().getEmailProperty()
    );

    teamMemberList.setItems(viewModel.getTeamList());
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.update();
  }

  public void deleteTeamMember(ActionEvent actionEvent)
  {
    errorLabel.setText("");
    try {
      TeamMemberViewModel selectedMember = teamMemberList.getSelectionModel().getSelectedItem();
      TeamMember teamMember = new TeamMember(selectedMember.getNameProperty().get(),selectedMember.getEmailProperty().get());

      model.deleteTeamMember(teamMember);
      viewModel.remove(teamMember);
      teamMemberList.getSelectionModel().clearSelection();
    } catch (Exception e){
      errorLabel.setText("team member not found");
    }
    viewModel.update();
  }

  public void editTeamMember(ActionEvent actionEvent)
  {
    TeamMemberViewModel selectedMember = teamMemberList.getSelectionModel().getSelectedItem();
    TeamMember[] teamMembers = model.getAllTeamMembers();
    TeamMember currentTeamMember = null;
    for (TeamMember teamMember: teamMembers){
      if (teamMember.getEmail().equals(selectedMember.getEmailProperty().get()) &&
      teamMember.getName().equals(selectedMember.getNameProperty().get())){
        currentTeamMember = teamMember;
      }
    }
    if (currentTeamMember == null){
      errorLabel.setText("Member not found");
    } else {
      viewHandler.setCurrentTeamMember(currentTeamMember);
      viewHandler.openView("ManageMember");
    }
  }

  public void addTeamMember(ActionEvent actionEvent)
  {
    viewHandler.openView("AddMember");
  }
}
