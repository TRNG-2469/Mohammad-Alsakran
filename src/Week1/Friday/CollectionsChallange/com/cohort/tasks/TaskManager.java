package Week1.Friday.CollectionsChallange.com.cohort.tasks;

import java.util.*;

/**
 * TaskManager manages an ordered collection of Task objects while enforcing
 * uniqueness constraints on task titles and task IDs.
 *
 * Refactor notes:
 * - Collections are declared final to emphasize immutability of the references.
 * - Input validation is performed for null/empty task, id and title.
 * - Duplicate IDs are rejected to avoid accidental overwrite in the lookup map.
 */
public class TaskManager {
    private final List<Task> allTasks = new ArrayList<>();
    private final Set<String> uniqueTitles = new HashSet<>();
    private final Map<String, Task> taskLookup = new HashMap<>();

    /**
     * Adds a task to the manager.
     * Returns true when the task is accepted; false when rejected due to validation or duplication.
     */
    public boolean addTask(Task task) {
        if (task == null) {
            System.out.println("Cannot add null task.");
            return false;
        }

        String id = task.getTaskId();
        String title = task.getTitle();

        if (id == null || id.trim().isEmpty()) {
            System.out.println("Invalid task id.");
            return false;
        }
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid task title.");
            return false;
        }

        if (uniqueTitles.contains(title)) {
            System.out.println("Duplicate task title blocked!");
            return false;
        }

        if (taskLookup.containsKey(id)) {
            System.out.println("Duplicate task id blocked!");
            return false;
        }

        allTasks.add(task);
        uniqueTitles.add(title);
        taskLookup.put(id, task);

        return true;
    }

    /**
     * Lookup task by id.
     */
    public Task getTaskById(String id){
        if (id == null) { return null; }
        return taskLookup.get(id);
    }

    /**
     * Print all tasks in insertion order. Intended for demo/training purposes.
     */
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
