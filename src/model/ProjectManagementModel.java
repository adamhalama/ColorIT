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
    public Requirement[] getRequirementsByStatus(Project project, String status);
    public void deleteRequirement(Project project, Requirement requirement);
    public void reorderRequirements(Project project, int index1, int index2);
    public void addRequirement(Project project, String name, String nonFunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember);
    public void addRequirement(Project project, String name, String[] FunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember);
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
    public String getStatus(Requirement requirement);
    public long getDeadlineTime(Requirement requirement);
    public void setName(Requirement requirement, String name);
    public void setDescription(Requirement requirement, String description);
    public void setDescription(Requirement requirement, String who, String what, String why);
    public void setDeadlineTime(Requirement requirement, int newTime);
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember);
    public void setStatus(Requirement requirement, String status);
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, int deadlineTime, TeamMember responsibleTeamMember);
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, int deadlineTime);
    public void ChangeTaskTrackTime(Task task, TeamMember teamMember, int newTime);
    public Task[] getAllTasks(Requirement requirement);
    public Task[] getTasksByName(Requirement requirement, String name);
    public void deleteTask(Requirement requirement, Task task);
    public void changeTask(Task task, String name, int estimatedTime, String description,
                           int deadlineTime, TeamMember responsibleTeamMember);
    public Task[] getTasksByStatus(Requirement requirement, String status);
    public Task[] getTasksDaysBeforeDeadline(Requirement requirement, int days);
    public int getTaskID(Task task);
    public String getName(Task task);
    public int getRequirementID(Task task);
    public String getDescription(Task task);
    public int getEstimatedTime(Task task);
    public int getDeadlineTime(Task task);
    public int getTimeSpend(Task task);
    public int getTimeSpendOfMember(Task task, TeamMember teamMember);
    public TeamMember[] getTeamMembers(Task task);
    public TeamMember getResponsibleTeamMember(Task task);
    public String getStatus(Task task);
    public void setName(Task task, String name);
    public void setDescription(Task task, String description);
    public void setEstimatedTime(Task task, int estimatedTime);
    public void setDeadlineTIme(Task task, int time);
    public void setResponsibleTeamMember(Task task, TeamMember teamMember);
    public void setStatus(Task task, String status);
    public void setTimeWorked(Task task, TeamMember teamMember, int time);
    public void addTeamMember(Task task, TeamMember teamMember);
    public void addTeamMember(String name, String email);
    public void deleteTeamMember(TeamMember teamMember);
    public TrackTime[] getTrackTime(Task task);
    public int getTotalTime(Task task);
    public TeamMember[] getAllTeamMembers();
    public String getEmail(TeamMember teamMember);
    public String getName(TeamMember teamMember);
    public void setEmail(TeamMember teamMember, String email);
    public void setName(TeamMember teamMember, String name);
    public Project[] getProjectsWorkedOn(TeamMember teamMember);
}
