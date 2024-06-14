package itmo.java.basics.Lab03;

public class House {
    private Integer yearOfConstraction;
    private Integer floors;
    private String nameOfHouse;

    public void setAllInfo( String name, Integer year, Integer floors ) {
        this.nameOfHouse = name;
        this.yearOfConstraction = year;
        this.floors = floors;
    }

    public String getAllInfo() {
        return  "Дом: " + nameOfHouse + ", построен: " + yearOfConstraction +
                ", количество этажей: " + floors;
    }

    public Integer howOld( Integer now ) {
        return now - yearOfConstraction;
    }

    @Override
    public String toString() {
        return  "Дом: " + nameOfHouse + ", построен: " + yearOfConstraction +
                ", количество этажей: " + floors;
    }
}
