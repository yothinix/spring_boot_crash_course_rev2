import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void fizzBuzzGetOneShouldReturnOneTest() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(1);
        Assertions.assertEquals("1", actual);
    }

    @Test
    void fizzBuzzGetTwoShouldReturnTwoTest() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(2);
        Assertions.assertEquals("2", actual);
    }

    @Test
    void fizzBuzzGetThreeShouldReturnFizzTest() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(3);
        Assertions.assertEquals("Fizz", actual);
    }

    @Test
    void fizzBuzzGetFiveShouldReturnBuzzTest() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(5);
        Assertions.assertEquals("Buzz", actual);
    }

    @Test
    void fizzBuzzGetFifteenShouldReturnFizzBuzzTest() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(15);
        Assertions.assertEquals("FizzBuzz", actual);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "3,Fizz", "5,Buzz"})
    void fizzBuzzTest(Integer input, String expected) {
        FizzBuzz fizzbuzz = new FizzBuzz();
        String actual = fizzbuzz.get(input);
        Assertions.assertEquals(expected, actual);
    }
}