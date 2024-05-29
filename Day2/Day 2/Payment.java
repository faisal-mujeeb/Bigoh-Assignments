public class Payment {
    private PaymentType type;
    private double amount;
    private Date paymentDate;

    public Payment(PaymentType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.paymentDate = new Date();
    }

    public PaymentType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

   
}

