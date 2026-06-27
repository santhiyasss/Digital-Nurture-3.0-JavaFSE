package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockService stockService;

    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);

        // HQL queries
        testGetAllCountriesOrderByName();
        testGetCountriesStartingWith();

        // Stock queries
        testGetFacebookStocks();
        testGetGoogleStocksAbovePrice();
        testGetTop3ByVolume();
        testGetBottom3Netflix();
    }

    // HQL - All countries ordered by name
    private static void testGetAllCountriesOrderByName() {
        LOGGER.info("Start testGetAllCountriesOrderByName");
        List<Country> countries = countryService.getAllCountriesOrderByName();
        LOGGER.debug("Countries ordered by name: {}", countries);
        LOGGER.info("End testGetAllCountriesOrderByName");
    }

    // Native Query - Countries starting with 'Z'
    private static void testGetCountriesStartingWith() {
        LOGGER.info("Start testGetCountriesStartingWith");
        List<Country> countries = countryService.getCountriesStartingWithNative("Z");
        LOGGER.debug("Countries starting with Z: {}", countries);
        LOGGER.info("End testGetCountriesStartingWith");
    }

    // HQL - Facebook stocks
    private static void testGetFacebookStocks() {
        LOGGER.info("Start testGetFacebookStocks");
        List<Stock> stocks = stockService.getStocksByCode("FB");
        LOGGER.debug("Facebook stocks: {}", stocks);
        LOGGER.info("End testGetFacebookStocks");
    }

    // HQL - Google stocks above 1250
    private static void testGetGoogleStocksAbovePrice() {
        LOGGER.info("Start testGetGoogleStocksAbovePrice");
        List<Stock> stocks = stockService.getStocksAbovePrice("GOOGL", 1250);
        LOGGER.debug("Google stocks above 1250: {}", stocks);
        LOGGER.info("End testGetGoogleStocksAbovePrice");
    }

    // Native Query - Top 3 by volume
    private static void testGetTop3ByVolume() {
        LOGGER.info("Start testGetTop3ByVolume");
        List<Stock> stocks = stockService.getTop3ByVolume();
        LOGGER.debug("Top 3 stocks by volume: {}", stocks);
        LOGGER.info("End testGetTop3ByVolume");
    }

    // Native Query - Bottom 3 Netflix
    private static void testGetBottom3Netflix() {
        LOGGER.info("Start testGetBottom3Netflix");
        List<Stock> stocks = stockService.getBottom3NetflixByClose();
        LOGGER.debug("Bottom 3 Netflix stocks: {}", stocks);
        LOGGER.info("End testGetBottom3Netflix");
    }
}