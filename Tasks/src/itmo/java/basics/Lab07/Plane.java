package itmo.java.basics.Lab07;

public class Plane {
    protected Wing wings = new Wing();

    public void setWingsWeight(double weightWings) {
        this.wings.setWeight(weightWings);
    }

    public double getWingsWeight() {
        return wings.getWeight();
    }

    protected class Wing {
        private double weight;

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return this.weight;
        }
    }
}
