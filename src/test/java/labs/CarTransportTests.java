package labs;
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
        cartransport.setX(5);
        cartransport.setY(2);
        cartransport.lowerRamp();
        cartransport.addCar(volvo);
        cartransport.gas(1);
        assertEquals(5, volvo.getX());
        assertEquals(2, volvo.getY());
        cartransport.move();
        assertEquals(cartransport.getX(), volvo.getX());
        assertEquals(cartransport.getY(), volvo.getY());
        assertNotEquals(7,cartransport.getX()+cartransport.getY());
    }

    @Test
    void testLoadCarTransport() {
        CarTransport cartransport2 = new CarTransport(2, 4206967, Color.green);
        assertThrows(IllegalArgumentException.class, () -> cartransport.addCar(cartransport2));
    }
}
