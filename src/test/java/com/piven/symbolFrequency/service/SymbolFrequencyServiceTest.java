package com.piven.symbolFrequency.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SymbolFrequencyServiceTest {
    SymbolFrequencyService service = new SymbolFrequencyService();;


    @Test
    void getFrequencySymbol() {
        String test = "aaaaabcccc";
        Map<Character, Integer> testMap = service.getFrequencySymbol(test);
        assertFalse(testMap.isEmpty());
        assertEquals(testMap.get('a'),5);
        assertEquals(testMap.get('b'),1);
        assertEquals(testMap.get('c'),4);
    }

    @Test
    void getFrequencySymbolWithBlankString() {
        String test = "";
        Map<Character, Integer> testMap = service.getFrequencySymbol(test);
        assertTrue(testMap.isEmpty());

    }
}