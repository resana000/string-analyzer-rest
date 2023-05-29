package com.example.stringanalyzerrest.service;

import com.example.stringanalyzerrest.model.RequestStringParsedStore;
import com.example.stringanalyzerrest.model.StatisticDto;
import com.example.stringanalyzerrest.repo.RequestRepository;
import com.example.stringanalyzerrest.repo.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    StatisticRepository statisticRepository;

    public RequestStringParsedStore calculateAndSave(String str) {
        RequestStringParsedStore requestStringParsedStore = new RequestStringParsedStore();
        requestStringParsedStore.setNaturalId(new Date().toString() + UUID.randomUUID());
        requestStringParsedStore.setIncome(str);
        requestStringParsedStore.setStatisticDto(calculateCharCount(str));
        return requestRepository.save(requestStringParsedStore);
    }

    public StatisticDto calculateCharCount(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Integer> charContinuousCountMap = new HashMap<>();
        for (int i = 0; i < str.toCharArray().length; i++) {
            Character c = str.toCharArray()[i];
            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
                charContinuousCountMap.put(c, 0);
            } else {
                charCountMap.put(c, charCountMap.get(c) + 1);
                int inc = i;
                while (i < str.toCharArray().length && c == (str.toCharArray()[inc++])) {
                    charContinuousCountMap.put(c, charContinuousCountMap.get(c) + 1);
                    if (inc == str.toCharArray().length) break;
                }
            }
        }
        return statisticRepository.save(new StatisticDto(charCountMap, charContinuousCountMap, str.length()));
    }

    public List<RequestStringParsedStore> getAll() {
        return requestRepository.findAll();
    }

}
