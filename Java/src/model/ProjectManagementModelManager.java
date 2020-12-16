package model;

import persistence.*;

public class ProjectManagementModelManager implements ProjectManagementModel
    {

    private ProjectList projectList;
    private TeamMemberList teamMemberList;

    private ProjectManagementPersistenceManager persistenceManager = new ProjectManagementPersistenceManager();

    public ProjectManagementModelManager()
    {

        this.projectList = new ProjectList();
        this.teamMemberList = new TeamMemberList();

        this.teamMemberList = persistenceManager.loadTeamMembersFromFile();
        this.projectList = persistenceManager.loadProjectsFromFile();

        /*this.projectList.addProject("project number 1", "this is very good project");
        this.projectList.addProject("project number 2", "this is very good project");
        this.projectList.addProject("project number 3", "this is very good project");
        this.projectList.addProject("project number 4", "this is very good project");
        this.projectList.addProject("project number 5", "this is very good project");*/

        /*this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");*/



        /*String[] desc = new String[3];
        desc[0] = "I ";
        desc[1] = " need to";
        desc[2] = " shit";

        this.projectList.getAllProjects()[0].getRequirements().addRequirement("Test Requirement 1", desc,
                1000000000, teamMemberList.getAllTeamMembers()[0]);
        this.projectList.getAllProjects()[0].getRequirements().addRequirement("Test Requirement 2", desc,
                1000000000, teamMemberList.getAllTeamMembers()[1]);
        this.projectList.getAllProjects()[0].getRequirements().addRequirement("Test Requirement 3", "this is a non functional desc",
                1000000000, teamMemberList.getAllTeamMembers()[2]);
        this.projectList.getAllProjects()[0].getRequirements().addRequirement("Test Requirement 4", "another non functional desc",
                1000000001, teamMemberList.getAllTeamMembers()[3]);

        this.projectList.getAllProjects()[0].getRequirements().getAllRequirements()[0].setStatus(Status.NOT_STARTED);
        this.projectList.getAllProjects()[0].getRequirements().getAllRequirements()[1].setStatus(Status.STARTED);
        this.projectList.getAllProjects()[0].getRequirements().getAllRequirements()[2].setStatus(Status.APPROVED);
        this.projectList.getAllProjects()[0].getRequirements().getAllRequirements()[3].setStatus(Status.ENDED);

        long longAsFuck = 1000000000000000000L;
        Requirement requirement1 = this.projectList.getAllProjects()[0].getRequirements().getAllRequirements()[0];
       requirement1.getTasks().addTask("Task1", 3600, "very descriptive description", 1000000);
        addTask(requirement1 ,"Task1", 1, 3600,
                "very descriptive description", longAsFuck);


        Task[] gettingAllTasks = getAllTasks(requirement1);
        for (Task tasks : gettingAllTasks)
        {
            System.out.println(tasks);
        }*/




       /*persistenceManager.saveProjectListToFile(projectList, teamMemberList);
       persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);*/



    }

    @Override
    public void addProject(String name, String description)
    {
        projectList.addProject(name, description);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public Project[] getProjectsByName(String projectName)
    {
        return projectList.getProjectsByName(projectName);
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
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
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
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void removeTeamMember(Project project, TeamMember teamMember)
    {
        project.removeTeamMember(teamMember);
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
    }

    @Override
    public void setName(Project project, String name)
    {
        projectList.setProjectName(project, name);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setScrumMaster(Project project, TeamMember teamMember)
    {
        project.setScrumMaster(teamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setProductOwner(Project project, TeamMember teamMember)
    {
        project.setProductOwner(teamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public float getProductivityOfMember(TeamMember teamMember) throws Exception {
        try
        {
            return projectList.getProductivityOfMember(teamMember);
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void setDescription(Project project, String description)
    {
        project.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public Requirement[] getRequirementsByStatus(Project project, String status)
    {
        return project.getRequirements().getRequirementsByStatus(status);
    }

    @Override
    public void deleteRequirement(Project project, Requirement requirement)
    {
        project.getRequirements().deleteRequirement(requirement);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void reorderRequirements(Project project, int index1, int index2)
    {
        project.getRequirements().reorderRequirements(index1, index2);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addRequirement(Project project, String name, String nonFunctionalDescription,
                               long deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, nonFunctionalDescription, deadline, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addRequirement(Project project, String name, String[] FunctionalDescription,
                               long deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, FunctionalDescription, deadline, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
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
    public Requirement[] getRequirementsByName(Project project, String name)
    {
        return project.getRequirements().getRequirementByName(name);
    }

    @Override
    public int getRequirementID(Requirement requirement)
    {
        return requirement.getRequirementId();
    }

    @Override
    public int getUsedTime(Requirement requirement)
    {
        return requirement.getUsedTime();
    }

    @Override
    public String getName(Requirement requirement)
    {
        return requirement.getName();
    }

    @Override
    public boolean isFunctional(Requirement requirement)
    {
        return requirement.isFunctional();
    }

    @Override
    public String[] getDescription(Requirement requirement)
    {
        return requirement.getDescription();
    }

    @Override
    public TaskList getTasks(Requirement requirement)
    {
        return requirement.getTasks();
    }

    @Override
    public int getEstimatedTime(Requirement requirement)
    {
        return requirement.getEstimatedTime();
    }

    @Override
    public TeamMember getResponsibleTeamMember(Requirement requirement)
    {
        return requirement.getResponsibleTeamMember();
    }

    @Override
    public String getStatus(Requirement requirement)
    {
        return requirement.getStatus();
    }

    @Override
    public long getDeadlineTime(Requirement requirement)
    {
        return requirement.getDeadlineTime();
    }

    @Override
    public void setName(Requirement requirement, String name)
    {
        requirement.setName(name);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setDescription(Requirement requirement, String description)
    {
        requirement.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setDescription(Requirement requirement, String who, String what, String why)
    {
        String[] description = new String[3];
        description[0] = who;
        description[1] = what;
        description[2] = why;
        requirement.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setDeadlineTime(Requirement requirement, long newTime) {
        requirement.setDeadlineTime(newTime);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember)
    {
        requirement.setResponsibleTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setStatus(Requirement requirement, String status)
    {
        requirement.setStatus(status);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, long deadlineTime, TeamMember responsibleTeamMember)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, long deadlineTime)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void ChangeTaskTrackTime(Task task, TeamMember teamMember, int newTime)
    {
        task.setTimeWorked(teamMember, newTime);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public Task[] getAllTasks(Requirement requirement)
    {
        return requirement.getTasks().getAllTasks();
    }

    @Override
    public Task[] getTasksByName(Requirement requirement, String name)
    {
        return requirement.getTasks().getTasksByName(name);
    }

    @Override
    public void deleteTask(Requirement requirement, Task task)
    {
        requirement.getTasks().deleteTask(task);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void changeTask(Task task, String name,
                           int estimatedTime, String description, long deadlineTime, TeamMember responsibleTeamMember)
    {
        task.setName(name);
        task.setEstimatedTime(estimatedTime);
        task.setDescription(description);
        task.setDeadlineTime(deadlineTime);
        task.setResponsibleTeamMember(responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public Task[] getTasksByStatus(Requirement requirement, String status)
    {
        return requirement.getTasks().getTasksByStatus(status);
    }

    @Override
    public Task[] getTasksDaysBeforeDeadline(Requirement requirement, int days)
    {
        return requirement.getTasks().getTasksDaysBeforeDeadline(days);
    }

    @Override
    public int getTaskID(Task task)
    {
        return task.getTaskID();
    }

    @Override
    public String getName(Task task)
    {
        return task.getName();
    }

    @Override
    public int getRequirementID(Task task)
    {
        return 0;
    }

    @Override
    public String getDescription(Task task)
    {
        return task.getDescription();
    }

    @Override
    public int getEstimatedTime(Task task)
    {
        return task.getEstimatedTime();
    }

    @Override
    public long getDeadlineTime(Task task)
    {
        return task.getDeadlineTime();
    }

    @Override
    public int getTimeSpend(Task task)
    {
        return task.getTimeSpent();
    }

    @Override
    public int getTimeSpendOfMember(Task task, TeamMember teamMember)
    {
        return task.getTimeSpentOfMember(teamMember);
    }

    @Override
    public TeamMember[] getTeamMembers(Task task)
    {
        return task.getTeamMembers();
    }

    @Override
    public TeamMember getResponsibleTeamMember(Task task)
    {
        return task.getResponsibleTeamMember();
    }

    @Override
    public String getStatus(Task task)
    {
        return task.getStatus();
    }

    @Override
    public void setName(Task task, String name)
    {
        task.setName(name);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setDescription(Task task, String description)
    {
        task.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setEstimatedTime(Task task, int estimatedTime)
    {
        task.setEstimatedTime(estimatedTime);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setDeadlineTIme(Task task, long time)
    {
        task.setDeadlineTime(time);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setResponsibleTeamMember(Task task, TeamMember teamMember)
    {
        task.setResponsibleTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setStatus(Task task, String status)
    {
        task.setStatus(status);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void setTimeWorked(Task task, TeamMember teamMember, int time)
    {
        task.setTimeWorked(teamMember, time);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addTeamMember(Task task, TeamMember teamMember)
    {
        task.addTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList, teamMemberList);
    }

    @Override
    public void addTeamMember(String name, String email)
    {
        teamMemberList.addTeamMember(name, email);
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
    }

    @Override
    public void deleteTeamMember(TeamMember teamMember) 
    {
        teamMemberList.deleteTeamMember(teamMember);
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
    }

    @Override
    public TrackTime[] getTrackTime(Task task)
    {
        return task.getTrackTime();
    }

    @Override
    public int getTotalTime(Task task) 
    {
        return task.getTimeSpent();
    }

    @Override
    public TeamMember[] getAllTeamMembers() 
    {
        return teamMemberList.getAllTeamMembers();
    }

    @Override
    public String getEmail(TeamMember teamMember) 
    {
        return teamMember.getEmail();
    }

    @Override
    public String getName(TeamMember teamMember) 
    {
        return teamMember.getName();
    }

    @Override
    public void setEmail(TeamMember teamMember, String email) 
    {
        teamMemberList.setTeamMemberEmail(teamMember, email);
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
    }

    @Override
    public void setName(TeamMember teamMember, String name) 
    {
        teamMember.setName(name);
        persistenceManager.saveTeamMemberListToFile(teamMemberList, projectList);
    }

    @Override
    public Project[] getProjectsWorkedOn(TeamMember teamMember)
    {
        return projectList.getProjectsByTeamMember(teamMember);
    }
}
