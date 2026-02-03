package labs;

import java.awt.*;

public class Saab95 extends Vehicle {

    private boolean turboOn;

    public Saab95(Color clr){
        super(2, 125, clr);
        turboOn = false;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public boolean getTurbo() {
        return turboOn;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
