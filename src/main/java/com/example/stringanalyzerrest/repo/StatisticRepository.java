package com.example.stringanalyzerrest.repo;

import com.example.stringanalyzerrest.model.RequestStringParsedStore;
import com.example.stringanalyzerrest.model.StatisticDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticDto, Long> {
}
