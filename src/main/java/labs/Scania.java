package labs;

import java.awt.*;

public class Scania extends Vehicle {
    private final TruckBed truckbed;

    public Scania(Color clr){
        super(2,420,clr);
        truckbed = new TruckBed();
    }

    public void changeAngle(int degrees) {
        if (getCurrentSpeed() == 0) {
            truckbed.changeAngleHelper(degrees);
        }
    }

    public TruckBed getTruckBed() {
        return truckbed;
    }

    protected double speedFactor(){
        return getEnginePower() * 0.005;
    }

    protected void incrementSpeed(double amount){
        if (truckbed.getAngle() == 0) {
            incrementSpeedHelper(amount);
        } else {
            System.out.println("Cannot start: Truck bed is up");
        }
    }

    protected void decrementSpeed(double amount){
        decrementSpeedHelper(amount);
    }
}

