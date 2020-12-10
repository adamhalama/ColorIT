package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Project implements Serializable
{
    private String name;
    private int projectID = 0;
    private static int idCounter;
    private String description;
    private TeamMember scrumMaster;
    private TeamMember productOwner;
    private ArrayList<TeamMember> projectTeam;
    private RequirementList requirementList;


    public Project(String name, String description) 
    {
        idCounter++;
        this.name = name;
        this.description = description;
        this.projectID = idCounter;
        this.projectTeam = new ArrayList<TeamMember>();
        this.requirementList = new RequirementList();

    }

    public String getProjectName()
    {
        return name;
    }

    public int getProjectID()
    {
        return projectID;
    }

    public String getProjectDescription()
    {
        return description;
    }

    public RequirementList getRequirements()
    {
        return requirementList;
    }

    public TeamMember[] getTeamMembers() {
        return projectTeam.toArray(new TeamMember[0]);
    }

    public TeamMember getScrumMaster() {
        return scrumMaster;
    }

    public TeamMember getProductOwner() {
        return productOwner;
    }

    public float getProductivityOfMember(TeamMember teamMember) throws Exception
    {
        // not finished
        int spendTimeInTotal = 0;
        int estimatedTimeInTotal = 0;

        if (!(projectTeam.contains(teamMember)))
        {
            throw new Exception("teamMember is not in this project");
        }

        Requirement[] requirements = getRequirements().getAllRequirements();

        for (int i = 0; i < requirements.length; i++)
        {
            Task[] tasks = requirements[i].getTasks().getAllTasks();

            for (int j = 0; j < tasks.length; j++)
            {
                if (tasks[i].getStatus() == Status.ENDED)
                {
                    ArrayList<TeamMember> taskTeamMembers
                            = new ArrayList<>(Arrays.asList(tasks[i].getTeamMembers()));

                    if (taskTeamMembers.contains(teamMember))
                    {
                        spendTimeInTotal += tasks[i].getTimeSpentOfMember(teamMember);
                        estimatedTimeInTotal += tasks[i].getEstimatedTime();
                    }
                }
            }
        }
                
        return (float) (estimatedTimeInTotal / spendTimeInTotal);
    }

    public void addTeamMember(TeamMember teamMember)
    {
        projectTeam.add(teamMember);
    }

    public void removeTeamMember(TeamMember teamMember)
    {
        projectTeam.remove(teamMember);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScrumMaster(TeamMember scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public void setProductOwner(TeamMember productOwner) {
        this.productOwner = productOwner;
    }


    /*public String toString()
    {
        String s = "";

        return
    }*/

    @Override
    public String toString() {
        return "Project " +
                "name - '" + name +
                ", projectID - " + projectID +
                ", description - '" + description +
                ", scrumMaster - " + scrumMaster +
                ", productOwner - " + productOwner +
                ", projectTeam - " + projectTeam +
                ", requirementList - " + requirementList;
    }
}
