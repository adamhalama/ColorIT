package model;

public abstract class Description
{

  private boolean isFunctional;

  public Description(String description) //nonFunctional
  {
      this.isFunctional = false;

  }
  public Description(String[] description) //Functional
  {
      this.isFunctional = true;
  }
  /* TODO - my suggestion to make it
  public Description(boolean functional){
    this.isFunctional = functional;
  } TODO - than just make nonFunctional and Functional description call super(true) or super(false) as first thing in constructor

   */

  public abstract String[] getDescription();

/*  public abstract void setDescription(String who, String what, String why);

  public abstract void setDescription(String description);*/

  public boolean isFunctional()
  {
    return isFunctional;
  }
}
