package model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ProjectManagementModelManager implements ProjectManagementModel
    {

    // maybe not finished

    private ProjectList projectList;
    private TeamMemberList teamMemberList;

    public ProjectManagementModelManager()
    {
        this.projectList = new ProjectList();
        this.teamMemberList = new TeamMemberList();
        this.projectList.addProject("project number 1", "this is very good project");
        this.projectList.addProject("project number 2", "this is very bad project");
        this.projectList.addProject("project number 3", "this is very short project");
        this.projectList.addProject("project number 4", "this is very long project \n"
            + "\n"
            + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque quis arcu felis. Maecenas egestas euismod tellus, vitae consectetur ligula euismod auctor. Cras mi est, vulputate a ex eu, varius mattis ex. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc dignissim molestie ligula, varius placerat lacus egestas a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam sed elementum leo. Etiam vitae maximus magna. Donec quis pharetra massa.\n"
            + "\n"
            + "Aenean venenatis sed augue vitae volutpat. Nam consectetur ipsum et nunc cursus lobortis. Aenean ullamcorper consequat accumsan. Nullam vitae varius dolor, sed rhoncus dolor. ");
        this.projectList.addProject("project number 5", "this is very veird project");

        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");

        this.addRequirement(projectList.getAllProjects()[0],"mena","customer want to do it",1,teamMemberList.getAllTeamMembers()[0]);
        this.addRequirement(projectList.getAllProjects()[1],"meni","customer want to do it",1,teamMemberList.getAllTeamMembers()[1]);
        this.addRequirement(projectList.getAllProjects()[2],"mene","customer want to do it",1,teamMemberList.getAllTeamMembers()[2]);
        this.addRequirement(projectList.getAllProjects()[3],"meno","customer want to do it",1,teamMemberList.getAllTeamMembers()[3]);
        System.out.println(Arrays
            .toString(getAllRequirements(projectList.getAllProjects()[0])));
        /*this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","vsade@play.33games.com");
        this.teamMemberList.addTeamMember("jan michal","tu@play.33games.com");
        this.teamMemberList.addTeamMember("michal jan","tam@play.33games.com");
        this.teamMemberList.addTeamMember("martin kuklo","nikde@play.33games.com");
        this.teamMemberList.addTeamMember("michaela lazova","v888sade@play.33games.com");*/
        System.out.println(
            Arrays.toString(this.teamMemberList.getAllTeamMembers()));

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
    public void reorderRequirements(Project project, int index1, int index2)
    {
        project.getRequirements().reorderRequirements(index1, index2);
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
    }

    @Override
    public void setDescription(Requirement requirement, String description)
    {
        requirement.setDescription(description);
    }

    @Override
    public void setDescription(Requirement requirement, String who, String what, String why)
    {
        String[] description = new String[2];
        description[0] = who;
        description[1] = what;
        description[2] = why;
        requirement.setDescription(description);
    }

    @Override
    public void setDeadlineTime(Requirement requirement, int newTime) {
        requirement.setDeadlineTime(newTime);
    }

    @Override
    public void setResponsibleTeamMember(Requirement requirement, TeamMember teamMember)
    {
        requirement.setResponsibleTeamMember(teamMember);
    }

    @Override
    public void setStatus(Requirement requirement, Status status)
    {
        requirement.setStatus(status);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime,
                        String description, int deadlineTime, TeamMember responsibleTeamMember)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime, responsibleTeamMember);
    }

    @Override
    public void addTask(Requirement requirement, String name, int id, int estimatedTime, String description, int deadlineTime)
    {
        requirement.getTasks().addTask(name, estimatedTime, description, deadlineTime);
    }

    @Override
    public void ChangeTaskTrackTime(Task task, TeamMember teamMember, int newTime)
    {
        task.setTimeWorked(teamMember, newTime);
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
    public TeamMember[] getTeamMember(Task task)
    {
        return new TeamMember[0];
    }

    @Override
    public TeamMember getResponsibleTeamMember(Task task)
    {
        return null;
    }

    @Override
    public Status getStatus(Task task)
    {
        return null;
    }

    @Override
    public void setName(Task task, String name)
    {
        task.setName(name);
    }

    @Override
    public void setDescription(Task task, String description)
    {
        task.setDescription(description);
    }

    @Override
    public void setEstimatedTime(Task task, int estimatedTime)
    {
        task.setEstimatedTime(estimatedTime);
    }

    @Override
    public void setDeadlineTIme(Task task, int time)
    {
        task.setDeadlineTime(time);
    }

    @Override
    public void setResponsibleTeamMember(Task task, TeamMember teamMember)
    {
        task.setResponsibleTeamMember(teamMember);
    }

    @Override
    public void setStatus(Task task, Status status)
    {
        task.setStatus(status);
    }

    @Override
    public void setTimeWorked(Task task, TeamMember teamMember, int time)
    {
        task.setTimeWorked(teamMember, time);
    }

    @Override
    public void addTeamMember(Task task, TeamMember teamMember)
    {
        task.addTeamMember(teamMember);
    }

    @Override
    public void addTeamMember(String name, String email)
    {
        teamMemberList.addTeamMember(name, email);
    }

    @Override
    public void deleteTeamMember(TeamMember teamMember) 
    {
        teamMemberList.deleteTeamMember(teamMember);
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
    }

    @Override
    public void setName(TeamMember teamMember, String name) 
    {
        teamMember.setName(name);
    }

    @Override
    public Project[] getProjectsWorkedOn(TeamMember teamMember)
    {
        return projectList.getProjectsByTeamMember(teamMember);
    }
}
