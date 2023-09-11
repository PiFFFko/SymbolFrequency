package com.piven.symbolFrequency.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SymbolFrequencyService {

    public Map<Character, Integer> getFrequencySymbol(String string) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            frequencyMap.put(string.charAt(i), frequencyMap.getOrDefault(string.charAt(i), 0) + 1);
        }
        return frequencyMap.entrySet().
                stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (character, freq) -> character, LinkedHashMap::new));
    }


}
