
    public class MP extends Person{
        private String constituency;
        private String driver;
        private final double spendingLimit = 100000;

        public MP(String name , String constituency){
            super(name);
            this.constituency = constituency;
            this.driver = "Default Driver";
        }
        public String getConstituency(){
            return constituency;
        }
        public String getDriver(){
            return driver;
        }
        public boolean exceedsSpendingLimit(){
            return getExpenses() > spendingLimit;
        }
    }

