public abstract class User {
    private String name;
    private String email;
    private String password;

    

    public abstract void displayOptions(); // Abstract method to display options for each role

    // Getters and setters for name, email, and password
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

public class NormalUser extends User {
    @Override
    public void displayOptions() {
        System.out.println("1. Search Hotels\n2. Book Room\n3. Modify Details");
    }
}



