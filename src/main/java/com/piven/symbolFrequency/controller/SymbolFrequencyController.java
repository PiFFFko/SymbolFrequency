package com.piven.symbolFrequency.controller;

import com.piven.symbolFrequency.service.SymbolFrequencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/frequency")
public class SymbolFrequencyController {

    private final SymbolFrequencyService service;

    @GetMapping
    public Map<Character, Integer> getSymbolFrequency(@RequestParam String string) {
        return service.getFrequencySymbol(string);
    }

}
