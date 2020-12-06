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
  public Task[] getTasks() {
    return this.tasksList.getAllTasks();
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
    this.description.setDescription(description);
  }
  public void setDescription(String[] description)
  {
    this.description.setFunctionalDescription(description[0], description[1], description[2]);
  }
  public void setResponsibleTeamMember(TeamMember teamMember) {
    this.responsibleTeamMember=teamMember;
  }
  public void setStatus(Status status) {
    this.status=new Status(status);
  }

  public String toString() {
    return "";
  }
}
