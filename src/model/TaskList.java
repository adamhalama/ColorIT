package model;

import java.util.ArrayList;

public class TaskList {
  private ArrayList<Task> tasks;
  private int tasksCreated = 0;

  public TaskList()
  {
    this.tasks = new ArrayList<Task>();
  }

  public void addTask(String name, int estimatedTime, String description, int deadlineTime)
  {
    tasks.add(new Task(name, this.tasksCreated, 0, description, deadlineTime));
    this.tasksCreated++;
  }
  public void addTask(String name, int estimatedTime, String description, int deadlineTime, TeamMember responsibleTeamMember)
  {
    tasks.add(new Task(name, this.tasksCreated, 0, description, deadlineTime, responsibleTeamMember));
    this.tasksCreated++;
  }

  public Task[] getAllTasks() {
    return this.tasks.toArray(new Task[0]);
  }
  public Task[] getTasksByName(String name)
  {
    ArrayList<Task> foundTasks = new ArrayList<Task>();
    for (Task task : this.tasks)
    {
      if (task.getName().equalsIgnoreCase(name)) {
        foundTasks.add(task);
      }
    }
    return foundTasks.toArray(new Task[0]);
  }
  public Task[] getRequirementsByStatus(Status status) {
    ArrayList<Task> foundTasks = new ArrayList<Task>();
    for (Task task : this.tasks)
    {
      if (task.getStatus().equals(status)) {
        foundTasks.add(task);
      }
    }
    return foundTasks.toArray(new Task[0]);
  }
  /*public Requirement[] getRequirementsBeforeDeadline(Status status) {
    ArrayList<Requirement> foundRequirements = new ArrayList<Requirement>();
    for (Requirement requirement : this.requirements)
    {
      if (requirement.getStatus().equals(status))
        foundRequirements.add(requirement);
    }
    return foundRequirements.toArray(new Requirement[0]);
  }*/
  public int getUsedTime() {
    int totalTime = 0;
    for (Task task : this.tasks)
    {
      totalTime+=task.getTimeSpent();
    }
    return  totalTime;
  }
  public void deleteTask(Task task) {
    this.tasks.remove(task);
  }
}
