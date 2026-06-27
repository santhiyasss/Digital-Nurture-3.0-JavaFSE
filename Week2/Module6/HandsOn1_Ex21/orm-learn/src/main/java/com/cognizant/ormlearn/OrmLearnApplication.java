package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryNotFoundException;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        addCountryTest();
    }

    private static void addCountryTest() {
        LOGGER.info("Start addCountryTest");
        try {
            // Add new country
            Country newCountry = new Country();
            newCountry.setCode("TN");
            newCountry.setName("Tamil Nadu");
            countryService.addCountry(newCountry);
            LOGGER.debug("Country added successfully");

            // Verify by fetching
            Country fetched = countryService.findCountryByCode("TN");
            LOGGER.debug("Fetched added country: {}", fetched);
            LOGGER.info("End addCountryTest");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }
}