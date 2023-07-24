package com.solvd.qa.carina.demo;

import com.jayway.jsonpath.JsonPath;
import com.solvd.qa.carina.demo.api.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class OpenWeatherMapAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByCoordinates() {
        RequestWeatherByCoordinatesMethod api = new RequestWeatherByCoordinatesMethod(44.34, 10.99);
        Response response = api.callAPIExpectSuccess();
        String jsonResponse = response.asString();
        double latitude = JsonPath.read(jsonResponse, "$.coord.lat");
        double longitude = JsonPath.read(jsonResponse, "$.coord.lon");
        Assert.assertEquals(44.34, latitude, 0.001);
        Assert.assertEquals(10.99, longitude, 0.001);
        api.validateResponseAgainstSchema("api/weather/_get/rsCoordinates.schema");
    }

    @Test(dataProvider = "testData", dataProviderClass = RequestWeatherByCityNameMethod.class)
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByCityName(String cityName) {
        RequestWeatherByCityNameMethod api = new RequestWeatherByCityNameMethod(cityName);
        Response response = api.callAPIExpectSuccess();
        String jsonResponse = response.asString();
        String city = JsonPath.read(jsonResponse, "$.name");
        Assert.assertEquals(cityName, city);
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByZip() {
        RequestWeatherByZipMethod api = new RequestWeatherByZipMethod(11235);
        api.setProperties("weather.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByCityIdWithLanguage() {
        RequestWeatherByCityIdWithLanguageMethod api = new RequestWeatherByCityIdWithLanguageMethod(2172797, "kr");
        Response response = api.callAPIExpectSuccess();
        String jsonResponse = response.asString();
        String id = JsonPath.read(jsonResponse, "$.id").toString();
        Assert.assertEquals("2172797", id);
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherHistoricalData() {
        RequestWeatherHistoricalDataMethod api = new RequestWeatherHistoricalDataMethod(-16.92, 145.77);
        api.callAPIExpectSuccess();
        LOGGER.info("Not authorized with this level of access.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByCoordinatesWithNullLatitude() {
        RequestWeatherByCoordinatesWithNullLatitudeMethod api = new RequestWeatherByCoordinatesWithNullLatitudeMethod(10);
        api.callAPIExpectSuccess();
        LOGGER.info("The latitude cannot be null.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByNonExistentCityName() {
        RequestWeatherByNonExistentCityNameMethod api = new RequestWeatherByNonExistentCityNameMethod("BarbieTown");
        api.callAPIExpectSuccess();
        LOGGER.info("The city does not exist.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByNegativeCityID() {
        RequestWeatherByNegativeCityIDMethod api = new RequestWeatherByNegativeCityIDMethod(-2172797);
        api.callAPIExpectSuccess();
        LOGGER.info("The city ID is not valid.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByVeryLongZip() {
        RequestWeatherByIncorrectZipMethod api = new RequestWeatherByIncorrectZipMethod("999999999999999999999999999");
        api.callAPIExpectSuccess();
        LOGGER.info("The city does not exist.");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    public void testRequestWeatherByZipWithLetters() {
        RequestWeatherByIncorrectZipMethod api = new RequestWeatherByIncorrectZipMethod("zip");
        api.callAPIExpectSuccess();
        LOGGER.info("The zip cannot be null.");
        api.validateResponse();
    }

}
