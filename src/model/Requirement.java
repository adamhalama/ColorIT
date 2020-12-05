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
    this.requirementId=id;
    this.name=name;
    this.deadlineTime=deadline;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status=new Status();
    this.description=new Description(description);
  }
  public Requirement(int id, String name, String[] description, int deadline, TeamMember responsibleTeamMember) {
    this.requirementId=id;
    this.name=name;
    this.deadlineTime=deadline;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status=new Status();
    this.description=new Description(description);
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
  public int getEstimatedTime() {
    return this.tasksList.getEstimatedTime();
  }

  public void setName(String name) {
    this.name=name;
  }
  public void setDeadlineTime(int newTime) {
    this.deadlineTime=newTime;
  }
  public void setDescription(String description) {
    this.description=new Description(description);
  }
  public void setDescription(String[] description) {
    this.description=new Description(description);
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
