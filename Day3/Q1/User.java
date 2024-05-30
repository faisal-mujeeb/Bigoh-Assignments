import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Brick> dedicatedBricks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Brick> getDedicatedBricks() {
        return dedicatedBricks;
    }

    public void addBrick(Brick brick) {
        dedicatedBricks.add(brick);
    }
}
