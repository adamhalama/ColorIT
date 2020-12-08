package model;

import java.util.ArrayList;

public class ProjectManagementModelManager implements ProjectManagementModel
{
    // need to implement methods, they are all autogenerated and empty
    // not finished

    private ProjectList projectList;
    private TeamMemberList teamMemberList;

    public ProjectManagementModelManager()
    {
        this.projectList = new ProjectList();
        this.teamMemberList = new TeamMemberList();
    }

    @Override
    public void addProject(String name, String description)
    {
        projectList.addProject(name, description);
    }

    @Override
    public Project[] getProjectsByName(String projectName)
    {
        return getProjectsByName(projectName);
    }

    @Override
    public Project[] getAllProjects()
    {
        return projectList.getAllProjects();
    }

    @Override
    public void deleteProject(int projectID)
    {
        projectList.deleteProject(projectID);
    }

    @Override
    public Project[] getProjectsByScrumMaster(TeamMember teamMember)
    {
        return projectList.getProjectsByScrumMaster(teamMember);
    }

    @Override
    public Project[] getProjectsByProductOwner(TeamMember teamMember)
    {
        return projectList.getProjectsByProductOwner(teamMember);
    }

    @Override
    public Project[] getProjectsByTeamMember(TeamMember teamMember)
    {
        return projectList.getProjectsByTeamMember(teamMember);
    }

    @Override
    public int getProjectID(Project project)
    {
        return project.getProjectID();
    }

    @Override
    public String getProjectName(Project project)
    {
        return project.getProjectName();
    }

    @Override
    public String getProjectDescription(Project project)
    {
        return project.getProjectDescription();
    }

    @Override
    public TeamMember[] getTeamMembers(Project project)
    {
        return project.getTeamMembers();
    }

    @Override
    public TeamMember getScrumMaster(Project project)
    {
        return project.getScrumMaster();
    }

    @Override
    public TeamMember getProductOwner(Project project)
    {
        return project.getProductOwner();
    }

    @Override
    public void addTeamMember(Project project, TeamMember teamMember)
    {
        project.addTeamMember(teamMember);
    }

    @Override
    public void removeTeamMember(Project project, TeamMember teamMember)
    {
        project.removeTeamMember(teamMember);
    }

    @Override
    public void setName(Project project, String name)
    {
        project.setName(name);
    }

    @Override
    public void setScrumMaster(Project project, TeamMember teamMember)
    {
        project.setScrumMaster(teamMember);
    }

    @Override
    public void setProductOwner(Project project, TeamMember teamMember)
    {
        project.setProductOwner(teamMember);
    }

    @Override
    public float getProductivityOfMember(Project project, TeamMember teamMember)
    {
        // not sure about the whole exeption thing
        // not finished
        try
        {
            return project.getProductivityOfMember(teamMember);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void setDescription(Project project, String description)
    {
        project.setDescription(description);
    }

    @Override
    public Requirement[] getRequirementsByStatus(Project project, Status status)
    {
        return project.getRequirements().getRequirementsByStatus(status);
    }

    @Override
    public void deleteRequirement(Project project, Requirement requirement)
    {
        project.getRequirements().deleteRequirement(requirement);
    }

    @Override
    public void reorderRequirements(Project project, int[] orderedRequirementsIDs)
    {
        project.getRequirements().reorderRequirements(orderedRequirementsIDs);
    }

    @Override
    public void addRequirement(Project project, String name, String nonFunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, nonFunctionalDescription, deadline, responsibleTeamMember);
    }

    @Override
    public void addRequirement(Project project, String name, String[] FunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, FunctionalDescription, deadline, responsibleTeamMember);
    }

    @Override
    public Requirement[] getAllRequirements(Project project)
    {
        return project.getRequirements().getAllRequirements();
    }

    @Override
    public Requirement[] getRequirementsBeforeDeadline(Project project, int days)
    {
        return project.getRequirements().getRequirementsBeforeDeadline(days);
    }

    @Override
    public Requirement[] getRequirementsByResponsibleTeamMember(Project project, TeamMember responsible)
    {
        return new Requirement[0];
    }

    @Override
    public Requirement getRequirementByID(Project project, int requirementID)
    {
        return project.getRequirements().getRequirementByID(requirementID);
    }

    @Override
    public Requirement[] getRequirementsByName(Project project, String name) {
        return project.getRequirements().getRequirementByName(name);
    }

    @Override
    public int getRequirementID(Requirement requirement) {
        return 0;
    }

    @Override
    public int getUsedTime(Requirement requirement) {
        return 0;
    }

    @Override
    public String getName(Requirement requirement) {
        return null;
    }

    @Override
    public boolean isFunctional(Requirement requirement) {
        return false;
    }

    @Override
    public String[] getDescription(Requirement requirement) {
        return new String[0];
    }

    @Override
    public TaskList getTasks(Requirement requirement) {
        return null;
    }

    @Override
    public int getEstimatedTime(Requirement requirement) {
        return 0;
    }

    @Override
    public TeamMember getResponsibleTeamMember(Requirement requirement) {
        return null;
    }

    @Override
    public Status getStatus(Requirement requirement) {
        return null;
    }

    @Override
    public int getDeadlineTime(Requirement requirement) {
        return 0;
    }

    @Override
    public void setName(Requirement requirement, String name) {

    }

    @Override
    public void setDescription(Requirement requirement, String description) {

    }

    @Override
    public void setDescription(Requirement requirement, String who, String what, String why) {

    }

    @Override
    public void setDeadlineTime(Requirement requirement, int newTime) {

    }

    @Override
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember) {

    }

    @Override
    public void setStatus(Requirement requirement, Status status) {

    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember) {

    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime) {

    }

    @Override
    public void ChangeTaskTimeTrack(Requirement requirement, TrackTime newTrackTime) {

    }

    @Override
    public Task[] getAllTasks(Requirement requirement) {
        return new Task[0];
    }

    @Override
    public Task[] getTasksByName(Requirement requirement, String name) {
        return new Task[0];
    }

    @Override
    public void deleteTask(Requirement requirement, Task task) {

    }

    @Override
    public void changeTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember) {

    }

    @Override
    public Task[] getTasksByStatus(Requirement requirement, Status status) {
        return new Task[0];
    }

    @Override
    public Task[] getTasksDaysBeforeDeadline(Requirement requirement, int days) {
        return new Task[0];
    }

    @Override
    public int getTaskID(Task task) {
        return 0;
    }

    @Override
    public String getName(Task task) {
        return null;
    }

    @Override
    public int getRequirementID(Task task) {
        return 0;
    }

    @Override
    public String getDescription(Task task) {
        return null;
    }

    @Override
    public int getEstimatedTime(Task task) {
        return 0;
    }

    @Override
    public int getDeadlineTime(Task task) {
        return 0;
    }

    @Override
    public int getTimeSpend(Task task) {
        return 0;
    }

    @Override
    public int getTimeSpendOfMember(Task task, TeamMember teamMember) {
        return 0;
    }

    @Override
    public TeamMember[] getTeamMember(Task task) {
        return new TeamMember[0];
    }

    @Override
    public TeamMember getResponsibleTeamMember(Task task) {
        return null;
    }

    @Override
    public Status getStatus(Task task) {
        return null;
    }

    @Override
    public void setName(Task task, String name) {

    }

    @Override
    public void setDescription(Task task, String description) {

    }

    @Override
    public void setEstimatedTime(Task task, int estimatedTime) {

    }

    @Override
    public void setDeadlineTIme(Task task, int time) {

    }

    @Override
    public void setResponsibleTeamMember(Task task, TeamMember teamMember) {

    }

    @Override
    public void setStatus(Task task, Status status) {

    }

    @Override
    public void setTimeWorked(Task task, TeamMember teamMember, int time) {

    }

    @Override
    public void addTeamMember(Task task, TeamMember teamMember) {

    }

    @Override
    public void addTeamMember(String name, String email) {

    }

    @Override
    public void deleteTeamMember(TeamMember teamMember) {

    }

    @Override
    public ArrayList<TrackTime> getTrackTime(Task task) {
        return null;
    }

    @Override
    public int getTotalTime(Task task) {
        return 0;
    }

    @Override
    public TeamMember[] getAllTeamMembers() {
        return new TeamMember[0];
    }

    @Override
    public String getEmail(TeamMember teamMember) {
        return null;
    }

    @Override
    public String getName(TeamMember teamMember) {
        return null;
    }

    @Override
    public void setEmail(TeamMember teamMember, String email) {

    }

    @Override
    public void setName(TeamMember teamMember, String name) {

    }

    @Override
    public Project[] getProjectsWorkedOn(TeamMember teamMember) {
        return new Project[0];
    }
}
