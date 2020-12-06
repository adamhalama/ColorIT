package model;

import java.util.ArrayList;

public class Project
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

    public float getProductivityOfMember(TeamMember teamMember)
    {
        //not finished
        return 1;
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
