package itmo.java.basics.Lab06;

public class BankEmployee extends Human implements Banking {
    private String nameBank;

    public BankEmployee( String firstName, String lastName, String bankName ) {
        super(firstName, lastName);
        this.nameBank = bankName;
    }

    @Override
    protected void getAllInfoHuman() {
        System.out.println( this.getFirstName() + " " + this.getLastName() + " " + this.nameBank );
    }

    @Override
    public String isOutSide() {
        return "Employee of Bank.";
    }
}
