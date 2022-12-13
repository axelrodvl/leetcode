package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/design-parking-system/
 */
class DesignParkingSystem {
    @Test
    void parkingSystemTest() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        assertTrue(parkingSystem.addCar(1));
        assertTrue(parkingSystem.addCar(2));
        assertFalse(parkingSystem.addCar(3));
        assertFalse(parkingSystem.addCar(1));
    }

    class ParkingSystem {
        static class Storage {
            final int MAX;
            int current = 0;
            Storage(int max) {
                this.MAX = max;
            }

            boolean addCar() {
                if (current + 1 <= MAX) {
                    current++;
                    return true;
                }
                return false;
            }
        }

        Map<Integer, Storage> parking = new HashMap<>();

        public ParkingSystem(int big, int medium, int small) {
            parking.put(1, new Storage(big));
            parking.put(2, new Storage(medium));
            parking.put(3, new Storage(small));
        }

        public boolean addCar(int carType) {
            return parking.get(carType).addCar();
        }
    }
}
