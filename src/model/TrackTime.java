package model;

public class TrackTime {
  private int timeSpend = 0;
  private TeamMember teamMember;

  public TrackTime(TeamMember teamMember, int timeSpend) {
    this.teamMember = teamMember;
    this.timeSpend = timeSpend;
  }

  public void setTimeWorked(int time) {
    this.timeSpend = time;
  }
  public TeamMember getTeamMember() {
    return  this.teamMember;
  }
  public int getTime() {
    return this.timeSpend;
  }
}
