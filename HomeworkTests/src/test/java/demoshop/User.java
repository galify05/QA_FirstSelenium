package demoshop;

public class User {
    String FirstName;

    public String getFirstName() {
        return FirstName;
    }

    public User setFirstName(String firstName) {
        FirstName = firstName;
    return this;
    }

    public String getLastName() {
        return LastName;
    }

    public User setLastName(String lastName) {
        LastName = lastName;
    return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
    return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
    return this;
    }

    String LastName;
    String email;
    String password;

}
