import java.awt.*;

public abstract class CarModel implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private double x;
    private double y;
    private int direction; // north = 0, east = 1, south = 2, west = 3

    public CarModel(int nrDoors, double enginePower, Color color){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        stopEngine();
    }

    public void move() {
        switch (direction) {
            case 0: {y+=currentSpeed;}
            case 1: {x+=currentSpeed;}
            case 2: {y-=currentSpeed;}
            case 3: {x-=currentSpeed;}
        }
    }

    public void turnLeft() {
        direction = (direction - 1) % 4;
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
    }


    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    protected abstract double speedFactor();

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public double[] getPosition() {
        return new double[] {x,y};
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    protected void setCurrentSpeed(double speed) {
        currentSpeed = speed; }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0; }

    public int getDirection() {
        return direction;
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else if (amount > 1) {
            incrementSpeed(1);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else if (amount > 1) {
            decrementSpeed(1);
        }
    }
}
