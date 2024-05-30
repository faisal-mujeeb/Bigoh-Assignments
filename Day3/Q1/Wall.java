import java.util.ArrayList;
import java.util.List;

public class Wall {
    private static final int MAX_BRICKS = 90;
    private List<Brick> bricks = new ArrayList<>();

    public List<Brick> getBricks() {
        return bricks;
    }

    public boolean addBrick(Brick brick) {
        if (bricks.size() < MAX_BRICKS) {
            bricks.add(brick);
            return true;
        }
        return false;
    }
}

