package ogrTest.taxCalculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListSizeTest {

    @Test
    public void arraySizeWithMockito(){

        List<String> strings = mock(ArrayList.class);

        when(strings.size()).thenReturn(10);

        assertEquals(10,strings.size());

    }
}
