package model;

public interface ProjectManagementModel
{
    public void addProject(String name, String description);
    public Project[] getProjectsByName(String projectName);
    public Project[] getAllProjects();
    public void deleteProject(int projectID);
    public Project[] getProjectsByScrumMaster(TeamMember teamMember);
    public Project[] getProjectsByProductOwner(TeamMember teamMember);
    public Project[] getProjectsByTeamMember(TeamMember teamMember);
    public int getProjectID(Project project);
    public String getProjectName(Project project);
    public String getProjectDescription(Project project);
    public TeamMember[] getTeamMembers(Project project);
    public TeamMember getScrumMaster(Project project);
    public TeamMember getProductOwner(Project project);
    public void addTeamMember(Project project, TeamMember teamMember);
    public void removeTeamMember(Project project, TeamMember teamMember);
    public void setName(Project project, String name);
    public void setScrumMaster(Project project, TeamMember teamMember);
    public void setProductOwner(Project project, TeamMember teamMember);
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public
    public


}
