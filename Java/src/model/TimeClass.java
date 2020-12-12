package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

class TimeClass implements Serializable
{
  private Timestamp savedTimestamp;

  public TimeClass(long timeInMilSec)
  {
    this.savedTimestamp = new Timestamp(timeInMilSec);
  }

  public TimeClass(String datestring) {
    this.savedTimestamp = new Timestamp(this.parseString(datestring));
  }

  public TimeClass() {
    this.savedTimestamp = new Timestamp(System.currentTimeMillis());
  }

  private Long dayToMilliseconds(int days) {
    return (long) (days * 24 * 60 * 60 * 1000);
  }

  public String getFormattedDateTime() {
    return new SimpleDateFormat("HH:mm:ss MM.dd.yyyy").format(this.savedTimestamp);
  }
  public String getFormattedTime() {
    return new SimpleDateFormat("HH:mm:ss").format(this.savedTimestamp);
  }
  public String getFormattedDate() {
    return new SimpleDateFormat("MM.dd.yyyy").format(this.savedTimestamp);
  }

  public long parseString(String datestring) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
      Date parsedDate = dateFormat.parse(datestring);
      return parsedDate.getTime();
    } catch(Exception e) {
      e.printStackTrace();
    }
    return 0;
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
