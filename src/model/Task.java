package model;

import java.util.ArrayList;

public class Task {
  // not finished

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
    this.trackTimeList = new TrackTimeList();
  }
  public Task(String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.deadlineTime=deadlineTime;
    this.estimatedTime=estimatedTime;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status=Status.NOTSTARTED;
    this.trackTimeList = new TrackTimeList();
  }

  public int getTaskID() {
    return this.id;
  }

  public int getRequirementID()
  {
    return 0;
  }

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
    return this.trackTimeList.getTotalTime();
  }

  public int getTimeSpentOfMember(TeamMember teamMember) {
    return this.trackTimeList.getTimeOfMember(teamMember);
  }

  public TeamMember[] getTeamMembers()
  {
    //not finished
    // return this.trackTimeList.getTeamMembers();


    return new TeamMember[0];
  }

  public TeamMember getResponsibleTeamMember() {
    return this.responsibleTeamMember;
  }

  public Status getStatus()
  {
    return this.status;
  }

  public TrackTime[] getTrackTime()
  {
    return this.trackTimeList.getTrackTime().toArray(new TrackTime[0]);
  }

  public void addTeamMember(TeamMember teamMember)
  {
    // not finished
    trackTimeList.setTimeWorked(teamMember, 0);
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
