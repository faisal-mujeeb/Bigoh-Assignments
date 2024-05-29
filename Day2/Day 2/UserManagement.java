import java.util.*;

public class UserManagement {
    private List<ParkingAttendant> parkingAttendants;
    private List<Customer> customers;

    public UserManagement() {
        this.parkingAttendants = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addParkingAttendant(ParkingAttendant attendant) {
        parkingAttendants.add(attendant);
    }

    public void removeParkingAttendant(ParkingAttendant attendant) {
        parkingAttendants.remove(attendant);
    }

    public List<ParkingAttendant> getParkingAttendants() {
        return parkingAttendants;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
