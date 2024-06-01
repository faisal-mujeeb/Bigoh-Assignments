public class Admin{
    private String name;
    private String id;

    public Admin(String name , String id){
        this.name = name;
        this.id = id;
    }

    //admin specific floor

    public void addParkingFloor(ParkingFloor floor){
        ParkingLot.getInstance().getFloorManagement().removeFloor(floor);
           
    public void removeParkingFloor(ParkingFloor floor){
        ParkingLot.getInstance().getFloorManagement().removeFloor(floor);
    }
    public void addParkingSpot(String floorId, ParkingSpot spot){
        ParkingLot.getInstance().getFloorManagement().addParkingSpot(floorId,spot);
    }
    public void removeParkingSpot(String floorId, ParkingSpot spot){
        ParkingLot.getInstance().getFloorManagement().removeParkingSpot(floorId,spot);
    }
    public void addParkingAttendant(ParkingAttendant attendant){
        ParkingLot.getInstance().getUserManagement().addParkingAttendant(attendant);
    }
    public void removeParkingAttendant(ParkingAttendant attendant){
        ParkingLot.getInstance().getUserManagement().removeParkingAttendant(attendant);
}
public void setParkingRate(double rate){
    ParkingLot.getinstance().setParkingRate(rate);
}
public String getName(){
    return name;
} 
public String getId(){
return id;
}

}