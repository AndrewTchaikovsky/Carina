package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
@Endpoint(url = "${base_url}/data/${api_version}/weather?id=${city_id}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/_get/rsNegativeCityID")
@SuccessfulHttpStatus(status = HttpResponseStatusType.BAD_REQUEST_400)
public class RequestWeatherByNegativeCityIDMethod extends AbstractApiMethodV2{
    public RequestWeatherByNegativeCityIDMethod(long negativeCityId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("api_key"));
        replaceUrlPlaceholder("api_version", Configuration.getRequired("api_version"));
        replaceUrlPlaceholder("city_id", String.valueOf(negativeCityId));
    }
}
