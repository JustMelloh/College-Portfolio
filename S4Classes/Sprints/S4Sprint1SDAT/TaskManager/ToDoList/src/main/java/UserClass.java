/* User Class is used to manage users, create and store them within an array, each User has a unique username */


public class UserClass {
    /* Instantiate the Username and Password as a String*/
    private String username;
    private String password;
    private boolean loggedIn;

    /* Constructor for UserClass */

    public UserClass(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    /* Method to return the user as a string */

    public String toString() {
        return this.username + " - " + this.password;
    }

    /* Allows for correct Login*/
    public boolean login(String loginUsername, String loginPassword) {
        if (this.username.equals(loginUsername) && this.password.equals(loginPassword)) {
            this.loggedIn = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoggedIn(){
        return this.loggedIn;
    }
}
