public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.topUp(2000, 20);
        atm.topUp(500, 2);

        System.out.println("Attempting to withdraw 2300:");
        atm.withdraw(2300);

        System.out.println("Invalidating 2000 denomination");
        atm.invalidateDenomination(2000);

        System.out.println("Attempting to withdraw 2300 again:");
        atm.withdraw(2300);

        System.out.println("Adding new 5000 denomination and topping up");
        atm.addNewDenomination(5000);
        atm.topUp(5000, 10);

        System.out.println("Attempting to withdraw 10000:");
        atm.withdraw(10000);
    }
}

