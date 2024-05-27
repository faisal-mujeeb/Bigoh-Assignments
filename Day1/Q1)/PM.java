public class PM extends Minister {
    private final double spendingLimit = 10000000; 
    private String aircraftDriver;

    public PM(String name, String constituency) {
        super(name, constituency);
        this.aircraftDriver = "Designated Aircraft Driver";
    }

    @Override
    public String getDriver() {
        return super.getDriver() + ", " + aircraftDriver;
    }

    @Override
    public boolean exceedsSpendingLimit() {
        return getExpenses() > spendingLimit;
    }

    public boolean givePermissionToArrest(Minister minister) {
        return true;
    }
}
