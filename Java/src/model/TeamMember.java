package model;

import java.io.Serializable;

public class TeamMember implements Serializable
{
    private String name;
    private Email email;

    public TeamMember(String name, String email)
    {
        this.name = name;
        this.email = new Email(email);
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email.getEmail();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {

        this.email.setEmail(email);
    }

    public boolean equals(TeamMember teamMember)
    {
        if(!(teamMember instanceof TeamMember))
            return false;

        return this.name.equals(teamMember.getName()) &&
                this.email.equals(teamMember.getEmail());
    }

    public String toString()
    {
        return name + ", " + email;
    }

}
