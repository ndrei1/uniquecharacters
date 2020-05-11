package com.foxminded.andrei.collections;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

    @Mock
    CharCounter counter;

    @InjectMocks
    CachedCharCounter cachedCharCounter;

    @Test
    public void shouldCalculateValueIfNotInCache() {
        String text = "123";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1',1);
        expected.put('2',1);
        expected.put('3',1);
        when(counter.count(text)).thenReturn(expected);

        Map<Character, Integer> actual = cachedCharCounter.count(text);

        assertEquals(expected, actual);
        verify(counter, times(1)).count(text);
    }

    @Test
    public void shouldReturnValueFromCache() {
        String text = "123";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1',1);
        expected.put('2',1);
        expected.put('3',1);
        when(counter.count(text)).thenReturn(expected);

        Map<Character, Integer> actual = cachedCharCounter.count(text);
        cachedCharCounter.count(text);

        assertEquals(expected, actual);
        verify(counter, times(1)).count(text);
    }
}
