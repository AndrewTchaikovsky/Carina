package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class OpenWeatherMapAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByCoordinates() throws Exception {
        // preparing of the request
        RequestWeatherByCoordinatesMethod api = new RequestWeatherByCoordinatesMethod();
        // making the call to endpoint
        api.callAPIExpectSuccess();
        // validation of the response
        api.validateResponseAgainstSchema("api/weather/_get/rsCoordinates.schema");
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByCityName() throws Exception {
        RequestWeatherByCityNameMethod api = new RequestWeatherByCityNameMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByCityID() throws Exception {
        RequestWeatherByCityNameMethod api = new RequestWeatherByCityNameMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByZip() throws Exception {
        RequestWeatherByZipMethod api = new RequestWeatherByZipMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherInRussian() throws Exception {
        RequestWeatherByCityIdInRussianMethod api = new RequestWeatherByCityIdInRussianMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherHistoricalData() throws Exception {
        RequestWeatherHistoricalDataMethod api = new RequestWeatherHistoricalDataMethod();
        api.callAPIExpectSuccess();
        LOGGER.info("Not authorized with this level of access.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByCoordinatesWithNullLatitude() throws Exception {
        RequestWeatherByCoordinatesWithNullLatitudeMethod api = new RequestWeatherByCoordinatesWithNullLatitudeMethod();
        api.callAPIExpectSuccess();
        LOGGER.info("The latitude cannot be null.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByNonExistentCityName() throws Exception {
        RequestWeatherByNonExistentCityNameMethod api = new RequestWeatherByNonExistentCityNameMethod();
        api.callAPIExpectSuccess();
        LOGGER.info("The city does not exist.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByNegativeCityID() throws Exception {
        RequestWeatherByNegativeCityIDMethod api = new RequestWeatherByNegativeCityIDMethod();
        api.callAPIExpectSuccess();
        LOGGER.info("The city ID is not valid.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testRequestWeatherByVeryLongZip() throws Exception {
        RequestWeatherByVeryLongZipMethod api = new RequestWeatherByVeryLongZipMethod();
        api.callAPIExpectSuccess();
        LOGGER.info("The city does not exist.");
        api.validateResponse();
    }

}
