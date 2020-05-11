package com.foxminded.andrei.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

    private CharCounter counter = new UniqueCharCounter();

    @Test
    void whenNullPassedShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> counter.count(null));
    }


    @Test
    void whenBasicStringShouldBuildMap() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put('1', 1);
        expected.put('2', 2);
        expected.put('3', 3);

        Map<Character, Integer> actual = counter.count("123233");

        assertEquals(expected, actual);
    }

    @Test
    void countDifferentCaseCharactersSeparately() {
        Map<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
        expected.put('q', 3);
        expected.put('Q', 3);

        Map<Character, Integer> actual = counter.count("qqqQQQ");

        assertEquals(expected, actual);
    }
}