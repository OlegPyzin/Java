package itmo.java.basics.Lab09;

public class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}