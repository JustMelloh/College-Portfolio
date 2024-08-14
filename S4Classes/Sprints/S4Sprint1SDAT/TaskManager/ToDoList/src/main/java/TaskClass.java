/* ToDoList Created by Austin Reid, June 2024 for Semester 4 Sprint 1
* TaskClass is able to Store description and completion status of said task
* Also includes a method to mark a task as completed. */



/* Class to allow management of Tasks to add description, tasks and completion status.*/
public class TaskClass {

    private String description;
    private boolean isCompleted;

    /* Constructor for TaskClass */

    public TaskClass(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    /* Method to mark a task as completed */

    public void markAsCompleted() {
            this.isCompleted = true;
    }

    /* Method to return the description of the task */

    public String getDescription() {
        return this.description;
    }

    /* Method to return the completion status of the task */

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* Method to return the task as a string */

    public String toString() {
        return this.description + " - Completed: " + this.isCompleted;
    }


}
