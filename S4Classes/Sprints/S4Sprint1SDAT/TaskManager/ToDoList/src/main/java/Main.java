/* This is the Main Class for the ToDoList where the user is able to fulfill their tasks and add new ones to the SLL*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         /* Add a Scanner for inputs*/
        Scanner scanner = new Scanner(System.in);

        /* Create a new User */

        UserClass user = new UserClass("Austin", "password");
        TaskList taskList = new TaskList();

        /* Boolean that indicates whether or not the program is running. */
        boolean running = true;

        while (running) {
            System.out.println("1. Add Task.");
            System.out.println("2. Mark Task as Complete.");
            System.out.println("3. Print All Tasks.");
            System.out.println("4. Create User. ");
            System.out.println("5. Login. ");
            System.out.println("6. Exit.");
            System.out.println("Enter desired choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (user.isLoggedIn()) {
                        System.out.println("Enter the task description: ");
                        String description = scanner.nextLine();
                        taskList.addTask(description);
                    } else {
                        System.out.println("You must be logged in to add a task.");
                    }
                    break;
                case 2:
                    if (user.isLoggedIn()) {
                        System.out.println("Enter the index of the task you want to mark as complete: ");
                        int index = scanner.nextInt();
                        taskList.markTaskAsComplete(index);
                    } else {
                        System.out.println("You must be logged in to mark a task as complete.");
                    }
                    break;
                case 3:
                    taskList.printAllTasks();
                    break;
                case 4:
                    System.out.println("Enter the username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter the password: ");
                    String password = scanner.nextLine();
                    user = new UserClass(username, password);
                    break;
                case 5:
                    System.out.println("Enter the username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter the password: ");
                    String loginPassword = scanner.nextLine();
                    if (user.login(loginUsername, loginPassword)) {
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Login failed.");
                    }
                    break;
                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice, and try again.");
                    break;
            }
        }
    }



}
