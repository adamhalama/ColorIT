package model;

import java.util.ArrayList;

public class Task {
  private int id;
  private String name;
  private String description;
  private int estimatedTime;
  private int deadlineTime;
  private TeamMember responsibleTeamMember;
  private Status status;
  private TrackTimeList trackTimeList;

  public Task(String name, int id, int estimatedTime, String description, int deadlineTime) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.deadlineTime=deadlineTime;
    this.estimatedTime=estimatedTime;
    this.status=Status.NOTSTARTED;
  }
  public Task(String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.deadlineTime=deadlineTime;
    this.estimatedTime=estimatedTime;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status=Status.NOTSTARTED;
  }

  public int getTaskID() {
    return this.id;
  }
  /*public int getRequirementID() {
    return super.get;
  }*/
  public String getName() {
    return this.name;
  }
  public String getDescription() {
    return this.description;
  }
  public int getEstimatedTime() {
    return this.estimatedTime;
  }
  public int getDeadlineTime() {
    return this.deadlineTime;
  }
  public int getTimeSpent() {
    return this.trackTimeList.getTotaltime();
  }
  public int getTimeSpentOfMember(TeamMember teamMember) {
    return this.trackTimeList.getTimeOfMember(teamMember);
  }
  public TeamMember[] getTeamMembers() {
    return this.trackTimeList.getTeamMembers();
  }
  public TeamMember getResponsibleTeamMember() {
    return this.responsibleTeamMember;
  }
  public Status getStatus() {
    return this.status;
  }
  public TrackTime[] getTrackTime() {
    return this.trackTimeList.getTrackTime();
  }

  public void setName(String name) {
    this.name=name;
  }
  public void setDescription(String description) {
    this.description=description;
  }
  public void setDeadlineTime(int time) {
    this.deadlineTime=time;
  }
  public void setEstimatedTime(int estimatedTime) {
    this.estimatedTime=estimatedTime;
  }
  public void setResponsibleTeamMember(TeamMember teamMember) {
    this.responsibleTeamMember=teamMember;
  }
  public void setStatus(Status status) {
    this.status = status;
  }
  public void setTimeWorked(TeamMember teamMember, int time) {
    this.trackTimeList.setTimeWorked(teamMember, time);
  }

  public String toString() {
    return "";
  }
}
