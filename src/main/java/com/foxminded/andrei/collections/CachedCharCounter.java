package com.foxminded.andrei.collections;

import java.util.*;

public class CachedCharCounter implements CharCounter {

    private Map<String, Map<Character, Integer>> cache = new HashMap<>();
    private final CharCounter counter;

    public CachedCharCounter(CharCounter counter) {
        this.counter = counter;
    }

    @Override
    public Map<Character, Integer> count(String input) {
        return cache.computeIfAbsent(input, k -> counter.count(input));
    }
}