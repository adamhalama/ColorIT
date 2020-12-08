package model;

import java.util.ArrayList;

public class Requirement {
  private int requirementId;
  private String name;
  private int deadlineTime;
  private Description description;
  private TeamMember responsibleTeamMember;
  private Status status;
  private TaskList tasksList;

  public Requirement(int id, String name, String description, int deadline, TeamMember responsibleTeamMember) {
    this.requirementId = id;
    this.name = name;
    this.deadlineTime = deadline;
    this.responsibleTeamMember = responsibleTeamMember;
    this.status = new Status();
    this.description = new nonFunctionalDescription(description);
  }
  public Requirement(int id, String name, String[] description, int deadline, TeamMember responsibleTeamMember) {
    this.requirementId = id;
    this.name = name;
    this.deadlineTime = deadline;
    this.responsibleTeamMember = responsibleTeamMember;
    this.status = new Status();
    this.description = new functionalDescription(description);
  }

  public int getRequirementId() {
    return this.requirementId;
  }
  public String getName() {
    return this.name;
  }
  public int getDeadlineTime() {
    return this.deadlineTime;
  }
  public String[] getDescription() {
    return this.description.getDescription();
  }
  public TeamMember getResponsibleTeamMember() {
    return this.responsibleTeamMember;
  }
  public Status getStatus() {
    return this.status;
  }
  public int getUsedTime() {
    return this.tasksList.getUsedTime();
  }
  public boolean isFunctional() {
    return this.description.isFunctional();
  }
  public TaskList getTasks() {
    return this.tasksList;
  }
  public int getEstimatedTime()
  {
    Task[] tasks = this.tasksList.getAllTasks();
    int outputTime = 0;

    for (int i = 0; i < tasks.length; i++)
    {
      outputTime += tasks[i].getEstimatedTime();
    }

    return outputTime;
  }

  public void setName(String name) {
    this.name=name;
  }
  public void setDeadlineTime(int newTime) {
    this.deadlineTime=newTime;
  }
  public void setDescription(String description)
  {
    //we know that the user want to create non-functional description so we if we had non-functional description before we cas just set it
    if (this.description.isFunctional())
    {
      this.description = new nonFunctionalDescription(description);
    }
    else
      {
        ((nonFunctionalDescription) this.description).setNonFunctionalDescription(description); // I have cast the description to non functional and than I called set function
      }
  }
  public void setDescription(String[] description)
  { //now we know that we got functional description, let's check if we had functional description before
    if (this.description.isFunctional())
    {
      ((functionalDescription) this.description).setFunctionalDescription(description[0],description[1],description[2]);
    }
    else
      {
        this.description = new functionalDescription(description); // I have cast the description to non functional and than I called set function
      }
  }
  public void setResponsibleTeamMember(TeamMember teamMember) {
    this.responsibleTeamMember=teamMember;
  }
  public void setStatus(Status status) {
    this.status = status;
  }

  public String toString() {
    return "";
  }
}
