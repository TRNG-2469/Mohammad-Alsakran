package Week1.Friday.CollectionsChallange.com.cohort.tasks;

public class Task {
    private String taskid;
    private String title;
    private boolean isCompelted;

    public Task(String taskid, String title) {
        this.taskid = taskid;
        this.title = title;
        this.isCompelted = false;
    }

    public String getTaskId() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompelted() {
        return isCompelted;
    }

    public void setCompelted(boolean compelted) {
        isCompelted = compelted;
    }



    @Override
    public String toString() {
        return "Task{" +
                "taskid='" + taskid + '\'' +
                ", title='" + title + '\'' +
                ", isCompelted=" + isCompelted +
                '}';
    }


}
