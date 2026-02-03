package labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class RepairShopTest {
    RepairShop<Vehicle> vehicleshop;
    Volvo240 volvo;
    Saab95 saab;

    @BeforeEach
    void setUp() {
        vehicleshop = new RepairShop<>(1);
        volvo = new Volvo240(Color.cyan);
        saab = new Saab95(Color.orange);
    }

    @Test
    void testOvercapacityException() {
        vehicleshop.addVehicle(volvo);
        assertThrows(IllegalStateException.class, () -> vehicleshop.addVehicle(saab));
    }

    @Test
    void testRemoveEmptyShop() {
        assertThrows(IllegalStateException.class, () -> vehicleshop.removeVehicle(saab));
    }

    @Test
    void removeCarNotInShop() {
        vehicleshop.addVehicle(volvo);
        assertThrows(IllegalArgumentException.class, () -> vehicleshop.removeVehicle(saab));
    }
}
