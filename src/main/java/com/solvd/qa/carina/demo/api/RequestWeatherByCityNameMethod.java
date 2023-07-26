package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.DataProvider;

@Endpoint(url = "${base_url}/data/${api_version}/weather?q=${city_name}&appid=${api_key}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class RequestWeatherByCityNameMethod extends AbstractApiMethodV2 {
    public RequestWeatherByCityNameMethod(String cityName) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("api_key"));
        replaceUrlPlaceholder("api_version", Configuration.getRequired("api_version"));
        replaceUrlPlaceholder("city_name", cityName);
    }

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{
                {"Delhi", 1273294},
                {"Miami", 4164138},
                {"Seoul", 1835848}
        };
    }

}
