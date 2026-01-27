import java.awt.*;

public class Volvo240 extends CarModel {

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, Color.black);
    }
    
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
