package HrApp;

public class Task {
    String taskName;
    String date;

    public Task(String taskName, String date)
    {
        this.taskName = taskName;
        this.date = date;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public String getDate()
    {
        return date;
    }

    public void setTaskName(String task)
    {
        taskName = task;
    }

    public void setDate(String taskDate)
    {
        date = taskDate;
    }
}
