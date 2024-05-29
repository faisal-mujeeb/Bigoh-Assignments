import java.util.*;

public class TicketManagement {
    private Map<String, ParkingTicket> activeTickets;

    public TicketManagement() {
        this.activeTickets = new HashMap<>();
    }

    public ParkingTicket issueTicket(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket(vehicle);
        activeTickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public ParkingTicket scanTicket(String ticketId) {
        return activeTickets.get(ticketId);
    }

    public void payTicket(String ticketId, Payment payment) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        ticket.setPaid(true);
        ticket.setPayment(payment);
        activeTickets.remove(ticketId);
    }

   
}

