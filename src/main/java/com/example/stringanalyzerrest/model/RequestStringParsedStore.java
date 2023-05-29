package com.example.stringanalyzerrest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RequestStringParsedStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String naturalId;

    String income;

    @OneToOne
    StatisticDto statisticDto;
}
