package model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;
  private int tasksCreated = 0;

  public TaskList()
  {
    this.tasks = new ArrayList<Task>();
  }

  public void addTask(String name, int estimatedTime, String description, long deadlineTime)
  {
    if (name.trim().equals(""))
      throw new IllegalArgumentException("Invalid name");
    else
      {
      tasks.add(new Task(name, this.tasksCreated, 0, description, deadlineTime));
      this.tasksCreated++;
    }
  }
  public void addTask(String name, int estimatedTime, String description, long deadlineTime, TeamMember responsibleTeamMember)
  {
    if (name.trim().equals(""))
      throw new IllegalArgumentException("Invalid name");
    else
      {
      tasks.add(new Task(name, this.tasksCreated, 0, description, deadlineTime, responsibleTeamMember));
      this.tasksCreated++;
    }
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
  public Task[] getTasksByStatus(String status)
  {
    ArrayList<Task> foundTasks = new ArrayList<Task>();
    for (Task task : this.tasks)
    {
      if (task.getStatus().equals(status)) {
        foundTasks.add(task);
      }
    }
    return foundTasks.toArray(new Task[0]);
  }

  /*public Task[] getTasksBeforeDeadline(Status status)
  {
    ArrayList<Task> foundTasks = new ArrayList<Task>();

    for (Task task : this.tasks)
    {
      if (task.getStatus().equals(status))
        foundTasks.add(task);
    }
    return foundTasks.toArray(new Task[0]);
  }*/
  
  public Task[] getTasksDaysBeforeDeadline(int days)
  {
    // not finished
    ArrayList<Task> tasksBeforeDeadline = new ArrayList<>();

    long currentTime = new TimeClass().getTime();

    for (int i = 0; i < tasks.size(); i++)
    {
      long deadline = tasks.get(i).getDeadlineTime();

      if (new TimeClass(deadline).addDays(-days).getTime() <= currentTime)
        tasksBeforeDeadline.add(tasks.get(i));
    }

    return tasksBeforeDeadline.toArray(new Task[0]);
  }

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
