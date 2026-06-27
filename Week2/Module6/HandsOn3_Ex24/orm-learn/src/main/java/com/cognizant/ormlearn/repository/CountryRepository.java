package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // HQL Query - get all countries ordered by name
    @Query("SELECT c FROM Country c ORDER BY c.name")
    List<Country> findAllOrderByName();

    // Native Query - get countries starting with a letter
    @Query(value = "SELECT * FROM country WHERE co_name LIKE :letter%",
           nativeQuery = true)
    List<Country> findByNameStartingWithNative(String letter);
}