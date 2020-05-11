package com.foxminded.andrei.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharCounter implements CharCounter {

    @Override
    public Map<Character, Integer> count(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string can't be null");
        }
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Character c : input.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}

