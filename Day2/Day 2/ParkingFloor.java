import java.util.*;

public class ParkingFloor {
    private String id;
    private List<ParkingSpot> parkingSpots;
    private DisplayBoard displayBoard;

    public ParkingFloor(String id) {
        this.id = id;
        this.parkingSpots = new ArrayList<>();
        this.displayBoard = new DisplayBoard();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        displayBoard.updateDisplayBoard(spot, true);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot);
        displayBoard.updateDisplayBoard(spot, false);
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public String getId() {
        return id;
    }
}
