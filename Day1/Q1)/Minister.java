public class Minister extends MP {
    private final double spendingLimit = 1000000;

    public Minister(String name,String constituency){
        super(name,constituency);
    }
    @Override
    public boolean exceedsSpendingLimit(){
        return getExpenses()>spendingLimit;
    }
}
