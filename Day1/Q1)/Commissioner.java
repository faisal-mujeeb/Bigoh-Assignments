public class Commissioner {
    public void canArrest(MP mp) {
        if (mp instanceof PM) {
            System.out.println("Cannot arrest the PM.");
        } else if (mp instanceof Minister) {
            PM pm = (PM) getPM();
            if (pm.givePermissionToArrest((Minister) mp)) {
                if (mp.exceedsSpendingLimit()) {
                    System.out.println("Arresting Minister: " + mp.getName());
                } else {
                    System.out.println("Minister " + mp.getName() + " has not exceeded the spending limit.");
                }
            } else {
                System.out.println("Permission to arrest Minister " + mp.getName() + " denied by PM.");
            }
        } else {
            if (mp.exceedsSpendingLimit()) {
                System.out.println("Arresting MP: " + mp.getName());
            } else {
                System.out.println("MP " + mp.getName() + " has not exceeded the spending limit.");
            }
        }
    }

    private PM getPM() {
     return new PM("Prime Minister", "National Constituency");
    }

    public static void main(String[] args) {
        MP mp = new MP("MP1", "Constituency1");
        Minister minister = new Minister("Minister1", "Constituency2");
        PM pm = new PM("Prime Minister", "National Constituency");

        mp.addExpenses(150000); 
        minister.addExpenses(500000); 
        pm.addExpenses(12000000); 

        Commissioner commissioner = new Commissioner();
        commissioner.canArrest(mp);
        commissioner.canArrest(minister);
        commissioner.canArrest(pm);
    }
}
