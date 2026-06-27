package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Search countries containing text (case insensitive)
    List<Country> findByNameContaining(String keyword);

    // Search countries containing text sorted ascending by name
    List<Country> findByNameContainingOrderByNameAsc(String keyword);

    // Search countries starting with a letter
    List<Country> findByNameStartingWith(String letter);
}