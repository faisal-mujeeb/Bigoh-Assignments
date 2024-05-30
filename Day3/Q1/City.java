import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Wall> walls = new ArrayList<>();

    public City(String name) {
        this.name = name;
        this.walls.add(new Wall());
    }

    public String getName() {
        return name;
    }

    public List<Wall> getWalls() {
        return walls;
    }
}

