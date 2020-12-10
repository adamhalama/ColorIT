package persistence;

import model.ProjectList;
import model.TeamMemberList;

public class ProjectManagementPersistenceManager implements ProjectManagementPersistence
{
    FileHandling fileHandling = new FileHandling();

    @Override
    public void saveProjectListToFile(ProjectList projectList)
    {
        fileHandling.saveProjectListToFile(projectList);
    }

    @Override
    public void saveTeamMemberListToFile(TeamMemberList teamMemberList)
    {
        fileHandling.saveTeamMemberListToFile(teamMemberList);
    }

    @Override
    public TeamMemberList loadTeamMembersFromFile()
    {
        return fileHandling.loadTeamMembersFromFile();
    }

    @Override
    public ProjectList loadProjectsFromFile()
    {
        return fileHandling.loadProjectsFromFile();
    }
}
