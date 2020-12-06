package model;

public abstract class Description
{

  private boolean isFunctional;

  public Description(boolean isFunctional) //nonFunctional
  {
      this.isFunctional = isFunctional;

  }

  public abstract String[] getDescription();

/*  public abstract void setDescription(String who, String what, String why);

  public abstract void setDescription(String description);*/

  public boolean isFunctional()
  {
    return isFunctional;
  }
}
