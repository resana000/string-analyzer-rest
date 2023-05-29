package com.example.stringanalyzerrest.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Entity
@ToString
@AllArgsConstructor
public class StatisticDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ElementCollection
    Map<Character, Integer> charCountMap;

    @ElementCollection
    Map<Character, Integer> charContinuousCountMap;
    int count;

    public StatisticDto() {

    }

    public StatisticDto(Map<Character, Integer> charCountMap, Map<Character, Integer> charContinuousCountMap, int length) {
        this.charCountMap = charCountMap;
        this.charContinuousCountMap = charContinuousCountMap;
        this.count = length;
    }
}
