import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>(); // Map to store users with email as key

    // Register a new user
    public User registerUser(String name, String email, String password, String role) {
        User user = null;
        switch (role.toLowerCase()) {
            case "normal":
                user = new NormalUser();
                break;
            case "agent":
                user = new HotelAgent();
                break;
            case "admin":
                user = new Administrator();
                break;
            default:
                throw new IllegalArgumentException("Invalid role");
        }
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        users.put(email, user);
        return user;
    }

     // Login existing User
    public User loginUser(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        System.out.println("Invalid email or password");
        return null;
    }

    // Update user details
    public void updateUser(User user) {
        users.put(user.getEmail(), user);
    }

    // Delete a user by ID (placeholder method)
    public void deleteUser(int userId) {
        // Implementation for deleting a user
        user.delete(user.getId() , user);
    }
}

