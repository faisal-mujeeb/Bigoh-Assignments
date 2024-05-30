import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        List<User> users = new ArrayList<>();
        WallService wallService = new WallService(cities, users);

        // Sample Users
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        users.add(new User("David"));
        users.add(new User("Eve"));
        users.add(new User("Frank"));
        users.add(new User("Grace"));
        users.add(new User("Heidi"));
        users.add(new User("Ivan"));
        users.add(new User("Judy"));

        // Sample City
        City sampleCity = new City("SampleCity");
        cities.add(sampleCity);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Brick");
            System.out.println("2. View Total Walls");
            System.out.println("3. View Total Bricks");
            System.out.println("4. Edit Brick");
            System.out.println("5. Flag Brick");
            System.out.println("6. Add Comment to Brick");
            System.out.println("7. Find Hottest User");
            System.out.println("8. Find Users with No Dedications");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter city name:");
                    String cityName = scanner.nextLine();
                    System.out.println("Enter message:");
                    String message = scanner.nextLine();
                    System.out.println("Enter your name:");
                    String ownerName = scanner.nextLine();
                    System.out.println("Enter dedication:");
                    String dedicateTo = scanner.nextLine();

                    User owner = users.stream().filter(u -> u.getName().equalsIgnoreCase(ownerName)).findFirst().orElse(null);
                    if (owner == null) {
                        System.out.println("User not found!");
                        break;
                    }

                    wallService.addBrick(cityName, message, owner, dedicateTo);
                    break;
                case 2:
                    System.out.println("Enter city name:");
                    cityName = scanner.nextLine();
                    int totalWalls = wallService.getTotalWalls(cityName);
                    System.out.println("Total walls in " + cityName + ": " + totalWalls);
                    break;
                case 3:
                    System.out.println("Enter city name:");
                    cityName = scanner.nextLine();
                    System.out.println("Enter wall index:");
                    int wallIndex = scanner.nextInt();
                    int totalBricks = wallService.getTotalBricks(cityName, wallIndex);
                    System.out.println("Total bricks in wall " + wallIndex + " of " + cityName + ": " + totalBricks);
                    break;
                case 4:
                    System.out.println("Enter city name:");
                    cityName = scanner.nextLine();
                    System.out.println("Enter wall index:");
                    wallIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.println("Enter brick index:");
                    int brickIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    City city = wallService.getCityByName(cityName);
                    if (city == null || wallIndex >= city.getWalls().size() || brickIndex >= city.getWalls().get(wallIndex).getBricks().size()) {
                        System.out.println("Invalid city, wall or brick index.");
                        break;
                    }

                    Brick brickToEdit = city.getWalls().get(wallIndex).getBricks().get(brickIndex);
                    System.out.println("Enter your name:");
                    String userName = scanner.nextLine();
                    User user = users.stream().filter(u -> u.getName().equalsIgnoreCase(userName)).findFirst().orElse(null);
                    if (user == null) {
                        System.out.println("User not found!");
                        break;
                    }

                    System.out.println("Enter new message:");
                    String newMessage = scanner.nextLine();
                    System.out.println("Enter new dedication:");
                    String newDedicateTo = scanner.nextLine();

                    wallService.editBrick(user, brickToEdit, newMessage, newDedicateTo);
                    break;
                case 5:
                    System.out.println("Enter city name:");
                    cityName = scanner.nextLine();
                    System.out.println("Enter wall index:");
                    wallIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.println("Enter brick index:");
                    brickIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    city = wallService.getCityByName(cityName);
                    if (city == null || wallIndex >= city.getWalls().size() || brickIndex >= city.getWalls().get(wallIndex).getBricks().size()) {
                        System.out.println("Invalid city, wall or brick index.");
                        break;
                    }

                    Brick brickToFlag = city.getWalls().get(wallIndex).getBricks().get(brickIndex);
                    wallService.flagBrick(brickToFlag);
                    break;
                case 6:
                    System.out.println("Enter city name:");
                    cityName = scanner.nextLine();
                    System.out.println("Enter wall index:");
                    wallIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.println("Enter brick index:");
                    brickIndex = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    city = wallService.getCityByName(cityName);
                    if (city == null || wallIndex >= city.getWalls().size() || brickIndex >= city.getWalls().get(wallIndex).getBricks().size()) {
                        System.out.println("Invalid city, wall or brick index.");
                        break;
                    }

                    Brick brickToComment = city.getWalls().get(wallIndex).getBricks().get(brickIndex);
                    System.out.println("Enter comment:");
                    String comment = scanner.nextLine();

                    wallService.addComment(brickToComment, comment);
                    break;
                case 7:
                    User hottestUser = wallService.getHottestUser();
                    if (hottestUser != null) {
                        System.out.println("Hottest user: " + hottestUser.getName() + " with " + hottestUser.getDedicatedBricks().size() + " bricks.");
                    } else {
                        System.out.println("No user found.");
                    }
                    break;
                case 8:
                    List<User> usersWithNoDedications = wallService.getUsersWithNoDedications();
                    if (!usersWithNoDedications.isEmpty()) {
                        System.out.println("Users with no dedications:");
                        for (User u : usersWithNoDedications) {
                            System.out.println(u.getName());
                        }
                    } else {
                        System.out.println("All users have dedications.");
                    }
                    break;
                case 9:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

