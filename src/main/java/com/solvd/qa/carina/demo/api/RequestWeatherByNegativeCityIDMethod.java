package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
@Endpoint(url = "${base_url}/data/2.5/weather?id=-2172797&appid=01e307599143267de26f1960219c1c57", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/_get/rsNegativeCityID")
@SuccessfulHttpStatus(status = HttpResponseStatusType.BAD_REQUEST_400)
public class RequestWeatherByNegativeCityIDMethod extends AbstractApiMethodV2{
    public RequestWeatherByNegativeCityIDMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
