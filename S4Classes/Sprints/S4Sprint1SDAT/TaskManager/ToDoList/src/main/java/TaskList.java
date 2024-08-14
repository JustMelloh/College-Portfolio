/* TaskList represents the to-do list for a user while also including methods to add a task,
* mark a task and print all tasks related to the user. We use Single Linked Lists for the arrays.*/

public class TaskList {

    private TaskClass[] tasks;
    private int taskCount;

    /* Constructor for TaskList */

    public TaskList() {
        /* Here we initialize the Array for the tasks and set the count number by default to 0.*/
        this.tasks = new TaskClass[10];
        this.taskCount = 0;
    }

    /* Method to add a task to the list */

    public void addTask(String description) {
        /* Here we create a new task and then add the Task to the array list. */
        TaskClass newTask = new TaskClass(description);
        this.tasks[this.taskCount] = newTask;
        this.taskCount++;
    }

    /* Method to mark a task as completed */
    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.length && tasks[index] != null) {
            tasks[index].markAsCompleted();
        } else {
            System.out.println("Invalid task index. Please enter a valid index.");
        }
    }

    /* Method to print all tasks */
    public void printAllTasks() {
        /* Here we print all the tasks in the array list. */
        for (int i = 0; i < this.taskCount; i++) {
            System.out.println(this.tasks[i].toString());
        }
    }

    /* Method to return the task count */
    public int getTaskCount() {
        return this.taskCount;
    }

    /* Method to return the task at a specific index */
    public TaskClass getTask(int index) {
        return this.tasks[index];
    }

    /* Method to return the tasks as a string */
    public String toString() {
        String taskList = "";
        for (int i = 0; i < this.taskCount; i++) {
            taskList += this.tasks[i].toString() + "\n";
        }
        return taskList;
    }

}
