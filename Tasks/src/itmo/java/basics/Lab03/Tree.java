package itmo.java.basics.Lab03;

public class Tree {
    private String treeName;
    private Integer years;
    private Boolean isLife;

    public Tree() {
        System.out.println( "Пустой конструктор без параметров сработал." );
    }

    public Tree( Integer years, String name ) {
        this.years = years;
        this.treeName = name;
    }

    public Tree( Integer years, String name, Boolean isLife ) {
        this.years = years;
        this.treeName = name;
        this.isLife = isLife;
    }

    @Override
    public String toString() {
        if( isLife == null ) {
            return "Дерево: " + treeName + ", возраст: " + years + ", состояние: неизвестно";
        }
        if( isLife ) {
            return "Дерево: " + treeName + ", возраст: " + years + ", состояние: живое";
        } else {
            return "Дерево: " + treeName + ", возраст: " + years + ", состояние: засохло";
        }
    }
}