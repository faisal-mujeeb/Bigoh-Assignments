public class Administrator extends NormalUser {
    @Override
    public void displayOptions() {
        System.out.println("1. Approve Hotels\n2. Delete User/Hotel");
    }
}
