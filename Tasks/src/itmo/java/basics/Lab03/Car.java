package itmo.java.basics.Lab03;

public class Car {
    private String brand;
    private String colour;
    private double weight;

    public Car() {
    }

    public Car( String colour ) {
        this.colour = colour;
    }

    public Car( String colour, double weight ) {
        this.colour = colour;
        this.weight = weight;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public void setColour( String colour ) {
        this.colour = colour;
    }

    public void setWeight( double weight ) {
        this.weight = weight;
    }

    public String getAllInfo() {
        return "Модель: " + brand + ", Цвет: " + colour + ", Вес пустого автомобиля: " + weight;
    }

    @Override
    public String toString() {
        return "Модель: " + brand + ", Цвет: " + colour + ", Вес пустого автомобиля: " + weight;
   }
}
