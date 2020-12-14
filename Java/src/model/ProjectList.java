package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Accumulates Project class objects in an ArrayList projects
 * @author Group 6 - 1Y ICT A2020
 * @version 1.0
 * @since 1.0
 */
public class ProjectList implements Serializable
{
    /**
     * Represents the ArrayList of Project class objects
     */
    private ArrayList<Project> projects;

    /**
     * Creates the ArrayList of Project class objects
     */
    public ProjectList()
    {
        this.projects = new ArrayList<Project>();
    }

    /**
     * Creates a new Project in the ArrayList of Project class, projects.
     * @param name The name of the project
     * @param description The description of the project
     * @throws IllegalArgumentException when the name of the project has already been used,
     * and therefore doesnt create the Project
     */
    public void addProject(String name, String description)
    {
        if (getProjectsByName(name).length == 0)
            projects.add(new Project(name, description));
        else
            throw new IllegalArgumentException("The name is already used");
    }

    /**
     * Returns an array of Project class objects with projects that have the name same as the input String
     * @param projectName a String containing the name of the projects wanted as output
     * @return an array of Project class objects, representing objects that have name variable equal to the input string
     */
    public Project[] getProjectsByName(String projectName)
    {
        ArrayList<Project> foundProjects = new ArrayList<Project>();
        for (Project project : projects)
        {
            if (project.getProjectName().equalsIgnoreCase(projectName))
                foundProjects.add(project);
        }
        return foundProjects.toArray(new Project[0]);
    }

    /**
     * Returns an array of all Project class objects present in the ArrayList of Project class, projects
     * @return an array of Project class objects, representing all objects present in the ArrayList of Project class, projects
     */
    public Project[] getAllProjects()
    {
        return projects.toArray(new Project[0]);
    }

    /**
     * Deletes a project that has the same 'projectID' as the input
     * @param projectID determines which project to delete
     */
    public void deleteProject(int projectID)
    {
        for (Project project : projects)
        {
            if (project.getProjectID() == projectID)
            {
                projects.remove(project);
                break;
            }
        }
    }

    /**
     * Returns an array of Project class objects based on what ScrumMaster they have
     * @param teamMember the scrumMaster you want to search by
     * @return array of Project class objects with a specified ScrumMaster
     */
    public Project[] getProjectsByScrumMaster(TeamMember teamMember)
    {
        ArrayList<Project> foundProjects = new ArrayList<Project>();
        for (Project project : projects)
        {
            if (project.getScrumMaster().equals(teamMember))
                foundProjects.add(project);
        }
        return foundProjects.toArray(new Project[0]);
    }
    /**
     * Returns an array of Project class objects based on what ProductOwner they have
     * @param teamMember the ProductOwner you want to search by
     * @return array of Project class objects with a specified ProductOwner
     */
    public Project[] getProjectsByProductOwner(TeamMember teamMember)
    {
        ArrayList<Project> foundProjects = new ArrayList<Project>();
        for (Project project : projects)
        {
            if (project.getProductOwner().equals(teamMember))
                foundProjects.add(project);
        }
        return foundProjects.toArray(new Project[0]);
    }

    /**
     * Returns an array of Project class objects based on what TeamMember they have
     * @param teamMember the TeamMember you want to search by
     * @return array of Project class objects with a specified TeamMember
     */
    public Project[] getProjectsByTeamMember(TeamMember teamMember)
    {
        ArrayList<Project> foundProjects = new ArrayList<Project>();

        for (Project project : projects)
        {
            TeamMember[] projectTeam = project.getTeamMembers();
            for (int i = 0; i < projectTeam.length; i++)
            {
                if (projectTeam[i].equals(teamMember))
                    foundProjects.add(project);
                break;
            }
        }
        return foundProjects.toArray(new Project[0]);
    }

    /**
     * Gets the productivity of team member that equals to the ratio of estimated time and actual time spent on tasks.
     * @param teamMember The team member which we want the productivity for.
     * @return A float value representing the ratio of estimated time of ended tasks and the spent time of ended tasks.
     * @throws Exception when the team member is not in the project we want to get productivity for.
     */
    public float getProductivityOfMember(TeamMember teamMember) throws Exception
    {
        // not finished
        int spendTimeInTotal = 0;
        int estimatedTimeInTotal = 0;

        for (int k = 0; k < projects.size(); k++)
        {
            Requirement[] requirements = projects.get(k).getRequirements().getAllRequirements();

            for (int i = 0; i < requirements.length; i++)
            {
                Task[] tasks = requirements[i].getTasks().getAllTasks();

                for (int j = 0; j < tasks.length; j++)
                {
                    if (tasks[i].getStatus().equals(Status.ENDED))
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
        }

        if (spendTimeInTotal == 0 && estimatedTimeInTotal == 0)
            throw new Exception("This team member has not tracked any work");

        return (float) (estimatedTimeInTotal / spendTimeInTotal);
    }

}
