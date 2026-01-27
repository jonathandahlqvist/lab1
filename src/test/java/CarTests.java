import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTests {
    Volvo240 volvo;
    Saab95 saab;

    @BeforeEach
    void setUp() {
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    void testDirection() {
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnLeft();
        assertEquals(2, volvo.getDirection());
    }

    @Test
    void testStartSpeed() {
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void testGetSetColor() {
        volvo.setColor(Color.cyan);
        assertEquals(Color.cyan,volvo.getColor());
    }

    @Test
    void testGetNrDoors() {
        int doors = volvo.getNrDoors();
        assertEquals(4, doors);
    }

    @Test
    void testGetEnginePower() {
        double engine = volvo.getEnginePower();
        assertEquals(100, engine);
    }

    @Test
    void testGetCurrentSpeed() {
        volvo.setCurrentSpeed(10);
        double speed = volvo.getCurrentSpeed();
        assertEquals(10, speed);
    }


}