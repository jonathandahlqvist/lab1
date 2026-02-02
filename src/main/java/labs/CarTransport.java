package labs;

import java.awt.*;
import java.util.Stack;

public class CarTransport extends Vehicle {
    private Ramp ramp;
    private final Stack<Vehicle> parkedCars;

    public CarTransport(int nrDoors, double enginePower, Color clr) {
        super(nrDoors, enginePower, clr);
        ramp = new Ramp();
        parkedCars = new Stack<>();
    }

    public void lowerRamp(){
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Current speed must be 0");
        }

        ramp.lower();
    }

    public void raiseRamp(){
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException("Current speed must be 0");
        }

        ramp.raise();
    }

    public void addCar(Vehicle car){
        if (car instanceof CarTransport) {
            throw new IllegalArgumentException("Cannot load another CarTransport");
        }

        if (Math.abs(car.getPosition()[0] - this.getPosition()[0]) >= 10
                || Math.abs(car.getPosition()[1] - this.getPosition()[1]) >= 10) {
            throw new IllegalArgumentException("Car too far away");
        }

        if (!ramp.isLowered()) {
            throw new IllegalStateException("Ramp is not lowered");
        }

        parkedCars.push(car);
        car.setPosition(this.getPosition()[0], this.getPosition()[1]);
    }

    public Stack<Vehicle> getParkedCars() {
        return parkedCars;
    }
    public void removeCar(){
        if (!ramp.isLowered()) {
            throw new IllegalStateException("Ramp is not lowered");
        }

        Vehicle P = parkedCars.pop();
        P.setPosition(this.getPosition()[0]+1, this.getPosition()[1]);
    }

    @Override
    public void move() {
        super.move();
        double[] pos = this.getPosition();
        for (Vehicle p: parkedCars) {
            p.setPosition(pos[0], pos[1]);
        }
    }

    protected void incrementSpeed(double amount) {
        incrementSpeedHelper(amount);
    }

    protected void decrementSpeed(double amount) {
        decrementSpeedHelper(amount);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.005;
    }
}