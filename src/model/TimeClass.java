package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeClass
{
  private Timestamp savedTimestamp;

  public TimeClass(long timeInMilSec)
  {
    this.savedTimestamp = new Timestamp(timeInMilSec);
  }

  public TimeClass() {
    this.savedTimestamp = new Timestamp(System.currentTimeMillis());
  }

  private Long dayToMilliseconds(int days) {
    return (long) (days * 24 * 60 * 60 * 1000);
  }

  public String getFormattedTime() {
    return new SimpleDateFormat("HH:mm:ss MM.dd.yyyy").format(this.savedTimestamp);
  }

  public long getTime() {
    return savedTimestamp.getTime();
  }

  public boolean equals(Timestamp timestampToCompare) {
    return timestampToCompare.getTime() == this.savedTimestamp.getTime();
  }

  public boolean equals(long timestampToCompare) {
    return timestampToCompare == this.savedTimestamp.getTime();
  }

  public TimeClass addDays(int days) {
    this.savedTimestamp.setTime(this.savedTimestamp.getTime() + dayToMilliseconds(days));
    return this;
  }
}
