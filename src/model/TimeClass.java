package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeClass
{
  private Timestamp savedTimestamp;

  public TimeClass(int timeInMsec) {
    this.savedTimestamp = new Timestamp(timeInMsec);
  }
  public TimeClass() {
    this.savedTimestamp = new Timestamp(System.currentTimeMillis());
  }

  private Long dayToMiliseconds(int days){
    Long result = Long.valueOf(days * 24 * 60 * 60 * 1000);
    return result;
  }

  public String getFormatedTime() {
    return new SimpleDateFormat("HH:mm:ss MM.dd.yyyy").format(this.savedTimestamp);
  }
  public long getTime() {
    return savedTimestamp.getTime();
  }
  public boolean equals(Timestamp timestampToCompare) {
    return timestampToCompare.getTime()==this.savedTimestamp.getTime();
  }
  public boolean equals(long timestampToCompare) {
    return timestampToCompare==this.savedTimestamp.getTime();
  }
  public void addDays(int days) {
    this.savedTimestamp.setTime(this.savedTimestamp.getTime()+dayToMiliseconds(days));
  }
  public void minusDays(int days) {
    this.savedTimestamp.setTime(this.savedTimestamp.getTime()-dayToMiliseconds(days));
  }
}
