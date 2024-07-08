package ogrTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempConverterTest {

    @Test
    void testCelsiusToFahrenheitEqualZero(){
        double tempCelsius = 0;
        double expectedResult = 32;
        assertEquals(expectedResult, TempConverter.celsiusToFahrenheit(tempCelsius));
    }

    @Test
    void testCelsiusToFahrenheit100(){
        double tempCelsius = 100;
        double expectedResult = 212;
        assertEquals(expectedResult, TempConverter.celsiusToFahrenheit(tempCelsius));

    }

}