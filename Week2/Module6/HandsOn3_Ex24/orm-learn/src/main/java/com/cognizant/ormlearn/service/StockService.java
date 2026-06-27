package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getStocksByCode(String code) {
        return stockRepository.findByCode(code);
    }

    @Transactional
    public List<Stock> getStocksAbovePrice(String code, double price) {
        return stockRepository.findByCodeAndClosePriceGreaterThan(code, price);
    }

    @Transactional
    public List<Stock> getTop3ByVolume() {
        return stockRepository.findTop3ByVolume();
    }

    @Transactional
    public List<Stock> getBottom3NetflixByClose() {
        return stockRepository.findBottom3NetflixByClose();
    }
}