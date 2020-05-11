package com.foxminded.andrei.collections;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UniqueCharCounter uniqueCharCounter = new UniqueCharCounter();
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        CachedCharCounter cachedCharCounter = new CachedCharCounter(uniqueCharCounter);
        while (loop) {
            System.out.println("Enter a string to format: ");
            String inputString = scanner.nextLine();
            Map<Character, Integer> value = cachedCharCounter.count(inputString);
            if (inputString.isEmpty()) {
                loop = false;
            }
            format(value, inputString);
        }
    }

    public static void format(Map<Character, Integer> value, String inputString) {
        System.out.println(inputString);
        for (Map.Entry<Character, Integer> entry : value.entrySet()) {
            System.out.println(String.format("\"%s\" - %d", entry.getKey(), entry.getValue()));
        }
    }
}
