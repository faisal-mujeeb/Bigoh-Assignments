import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class WallService {
    private List<City> cities;
    private List<User> users;

    public WallService(List<City> cities, List<User> users) {
        this.cities = cities;
        this.users = users;
    }

    public void addBrick(String cityName, String message, User owner, String dedicateTo) {
        City city = getCityByName(cityName);
        if (city == null) {
            System.out.println("City not found!");
            return;
        }

        Wall lastWall = city.getWalls().get(city.getWalls().size() - 1);
        Brick brick = new Brick(message, owner, dedicateTo);

        if (!lastWall.addBrick(brick)) {
            Wall newWall = new Wall();
            newWall.addBrick(brick);
            city.getWalls().add(newWall);
        }

        owner.addBrick(brick);
    }

    City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    public int getTotalWalls(String cityName) {
        City city = getCityByName(cityName);
        if (city != null) {
            return city.getWalls().size();
        }
        return 0;
    }

    public int getTotalBricks(String cityName, int wallIndex) {
        City city = getCityByName(cityName);
        if (city != null && wallIndex < city.getWalls().size()) {
            return city.getWalls().get(wallIndex).getBricks().size();
        }
        return 0;
    }

    public void editBrick(User user, Brick brick, String newMessage, String newDedicateTo) {
        if (user.equals(brick.getOwner())) {
            brick.setMessage(newMessage);
            brick.setDedicateTo(newDedicateTo);
        } else {
            System.out.println("You can only edit your own bricks.");
        }
    }

    public void flagBrick(Brick brick) {
        brick.flag();
        if (!brick.isVisible()) {
            System.out.println("This brick has been flagged more than 10 times and is now invisible.");
        }
    }

    public void addComment(Brick brick, String comment) {
        brick.addComment(comment);
    }

    public User getHottestUser() {
        return users.stream()
                .max(Comparator.comparingInt(u -> u.getDedicatedBricks().size()))
                .orElse(null);
    }

    public List<User> getUsersWithNoDedications() {
        List<User> usersWithNoDedications = new ArrayList<>();
        for (User user : users) {
            if (user.getDedicatedBricks().isEmpty()) {
                usersWithNoDedications.add(user);
            }
        }
        return usersWithNoDedications;
    }
}

