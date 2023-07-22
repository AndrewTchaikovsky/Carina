package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/data/${api_version}/weather?lat=${latitude}&lon=${longitude}&appid=${api_key}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class RequestWeatherByCoordinatesMethod extends AbstractApiMethodV2{

    public RequestWeatherByCoordinatesMethod(double latitude, double longitude) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("api_key"));
        replaceUrlPlaceholder("api_version", Configuration.getRequired("api_version"));
        replaceUrlPlaceholder("latitude", String.valueOf(latitude));
        replaceUrlPlaceholder("longitude", String.valueOf(longitude));
    }
}
