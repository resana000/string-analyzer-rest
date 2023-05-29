package com.example.stringanalyzerrest.repo;

import com.example.stringanalyzerrest.model.RequestStringParsedStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestStringParsedStore, Long> {
}
