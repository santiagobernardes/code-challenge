package com.taller.codechallenge;

import java.util.HashMap;

public class SmallestWindowChallenge {

    public static String NO_WINDOW_MESSAGE = "No window exists for this combination!";

    public static String findSmallestWindow(String inputString, String pattern) {
        if (pattern.length() > inputString.length()) {
            return NO_WINDOW_MESSAGE;
        }

        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (char character : pattern.toCharArray()) {
            patternMap.put(character, patternMap.getOrDefault(character, 0) + 1);
        }

        int count = 0;
        int minLength = inputString.length() + 1;
        int start = 0;
        int startIndex = -1;

        HashMap<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            stringMap.put(character, stringMap.getOrDefault(character, 0) + 1);

            if (patternMap.containsKey(character) && stringMap.get(character) <= patternMap.get(character)) {
                count++;
            }

            if (count == pattern.length()) {
                while (!patternMap.containsKey(inputString.charAt(start)) || stringMap.get(inputString.charAt(start)) > patternMap.get(inputString.charAt(start))) {
                    if (patternMap.containsKey(inputString.charAt(start)) && stringMap.get(inputString.charAt(start)) > patternMap.get(inputString.charAt(start))) {
                        stringMap.put(inputString.charAt(start), stringMap.get(inputString.charAt(start)) - 1);
                    }
                    start++;
                }

                int windowLength = i - start + 1;
                if (minLength > windowLength) {
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }

        return inputString.substring(startIndex, startIndex + minLength);
    }
}
