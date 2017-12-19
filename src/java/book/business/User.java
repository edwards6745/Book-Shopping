//Austin Edwards cs4010 hw4 11/29/2016

package book.business;
import java.io.Serializable;
//User class
public class User implements Serializable {
    //private variables for each text box
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    //initialize variables
    public User() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
    }
    //function to set the private members to those that the user entered
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    //Getters and Setters
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
