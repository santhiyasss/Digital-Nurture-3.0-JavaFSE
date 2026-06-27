package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // HQL - Get stocks by code
    @Query("SELECT s FROM Stock s WHERE s.code = :code")
    List<Stock> findByCode(@Param("code") String code);

    // HQL - Get stocks where close price greater than value
    @Query("SELECT s FROM Stock s WHERE s.code = :code AND s.close > :price")
    List<Stock> findByCodeAndClosePriceGreaterThan(
        @Param("code") String code,
        @Param("price") double price);

    // Native Query - Top 3 by volume
    @Query(value = "SELECT * FROM stock ORDER BY st_volume DESC LIMIT 3",
           nativeQuery = true)
    List<Stock> findTop3ByVolume();

    // Native Query - Bottom 3 Netflix by close price
    @Query(value = "SELECT * FROM stock WHERE st_code = 'NFLX' ORDER BY st_close ASC LIMIT 3",
           nativeQuery = true)
    List<Stock> findBottom3NetflixByClose();
}