package com.solvd.qa.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/data/${api_version}/weather?zip=${very_long_zip},us&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/_get/rsVeryLongZip.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class RequestWeatherByVeryLongZipMethod extends AbstractApiMethodV2{
    public RequestWeatherByVeryLongZipMethod(String veryLongZip) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("api_key"));
        replaceUrlPlaceholder("api_version", Configuration.getRequired("api_version"));
        replaceUrlPlaceholder("very_long_zip", veryLongZip);
    }
}
