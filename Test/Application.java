import java.util.Scanner;

public class Application {
    private User currentUser; // Current logged-in user
    private HotelService hotelService = new HotelService(); // Service for hotel operations
    private UserService userService = new UserService(); // Service for user operations

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentUser == null) {
                showMainMenu(scanner); // Show main menu if no user is logged in
            } else {
                currentUser.displayOptions(); // Display options based on user role
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                executeUserOption(choice, scanner); // Execute the selected option
            }
        }
    }

    // Display the main menu
    private void showMainMenu(Scanner scanner) {
        System.out.println("1. Register\n2. Login\n3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                registerUser(scanner);
                break;
            case 2:
                loginUser(scanner);
                break;
            case 3:
                System.exit(0);
        }
    }

    // Register a new user
    private void registerUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (normal, agent, admin): ");
        String role = scanner.nextLine();
        currentUser = userService.registerUser(name, email, password, role);
    }

    // Login an existing user
    private void loginUser(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        currentUser = userService.loginUser(email, password);
    }

    // Execute user option based on role
    private void executeUserOption(int choice, Scanner scanner) {
        if (currentUser instanceof NormalUser) {
            handleNormalUserOptions(choice, scanner);
        } else if (currentUser instanceof HotelAgent) {
            handleAgentOptions(choice, scanner);
        } else if (currentUser instanceof Administrator) {
            handleAdminOptions(choice, scanner);
        }
    }

    // Handle options for NormalUser
    private void handleNormalUserOptions(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                searchHotels(scanner);
                break;
            case 2:
                bookRoom(scanner);
                break;
            case 3:
                updateUserDetails(scanner);
                break;
        }
    }

    // Handle options for HotelAgent
    private void handleAgentOptions(int choice, Scanner scanner) {
        if (choice == 1) {
            addOrUpdateHotel(scanner);
        }
    }

    // Handle options for Administrator
    private void handleAdminOptions(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                approveHotels(scanner);
                break;
            case 2:
                deleteUserOrHotel(scanner);
                break;
        }
    }

    // Search for hotels based on criteria
    private void searchHotels(Scanner scanner) {
        System.out.print("Enter search criteria: ");
        String criteria = scanner.nextLine();
        hotelService.searchHotels(criteria).forEach(System.out::println);
    }

    // Book a room in a hotel
    private void bookRoom(Scanner scanner) {
        System.out.print("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        boolean success = hotelService.bookRoom(hotelId, roomId);
        System.out.println(success ? "Booking successful!" : "Booking failed!");
    }
    //Type of room in a hotel
    private void roomType(Scanner scanner){
        System.out.print("Enter room type");
        int getType = scanner.nextLine();

    }

    // Update user details
    private void updateUserDetails(Scanner scanner) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        currentUser.setName(newName);
        currentUser.setEmail(newEmail);
        userService.updateUser(currentUser);
    }

    // Add or update hotel details
    private void addOrUpdateHotel(Scanner scanner) {
        System.out.print("Enter hotel name: ");
        String name = scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        System.out.print("Enter number of rooms: ");
        int numRooms = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Hotel hotel = new Hotel(name, location, numRooms);
        hotelService.addOrUpdateHotel(hotel);
    }

    // Approve hotels (placeholder method)
    private void approveHotels(Scanner scanner) {
        System.out.println("Approving hotels...");
        // Implementation for approving hotels
    }

    // Delete a user or hotel
    private void deleteUserOrHotel(Scanner scanner) {
        System.out.print("Enter 'user' to delete a user or 'hotel' to delete a hotel: ");
        String type = scanner.nextLine();
        if (type.equals("user")) {
            System.out.print("Enter user ID: ");
            int userId = scanner.nextInt();
            userService.deleteUser(userId);
        } else if (type.equals("hotel")) {
            System.out.print("Enter hotel ID: ");
            int hotelId = scanner.nextInt();
            hotelService.deleteHotel(hotelId);
        }
    }
}

