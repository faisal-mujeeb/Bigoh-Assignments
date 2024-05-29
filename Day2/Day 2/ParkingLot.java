import java.util.*;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> parkingFloors;
    private Map<String, EntrancePanel> entrancePanels;
    private Map<String, ExitPanel> exitPanels;
    private UserManagement userManagement;
    private FloorManagement floorManagement;
    private TicketManagement ticketManagement;

    public ParkingLot(String name) {
        this.name = name;
        this.parkingFloors = new ArrayList<>();
        this.entrancePanels = new HashMap<>();
        this.exitPanels = new HashMap<>();
        this.userManagement = new UserManagement();
        this.floorManagement = new FloorManagement(this);
        this.ticketManagement = new TicketManagement();
    }

    // Add entrance panel
    public void addEntrancePanel(String id, EntrancePanel panel) {
        entrancePanels.put(id, panel);
    }

    // Remove entrance panel
    public void removeEntrancePanel(String id) {
        entrancePanels.remove(id);
    }

    // Add exit panel
    public void addExitPanel(String id, ExitPanel panel) {
        exitPanels.put(id, panel);
    }

    // Remove exit panel
    public void removeExitPanel(String id) {
        exitPanels.remove(id);
    }

    // Get all parking floors
    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Main Parking Lot");
       
    }
}

