package model;

import java.io.Serializable;
import java.util.ArrayList;

class TeamMemberList implements Serializable
{

    private ArrayList<TeamMember> teamMembers;

    public TeamMemberList()
    {
        this.teamMembers = new ArrayList<TeamMember>();
    }

    public void addTeamMember(String name, String email)
    {
        teamMembers.add(new TeamMember(name, email));
    }

    public void deleteTeamMember(TeamMember teamMember)
    {
        for (TeamMember teamMember1 : teamMembers)
            if (teamMember1.getName().equals(teamMember.getName())
                    && teamMember1.getEmail().equals(teamMember.getEmail()))
            {
                teamMembers.remove(teamMember1);
                System.out.println("here");
            }



        // this.teamMembers.remove(teamMember);
    }

    public TeamMember[] getAllTeamMembers()
    {
        return teamMembers.toArray(new TeamMember[0]);
    }
}
