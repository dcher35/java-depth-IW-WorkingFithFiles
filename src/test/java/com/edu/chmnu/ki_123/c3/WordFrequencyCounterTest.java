package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordFrequencyCounterTest {
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("testFile", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testCountWordFrequency_SimpleFile() throws IOException {
        String content = "hello world\nhello again";
        Files.writeString(tempFile, content);

        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency(tempFile.toString());

        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(1, result.get("again"));
        assertEquals(3, result.size());
    }

    @Test
    void testCountWordFrequency_EmptyFile() throws IOException {
        Files.writeString(tempFile, "");

        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency(tempFile.toString());

        assertTrue(result.isEmpty());
    }
}