package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
class DefangingAnIPAddress {
    @Test
    void defangIPaddrTest() {
        assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
        assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        int length = 0;
        char[] result = new char[24];

        int current = -1;
        while (++current < address.length()) {
            char c = address.charAt(current);
            if (c != '.') {
                result[length++] = address.charAt(current);
            } else {
                result[length++] = '[';
                result[length++] = '.';
                result[length++] = ']';
            }
        }

        return new String(result, 0, length);
    }
}
