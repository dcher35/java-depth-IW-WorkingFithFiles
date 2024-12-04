package com.edu.chmnu.ki_123.c3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "src/input_test.txt";

        try {
            Map<String, Integer> wordFrequencyMap = countWordFrequency(filePath);

            System.out.println("Word frequencies in the file:");
            wordFrequencyMap.forEach((word, count) ->
                    System.out.println(word + ": " + count));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (var lines = Files.lines(Path.of(filePath))) {
            lines.forEach(line -> {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            });
        }
        return wordFrequencyMap;
    }
}