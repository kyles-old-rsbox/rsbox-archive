import java.util.ArrayList;

public class Car {

    public String getName() {
        return name;
    }

    private String name;

    private ArrayList<Wheel> wheels;

    public Car(String name) {
        this.name = name;
    }

    public void addWheel() {
        Wheel wheel = new Wheel(this);
        wheels.add(wheel);
    }

    public ArrayList<Wheel> getWheels() {
        return this.wheels;
    }
}
