 public class Person{
    private String name;
    private double expenses;

    public Person(String name){
        this.name = name;
        this.expenses =0;
    }
    public String getName(){
        return name;
    }
    public double getExpenses(){
        return expenses;
    }
    public void addExpenses(double amount){
        this.expenses += amount;
    }
 }