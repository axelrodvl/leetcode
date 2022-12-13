package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
class FizzBuzz {
    @Test
    void fizzBuzz() {
        assertEquals(Arrays.asList("1", "2", "Fizz"), fizzBuzz(3));
        assertEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz"), fizzBuzz(5));
        assertEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        String DIV3 = "Fizz";
        String DIV5 = "Buzz";
        String DIV35 = "FizzBuzz";

        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add(DIV35);
                continue;
            }
            if(i % 3 == 0) {
                result.add(DIV3);
                continue;
            }
            if(i % 5 == 0) {
                result.add(DIV5);
                continue;
            }
            result.add(Integer.toString(i));
        }
        return result;
    }
}
