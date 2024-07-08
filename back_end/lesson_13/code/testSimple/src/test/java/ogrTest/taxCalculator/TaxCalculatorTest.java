package ogrTest.taxCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxCalculatorTest {

    @Test
    void taxCalculatorTest2024(){
        CurrentYearProvider currentYearProvider = new CurrentYearProviderImpl();
        TaxCalculator taxCalculator = new TaxCalculator(currentYearProvider);

        double income = 1000;
        double expectedTaxAmount = 220;

        assertEquals(expectedTaxAmount,taxCalculator.calculateTax(income));
    }

    @Test
    void taxCalculatorTest2022(){

        CurrentYearProvider currentYearProvider = mock(CurrentYearProvider.class);

        //CurrentYearProvider currentYearProvider = new CurrentYearProviderImpl();

        TaxCalculator taxCalculator = new TaxCalculator(currentYearProvider);

        when(currentYearProvider.getYear()).thenReturn(2022);


        double income = 1000;
        double expectedTaxAmount = 180;

        assertEquals(expectedTaxAmount,taxCalculator.calculateTax(income));
    }

}