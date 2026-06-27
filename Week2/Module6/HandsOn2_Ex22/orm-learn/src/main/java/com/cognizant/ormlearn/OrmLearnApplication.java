package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
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

    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        searchByKeywordTest();
        searchByKeywordSortedTest();
        searchByStartingLetterTest();
    }

    // Search countries containing 'ou'
    private static void searchByKeywordTest() {
        LOGGER.info("Start searchByKeywordTest");
        List<Country> countries = countryService.searchCountriesByKeyword("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End searchByKeywordTest");
    }

    // Search countries containing 'ou' sorted ascending
    private static void searchByKeywordSortedTest() {
        LOGGER.info("Start searchByKeywordSortedTest");
        List<Country> countries = countryService.searchCountriesSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", countries);
        LOGGER.info("End searchByKeywordSortedTest");
    }

    // Search countries starting with 'Z'
    private static void searchByStartingLetterTest() {
        LOGGER.info("Start searchByStartingLetterTest");
        List<Country> countries = countryService.getCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End searchByStartingLetterTest");
    }
}