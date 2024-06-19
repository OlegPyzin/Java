package itmo.java.basics.Lab06;

public abstract class Human {
    private String firstName;
    private String lastName;
    private HumanName name;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human(String name, HumanName fio) {
        switch (fio) {
            case FIRST_NAME:
                this.firstName = name;
                break;
            case LAST_NAME:
                this.lastName = name;
                break;
            case MIDDLE_NAME:
                break;         // To do nothing
            default:           // To do nothing
        }
    }

    protected void setName(String name, HumanName fio) {
        switch (fio) {
            case FIRST_NAME:
                this.firstName = name;
                break;
            case LAST_NAME:
                this.lastName = name;
                break;
            case MIDDLE_NAME:
                break;         // To do nothing
            default:           // To do nothing
        }
    }

    protected String getFirstName() {
        return this.firstName;
    }

    protected String getLastName() {
        return this.lastName;
    }

    protected abstract void getAllInfoHuman();
}
