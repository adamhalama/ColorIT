package model;

import java.util.ArrayList;

public class TeamMemberList
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
        teamMembers.remove(teamMember);
    }

    public TeamMember[] getAllTeamMembers()
    {
        return teamMembers.toArray(new TeamMember[0]);
    }
}
