package lab1;

public class TruckBed {
    private double angle;

    public double getAngle() {
        return angle;
    }

    public void changeAngleHelper(int degrees){
        if ((angle + degrees) < 0) {
            angle = 0;
        } else {
            angle = Math.min((angle + degrees), 70);
        }
    }
}
