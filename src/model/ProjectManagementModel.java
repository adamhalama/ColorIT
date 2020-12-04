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
    public float getProductivityOfMember(Project project, TeamMember teamMember);
    public void setDescription(Project project, String description);
    public Requirement[] getRequirementsByStatus(Project project, Status status);
    public void deleteRequirement(Project project, Requirement requirement);
    public void reorderRequirements(int[] orderedRequirementsIDs);
    public void addRequirement(Project project, String name, String nonFunctionalDescription, int deadline, TeamMember responsibleTeamMember);
    public void addRequirement(Project project, String name, String[] FunctionalDescription, int deadline, TeamMember responsibleTeamMember);
    public Requirement[] getAllRequirements(Project project);
    public Requirement[] getRequirementsBeforeDeadline(Project project, int days);
    public Requirement[] getRequirementsByResponsibleTeamMember(Project project, TeamMember responsible);
    public Requirement getRequirementByID(Project project, int requirementID);
    public Requirement[] getRequirementsByName(Project project, String name);
    public int getRequirementID(Requirement requirement);
    public int getUsedTime(Requirement requirement);
    public String getName(Requirement requirement);
    public boolean isFunctional(Requirement requirement);
    public String[] getDescription(Requirement requirement);
    public TaskList getTasks(Requirement requirement);
    public int getEstimatedTime(Requirement requirement);
    public TeamMember getResponsibleTeamMember(Requirement requirement);
    public Status getStatus(Requirement requirement);
    public int getDeadlineTime(Requirement requirement);
    public void setName(Requirement requirement, String name);
    public void setDescription(Requirement requirement, String description);
    public void setDescription(Requirement requirement, String who, String what, String why);
    public void setDeadlineTime(Requirement requirement, int newTime);
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember);
    public void setStatus(Requirement requirement, Status status);
    public void addTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember);
    public void ChangeTaskTimeTrack(Requirement requirement, TrackTime newTrackTime);
    public Task[] getAllTasks(Requirement requirement);
    public Task[] getTasksByName(Requirement requirement, String name);
    public void deleteTask(Requirement requirement, Task task);
    public void changeTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember);
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
