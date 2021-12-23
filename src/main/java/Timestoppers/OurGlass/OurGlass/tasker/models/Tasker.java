package Timestoppers.OurGlass.OurGlass.tasker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tasker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String taskName;
    private boolean onAndOffTask;
    private String deadline;
    private Long id;


    public Tasker() {

    }
    public Tasker(String taskName, boolean onAndOffTask,String deadline){
        this.taskName = taskName;
        this.onAndOffTask = onAndOffTask;
        this.deadline = deadline;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasker tasker = (Tasker) o;
        return onAndOffTask == tasker.onAndOffTask && Objects.equals(taskName, tasker.taskName) && Objects.equals(deadline, tasker.deadline) && Objects.equals(id, tasker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, onAndOffTask, deadline, id);
    }

    @Override
    public String toString() {
        return "Tasker{" +
                "taskName='" + taskName + '\'' +
                ", onAndOffTask=" + onAndOffTask +
                ", deadline='" + deadline + '\'' +
                ", id=" + id +
                '}';
    }
}


