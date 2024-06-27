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

    @Override
    public int hashCode() {
        return this.name.toUpperCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.hashCode() == this.hashCode()) {
            return true;
        }
        return false;
    }
}