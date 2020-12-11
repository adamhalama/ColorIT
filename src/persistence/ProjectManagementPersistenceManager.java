package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProjectManagementPersistenceManager implements ProjectManagementPersistence
{
    FileHandling fileHandling = new FileHandling();

    @Override
    public void saveProjectListToFile(ProjectList projectList)
    {
        fileHandling.saveProjectListToFile(projectList);
        this.saveToJson(projectList);
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

    private void saveToJson(ProjectList projectList) {
        JSONObject jsonData = new JSONObject();
        JSONArray projectsArray = new JSONArray();
        for (Project project : projectList.getAllProjects())
        {
            JSONObject projectObject = new JSONObject();
            projectObject.put("id", project.getProjectID());
            projectObject.put("name", project.getProjectName());
            projectObject.put("description", project.getProjectDescription());
            JSONArray requirementsArray = new JSONArray();
            for (Requirement requirement : project.getRequirements().getAllRequirements())
            {
                JSONObject requirementObject = new JSONObject();
                projectObject.put("id", requirement.getRequirementId());
                projectObject.put("name", requirement.getName());
                projectObject.put("description", requirement.getDescription());
                projectObject.put("status", requirement.getStatus());
                projectObject.put("deadline", requirement.getDeadlineTime());
                requirementsArray.put(requirementObject);
            }
            projectObject.put("requirements", requirementsArray);
            projectsArray.put(projectObject);
        }
        jsonData.put("projects", projectsArray);

        try
        {
            File file = new File("./data.json");
            PrintWriter out = new PrintWriter(file);
            out.println(jsonData.toString());
            out.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
