package lab1;

import java.awt.*;

public abstract class Vehicle implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color clr; // Color of the car
    private double x;
    private double y;
    private int direction; // north = 0, east = 1, south = 2, west = 3

    public Vehicle(int nrDoors, double enginePower, Color clr){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.clr = clr;
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        stopEngine();
    }

    public void move() {
        switch (direction) {
            case 0:
                y+=currentSpeed;
                break;
            case 1:
                x+=currentSpeed;
                break;
            case 2:
                y-=currentSpeed;
                break;
            case 3:
                x-=currentSpeed;
                break;
        }
    }

    public void turnLeft() {
        direction = (direction + 3) % 4;
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
        return clr;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected void setColor(Color clr) {
        this.clr = clr;
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

    public void incrementSpeedHelper(double amount) {
        setCurrentSpeed(Math.min((getCurrentSpeed() + speedFactor() * amount), getEnginePower()));
    }

    public void decrementSpeedHelper(double amount) {
        setCurrentSpeed(Math.max((getCurrentSpeed() - speedFactor() * amount),0));
    }


}