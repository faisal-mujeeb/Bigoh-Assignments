
class User {
    private int userId;
    private String name;
    private int age;

    public User() {}

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.userId = id;
    }

    public int getUserId() {
        return userId;
    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}