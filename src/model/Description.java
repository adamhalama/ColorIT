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

  public abstract String[] getDescription();

  public abstract void setDescription(String who, String what, String why);

  public abstract void setDescription(String description);

  public boolean isFunctional()
  {
    return isFunctional;
  }
}
