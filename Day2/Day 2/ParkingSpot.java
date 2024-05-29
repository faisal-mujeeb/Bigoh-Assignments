public class ParkingSpot {
    private String id;
    private SpotType type;
    private boolean isFree;
    private Vehicle currentVehicle;

    public ParkingSpot(String id, SpotType type) {
        this.id = id;
        this.type = type;
        this.isFree = true;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree) {
            this.currentVehicle = vehicle;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public boolean removeVehicle() {
        if (!isFree) {
            this.currentVehicle = null;
            this.isFree = true;
            return true;
        }
        return false;
    }

    // Additional methods for parking spot management
}

