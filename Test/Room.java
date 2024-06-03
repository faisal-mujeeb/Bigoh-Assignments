public class Room {
    private int id;
    private boolean isAvailable;
   // private String type; //Types of room -- King , Delux , Small size rooms
    private int quantity;

    public Room(int quantity){
        this.quantity = quantity;
    }

    public Room(int id , boolean isAvailable) {
        this.id = id;
        this.isAvailable = true;
    }

    // Getters and setters for id and availability status
    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;

    }
    public String getType(){
        return type;
    }
    public void setType(String type){
       this.type = type;
    }
}