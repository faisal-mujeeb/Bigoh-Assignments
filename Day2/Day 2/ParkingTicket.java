import java.util.Date;

public class ParkingTicket {
    private static int idCounter = 0;
    private String id;
    private Vehicle vehicle;
    private Date issueTime;
    private Date paymentTime;
    private boolean isPaid;
    private Payment payment;

    public ParkingTicket(Vehicle vehicle) {
        this.id = "TICKET" + (++idCounter);
        this.vehicle = vehicle;
        this.issueTime = new Date();
        this.isPaid = false;
    }

    public String getId() {
        return id;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        this.paymentTime = new Date();
    }

    // Additional methods for parking ticket management
}

