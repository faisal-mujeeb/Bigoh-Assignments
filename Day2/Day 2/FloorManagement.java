import java.util.*;


public class FloorManagement {
    private ParkingLot parkingLot;

    public FloorManagement(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean addFloor(ParkingFloor floor, User user,Admin admin) {
         if(user == admin){
            return true;
            else{
                return false;
            }
         }
        parkingLot.getParkingFloors().add(floor);
    }

    public void removeFloor(ParkingFloor floor) {
        parkingLot.getParkingFloors().remove(floor);
    }

    public void addParkingSpot(String floorId, ParkingSpot spot) {
        for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            if (floor.getId().equals(floorId)) {
                floor.addParkingSpot(spot);
            }
        }
    }

    public void removeParkingSpot(String floorId, ParkingSpot spot) {
        for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            if (floor.getId().equals(floorId)) {
                floor.removeParkingSpot(spot);
            }
        }
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingLot.getParkingFloors();
    }
}
