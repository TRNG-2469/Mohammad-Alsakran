package Week1.Friday.CollectionsChallange.com.cohort.tasks;

import java.util.*;

public class TaskManager {
    private List<Task> allTasks = new ArrayList<>();
    private Set<String> uniqueTitles = new HashSet<>();
    private Map<String, Task> taskLookup = new HashMap<>();


    public boolean addTask(Task task) {
        if (uniqueTitles.contains(task.getTitle())) {
            System.out.println("Duplicate task blocked!");
            return false;
        }

        allTasks.add(task);
        uniqueTitles.add(task.getTitle());
        taskLookup.put(task.getTaskid(), task);

        return true;

    }


    public Task getTaskById(String id){
        return taskLookup.get(id);
    }

    public void printRoster(){
        for(Task task : allTasks){
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("T1", "Write Primitives Lab");
        Task task2 = new Task("T2", "Configure GitIgnore");
        Task task3 = new Task("T3", "Write Primitives Lab"); // Duplicate title

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.printRoster();

        System.out.println(taskManager.addTask(task1));
        System.out.println(taskManager.addTask(task2));
        System.out.println(taskManager.addTask(task3));


        Task task = taskManager.getTaskById("T2");
        System.out.println(task);
    }

}
