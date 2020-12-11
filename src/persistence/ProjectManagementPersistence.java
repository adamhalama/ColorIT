package persistence;

import model.*;

public interface ProjectManagementPersistence
{
    public void saveProjectListToFile(ProjectList projectList);
    public void saveTeamMemberListToFile(TeamMemberList teamMemberList);
    public TeamMemberList loadTeamMembersFromFile();
    public ProjectList loadProjectsFromFile();
}
