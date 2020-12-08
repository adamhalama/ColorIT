package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;


public class RequirementList {
  private ArrayList<Requirement> requirements;
  private int requirementsCreated = 0;

  public RequirementList()
  {
    this.requirements = new ArrayList<Requirement>();
  }

  public void addRequirement(String name, String nonFunctionalDescription, int deadline, TeamMember responsibleTeamMember)
  {
    requirements.add(new Requirement(this.requirementsCreated, name, nonFunctionalDescription, deadline, responsibleTeamMember));
    this.requirementsCreated++;
  }
  public void addRequirement(String name, String[] FunctionalDescription, int deadline, TeamMember responsibleTeamMember)
  {
    requirements.add(new Requirement(this.requirementsCreated, name, FunctionalDescription, deadline, responsibleTeamMember));
    this.requirementsCreated++;
  }

  public Requirement[] getAllRequirements() {
    return this.requirements.toArray(new Requirement[0]);
  }

  public Requirement[] getRequirementsByStatus(Status status) {
    ArrayList<Requirement> foundRequirements = new ArrayList<Requirement>();
    for (Requirement requirement : this.requirements)
    {
      if (requirement.getStatus().equals(status)) {
        foundRequirements.add(requirement);
      }
    }
    return foundRequirements.toArray(new Requirement[0]);
  }

  public Requirement[] getRequirementsBeforeDeadline(int days)
  {
    // not finished
    ArrayList<Requirement> requirementsBeforeDeadline = new ArrayList<>();

    int hoursInDay = 24;
    int minutesInHour = 60;
    int secondsInMinute = 60;

    long secondsBeforeDeadline = days * hoursInDay * minutesInHour * secondsInMinute;
    long currentTime = Instant.now().getEpochSecond();

    for (int i = 0; i < requirements.size(); i++)
    {
      long deadline = requirements.get(i).getDeadlineTime();

      if (deadline - secondsBeforeDeadline >= currentTime)
        requirementsBeforeDeadline.add(requirements.get(i));
    }

    return requirementsBeforeDeadline.toArray(new Requirement[0]);
  }

  public Requirement[] getRequirementByResponsibleTeamMember(TeamMember responsible) {
    ArrayList<Requirement> foundRequirements = new ArrayList<Requirement>();
    for (Requirement requirement : this.requirements)
    {
      if (requirement.getResponsibleTeamMember().equals(responsible)) {
        foundRequirements.add(requirement);
      }
    }
    return foundRequirements.toArray(new Requirement[0]);
  }

  public Requirement getRequirementByID(int requirementID) {
    for (Requirement requirement : this.requirements)
    {
      if (requirement.getRequirementId()==requirementID) {
        return requirement;
      }
    }
    return null;
  }

  public Requirement[] getRequirementByName(String name) {
    ArrayList<Requirement> foundRequirements = new ArrayList<Requirement>();
    for (Requirement requirement : this.requirements)
    {
      if (requirement.getName().equalsIgnoreCase(name))
        foundRequirements.add(requirement);
    }
    return foundRequirements.toArray(new Requirement[0]);
  }

  public void deleteRequirement(Requirement requirement) {
    this.requirements.remove(requirement);
  }

  public void reorderRequirements(int[] orderedRequirementsIDs)
  {

  }
}
