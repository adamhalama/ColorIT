package model;

import java.util.ArrayList;


/** Accumulates Project class objects in an ArrayList projects
 * @author Adam Halama
 * @version 1.0
 * @since 1.0
 */
public class ProjectList
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
        projects.add(new Project(name, description));
    }

    /** Returns an array of Project class objects with projects that have the name
     *
     * @param projectName
     * @return
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

    public Project[] getAllProjects()
    {
        return projects.toArray(new Project[0]);
    }

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

    public Project[] getProjectsByScumMaster(TeamMember teamMember)
    {
        ArrayList<Project> foundProjects = new ArrayList<Project>();
        for (Project project : projects)
        {
            if (project.getScrumMaster().equals(teamMember))
                foundProjects.add(project);
        }
        return foundProjects.toArray(new Project[0]);
    }

    public Project[] getProjectsByScrumMaster(TeamMember teamMember)
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
