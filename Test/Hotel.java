import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static int idCounter = 0; // Counter for generating unique hotel IDs
    private int id;
    private String name;
    private String location;
    private int numberOfRooms;
    private List<Room> rooms; // List to store rooms in the hotel

    public Hotel(String name, String location, int numberOfRooms) {
        this.id = idCounter++;
        this.name = name;
        this.location = location;
        this.numberOfRooms = numberOfRooms;
        this.rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            rooms.add(new Room(i, false));
        }
    }

    // Getters and Setters

    public boolean isRoomAvailable(int roomId) {
        return rooms.stream().anyMatch(room -> room.getId() == roomId && room.isAvailable());
    }

    public void bookRoom(int roomId) {
        rooms.stream().filter(room -> room.getId() == roomId).findFirst().ifPresent(room -> room.setAvailable(false));
    }

    // Getters for id, name, location, and rooms
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

