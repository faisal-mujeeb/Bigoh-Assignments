import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private Map<SpotType, Integer> freeSpots;

    public DisplayBoard() {
        this.freeSpots = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            freeSpots.put(type, 0);
        }
    }

    public void updateDisplayBoard(ParkingSpot spot, boolean isFree) {
        SpotType type = spot.getType();
        if (isFree) {
            freeSpots.put(type, freeSpots.get(type) + 1);
        } else {
            freeSpots.put(type, freeSpots.get(type) - 1);
        }
    }

    public Map<SpotType, Integer> getFreeSpots() {
        return freeSpots;
    }

    public int getFreeSpotCount(SpotType type) {
        return freeSpots.getOrDefault(type, 0);
    }
}

