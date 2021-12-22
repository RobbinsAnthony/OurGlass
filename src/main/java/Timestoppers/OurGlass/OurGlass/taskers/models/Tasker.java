package Timestoppers.OurGlass.OurGlass.taskers.models;

import javax.persistence.*;

@Entity
public class Tasker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String taskName;
    private boolean onAndOffTask;
    private String deadline;
    private String projectName;
    private Long id;
    //@OneToMany(cascade = CascadeType.ALL)

    public Tasker() {

    }
    public Tasker(String taskName, boolean onAndOffTask,String deadline, String projectName){
      this.taskName = taskName;
      this.onAndOffTask = onAndOffTask;
      this.deadline = deadline;
      this.projectName = projectName;
}

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isOnAndOffTask() {
        return onAndOffTask;
    }

    public void setOnAndOffTask(boolean onAndOffTask) {
        this.onAndOffTask = onAndOffTask;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Tasker{" +
                "taskName='" + taskName + '\'' +
                ", onAndOffTask=" + onAndOffTask +
                ", deadline='" + deadline + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
