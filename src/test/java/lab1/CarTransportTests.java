package lab1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTransportTests {
    CarTransport cartransport;
    Volvo240 volvo;
    Saab95 saab;

    @BeforeEach
    void setUp() {
        cartransport = new CarTransport(2, 4206967, Color.green);
        volvo = new Volvo240(Color.cyan);
        saab = new Saab95(Color.orange);
    }

    @Test
    void addCarWhileRampIsUp() {
        cartransport.raiseRamp();
        assertThrows(IllegalStateException.class, () ->
                cartransport.addCar(volvo));
    }

    @Test
    void testCarPositionWhenOnTransport(){
        volvo.setPosition(0,0);
        cartransport.setPosition(5,2);
        cartransport.lowerRamp();
        cartransport.addCar(volvo);
        cartransport.incrementSpeed(1);
        assertEquals(5, volvo.getPosition()[0]);
        assertEquals(2, volvo.getPosition()[1]);
        cartransport.move();
        assertEquals(cartransport.getPosition()[0], volvo.getPosition()[0]);
        assertEquals(cartransport.getPosition()[1], volvo.getPosition()[1]);
        assertNotEquals(7,cartransport.getPosition()[0]+cartransport.getPosition()[1]);
    }

    @Test
    void testLoadCarTransport() {
        CarTransport cartransport2 = new CarTransport(2, 4206967, Color.green);
        assertThrows(IllegalArgumentException.class, () -> cartransport.addCar(cartransport2));
    }
}
