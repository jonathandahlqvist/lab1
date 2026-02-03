package labs;

import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;

    public Volvo240(Color clr){
        super(4, 100, clr);
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}