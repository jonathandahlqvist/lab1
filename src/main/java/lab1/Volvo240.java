package lab1;

import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;

    public Volvo240(Color clr){
        super(4, 100, clr);
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount){
        incrementSpeedHelper(amount);
    }

    protected void decrementSpeed(double amount){
        decrementSpeedHelper(amount);
    }
}