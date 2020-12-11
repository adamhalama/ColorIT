package model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import persistence.*;

public class ProjectManagementModelManager implements ProjectManagementModel
    {

    // maybe not finished

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
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");

        persistenceManager.saveTeamMemberListToFile(teamMemberList);*/

        /*this.teamMemberList.deleteTeamMember(new TeamMember("martin kuklo","nikde@play.33games.com"));
        System.out.println(
            Arrays.toString(this.teamMemberList.getAllTeamMembers()));*/



        /*JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");
        System.out.println(jo.toString());
        try
        {
            File file = new File("./data.json");
            PrintWriter out = new PrintWriter(file);
            out.println(jo.toString());
            out.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }*/
    }

    @Override
    public void addProject(String name, String description)
    {
        projectList.addProject(name, description);
        persistenceManager.saveProjectListToFile(projectList);
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
        persistenceManager.saveProjectListToFile(projectList);
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
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public void removeTeamMember(Project project, TeamMember teamMember)
    {
        project.removeTeamMember(teamMember);
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public void setName(Project project, String name)
    {
        project.setName(name);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setScrumMaster(Project project, TeamMember teamMember)
    {
        project.setScrumMaster(teamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setProductOwner(Project project, TeamMember teamMember)
    {
        project.setProductOwner(teamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public float getProductivityOfMember(Project project, TeamMember teamMember)
    {
        // not sure about the whole exception thing
        // maybe not finished
        // TODO
        try {
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
        persistenceManager.saveProjectListToFile(projectList);
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
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void reorderRequirements(Project project, int index1, int index2)
    {
        project.getRequirements().reorderRequirements(index1, index2);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addRequirement(Project project, String name, String nonFunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, nonFunctionalDescription, deadline, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addRequirement(Project project, String name, String[] FunctionalDescription,
                               int deadline, TeamMember responsibleTeamMember)
    {
        project.getRequirements().addRequirement(name, FunctionalDescription, deadline, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList);
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
    public Status getStatus(Requirement requirement)
    {
        return requirement.getStatus();
    }

    @Override
    public int getDeadlineTime(Requirement requirement)
    {
        return requirement.getDeadlineTime();
    }

    @Override
    public void setName(Requirement requirement, String name)
    {
        requirement.setName(name);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setDescription(Requirement requirement, String description)
    {
        requirement.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setDescription(Requirement requirement, String who, String what, String why)
    {
        String[] description = new String[3];
        description[0] = who;
        description[1] = what;
        description[2] = why;
        requirement.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setDeadlineTime(Requirement requirement, int newTime) {
        requirement.setDeadlineTime(newTime);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember)
    {
        requirement.setResponsibleTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setStatus(Requirement requirement, Status status)
    {
        requirement.setStatus(status);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, int deadlineTime, TeamMember responsibleTeamMember)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime, responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void ChangeTaskTrackTime(Task task, TeamMember teamMember, int newTime)
    {
        task.setTimeWorked(teamMember, newTime);
        persistenceManager.saveProjectListToFile(projectList);
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
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void changeTask(Task task, String name,
                           int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember)
    {
        task.setName(name);
        task.setEstimatedTime(estimatedTime);
        task.setDescription(description);
        task.setDeadlineTime(deadlineTime);
        task.setResponsibleTeamMember(responsibleTeamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public Task[] getTasksByStatus(Requirement requirement, Status status)
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
    public int getDeadlineTime(Task task)
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
    public Status getStatus(Task task)
    {
        return task.getStatus();
    }

    @Override
    public void setName(Task task, String name)
    {
        task.setName(name);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setDescription(Task task, String description)
    {
        task.setDescription(description);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setEstimatedTime(Task task, int estimatedTime)
    {
        task.setEstimatedTime(estimatedTime);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setDeadlineTIme(Task task, int time)
    {
        task.setDeadlineTime(time);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setResponsibleTeamMember(Task task, TeamMember teamMember)
    {
        task.setResponsibleTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setStatus(Task task, Status status)
    {
        task.setStatus(status);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void setTimeWorked(Task task, TeamMember teamMember, int time)
    {
        task.setTimeWorked(teamMember, time);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addTeamMember(Task task, TeamMember teamMember)
    {
        task.addTeamMember(teamMember);
        persistenceManager.saveProjectListToFile(projectList);
    }

    @Override
    public void addTeamMember(String name, String email)
    {
        teamMemberList.addTeamMember(name, email);
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public void deleteTeamMember(TeamMember teamMember) 
    {
        teamMemberList.deleteTeamMember(teamMember);
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
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
        teamMember.setEmail(email);
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public void setName(TeamMember teamMember, String name) 
    {
        teamMember.setName(name);
        persistenceManager.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public Project[] getProjectsWorkedOn(TeamMember teamMember)
    {
        return projectList.getProjectsByTeamMember(teamMember);
    }
}
