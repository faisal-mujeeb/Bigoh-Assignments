import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels = new ArrayList<>(); // List to store hotels

    // Add or update hotel details
    public void addOrUpdateHotel(Hotel hotel) {
        hotels.add(hotel); 
    }

    // Search for hotels based on criteria
    public List<Hotel> searchHotels(String criteria) {
        
        return hotels;
    }

    // Book a room in a hotel
    public boolean bookRoom(int hotelId, int roomId) {
        Hotel hotel = hotels.stream().filter(h -> h.getId() == hotelId).findFirst().orElse(null);
        if (hotel != null && hotel.isRoomAvailable(roomId)) {
            hotel.bookRoom(roomId);
            return true;
        }
        return false;
    }

    // Delete a hotel by ID
    public void deleteHotel(int hotelId) {
        hotels.removeIf(h -> h.getId() == hotelId);

    }
}



