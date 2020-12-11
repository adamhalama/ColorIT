package model;

import java.io.Serializable;

public class Status implements Serializable
{

  public static Status NOT_STARTED;
  public static Status STARTED;
  public static Status ENDED;
  public static Status APPROVED;
  public static Status REJECTED;


  public Status() {

  }
}
