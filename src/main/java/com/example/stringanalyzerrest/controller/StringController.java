package com.example.stringanalyzerrest.controller;

import com.example.stringanalyzerrest.model.RequestStringParsedStore;
import com.example.stringanalyzerrest.model.StatisticDto;
import com.example.stringanalyzerrest.service.StringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StringController {

    final StringService service;

    public StringController(StringService service) {
        this.service = service;
    }

    @GetMapping("/statistics")
    @ResponseBody
    public List<RequestStringParsedStore> getAllStatistic() {
        return service.getAll();
    }

    @GetMapping("/analyze/{input_string}")
    public ResponseEntity<?> parse(@PathVariable("input_string") String inputString) {
        return ResponseEntity.ok(service.calculateAndSave(inputString));
    }
}
