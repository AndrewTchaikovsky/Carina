package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather?zip=99999999999999999999,us&appid=01e307599143267de26f1960219c1c57", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/_get/rsVeryLongZip.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class RequestWeatherByVeryLongZipMethod extends AbstractApiMethodV2{
    public RequestWeatherByVeryLongZipMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
