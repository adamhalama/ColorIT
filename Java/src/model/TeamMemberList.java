package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamMemberList implements Serializable
{

    private ArrayList<TeamMember> teamMembers;

    public TeamMemberList()
    {
        this.teamMembers = new ArrayList<TeamMember>();
    }

    public void addTeamMember(String name, String email)
    {
        if (name.trim().equals(""))
            throw new IllegalArgumentException("Invalid name");
        else {

            for (int i = 0; i < teamMembers.size(); i++)
                if (teamMembers.get(i).getEmail().equals(email.trim()))
                    throw new IllegalArgumentException("The email is already used");

            teamMembers.add(new TeamMember(name, email));
        }
    }

    public void setTeamMemberEmail(TeamMember teamMember, String email)
    {
        for (int i = 0; i < teamMembers.size(); i++)
            if(teamMembers.get(i).getEmail().equals(email.trim()))
                throw new IllegalArgumentException("The email is already used");


        teamMembers.get(teamMembers.indexOf(teamMember)).setEmail(email);
    }

    public void deleteTeamMember(TeamMember teamMember)
    {
        for (TeamMember teamMember1 : this.teamMembers)
            if (teamMember1.getName().equals(teamMember.getName())
                    && teamMember1.getEmail().equals(teamMember.getEmail()))
            {
                this.teamMembers.remove(teamMember1);
                System.out.println("here");
                break;
            }



        // this.teamMembers.remove(teamMember);
    }

    public TeamMember[] getAllTeamMembers()
    {
        return teamMembers.toArray(new TeamMember[0]);
    }
}
