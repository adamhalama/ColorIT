package model;

import java.io.Serializable;
import java.util.ArrayList;


/** Accumulates Project class objects in an ArrayList projects
 * @author Adam Halama
 * @version 1.0
 * @since 1.0
 */
public class ProjectList implements Serializable
{
    /** Represents the ArrayList of Project class objects
     */
    private ArrayList<Project> projects;

    /** Creates the ArrayList of Project class objects
     */
    public ProjectList()
    {
        this.projects = new ArrayList<Project>();
    }

    /** Creates a new Project class object in the ArrayList of Project class, projects
     * @param name The name of the project
     * @param description The description of the project
     */
    public void addProject(String name, String description)
    {
        if (getProjectsByName(name).length == 0)
            projects.add(new Project(name, description));
        else
            throw new IllegalArgumentException("The name is already used");
    }

    /** Returns an array of Project class objects with projects that have the name same as the input String
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

    /** Returns an array of all Project class objects present in the ArrayList of Project class, projects
     * @return an array of Project class objects, representing all objects present in the ArrayList of Project class, projects
     */
    public Project[] getAllProjects()
    {
        return projects.toArray(new Project[0]);
    }

    /** Deletes a project that has the same 'projectID' as the input
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


}
