package persistence;

import model.ProjectList;
import model.TeamMemberList;
import java.io.*;

public class FileHandling
{
    private TeamMemberList teamMemberList;
    private ProjectList projectList;

    public TeamMemberList loadTeamMembersFromFile() {
        teamMemberList = new TeamMemberList();
        String filename = "./TeamMemberList.bin";
        ObjectInputStream in = null;

        try
        {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            try
            {
                teamMemberList = (TeamMemberList) in.readObject();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (EOFException e)
        {
            System.out.print("The file is empty");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                in.close();
            }
            catch (NullPointerException e)
            {
                System.out.println(", error while closing, because the file is empty.");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("reading from : " + filename +
                " complete");
        return teamMemberList;
    }

    public ProjectList loadProjectsFromFile() {
        projectList = new ProjectList();
        String filename = "./ProjectList.bin";
        ObjectInputStream in = null;

        try
        {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            try 
            {
                projectList = (ProjectList) in.readObject();    
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (EOFException e)
        {
            System.out.print("The file is empty");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                in.close();
            }
            catch (NullPointerException e)
            {
                System.out.println(", error while closing, because the file is empty.");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("reading from : " + filename +
                " complete");
        return projectList;
    }

    public void saveTeamMemberListToFile(TeamMemberList teamMemberList)
    {
        String filename = "./TeamMemberList.bin";

        ObjectOutputStream out = null;

        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);

                out.writeObject(teamMemberList);
        }
        catch (IOException e)
        {
            System.out.println("did not save to - " + filename);
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("saving to : " + filename +
                " complete");
    }

    public void saveProjectListToFile(ProjectList projectList)
    {
        String filename = "./ProjectList.bin";

        ObjectOutputStream out = null;

        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);

            out.writeObject(projectList);
        }
        catch (IOException e)
        {
            System.out.println("did not save to - " + filename);
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("saving to : " + filename +
                " complete");

    }




    
    
}
