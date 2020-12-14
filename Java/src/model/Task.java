package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable
{
  // not finished

  private int id;
  private String name;
  private String description;
  private int estimatedTime;
  private long deadlineTime;
  private TeamMember responsibleTeamMember;
  private String status;
  private TrackTimeList trackTimeList;

  public Task(String name, int id, int estimatedTime, String description, int deadlineTime) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.deadlineTime=deadlineTime;
    this.estimatedTime=estimatedTime;
    this.status = Status.NOT_STARTED;
    this.trackTimeList = new TrackTimeList();
  }
  public Task(String name, int id, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.deadlineTime=deadlineTime;
    this.estimatedTime=estimatedTime;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status = Status.NOT_STARTED;
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

  public long getDeadlineTime() {
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
    ArrayList<TeamMember> teamMembers = new ArrayList<>();

    for (int i = 0; i < trackTimeList.getTrackTime().size(); i++)
      teamMembers.add(trackTimeList.getTrackTime().get(i).getTeamMember());

    return teamMembers.toArray(new TeamMember[0]);
  }

  public TeamMember getResponsibleTeamMember() {
    return this.responsibleTeamMember;
  }

  public String getStatus()
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

  public void setName(String name)
  {
    if (name.trim().equals(""))
      throw new IllegalArgumentException("Invalid name");
    else
      {
      this.name = name.trim();
    }
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

  public void setStatus(String status) {
    this.status = status;
  }

  public void setTimeWorked(TeamMember teamMember, int time) {
    this.trackTimeList.setTimeWorked(teamMember, time);
  }

  public String toString() {
    return "";
  }
}
