import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTests {
    CarModel volvo;
    CarModel saab;

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

/* Vad ska testas
SpeedFactor x2
IncrementSpeed x2
DecrementSpeed x2
Getters
    GetNrDoors
    GetEnginepower
    getCurrentSpeed
    getColor
Setters
    setColor
    setCurrentSpeed
Start + StopEngine
Move + TurnLeft /right


 */

/*
assertEquals(expected, actual);
assertNotEquals(unexpected, actual);

assertTrue(condition);
assertFalse(condition);

assertNull(object);
assertNotNull(object);

assertThrows(Exception.class, () -> {
    methodThatShouldFail();
});
 */