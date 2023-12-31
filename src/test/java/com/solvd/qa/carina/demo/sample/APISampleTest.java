package com.solvd.qa.carina.demo.sampletests;

import java.lang.invoke.MethodHandles;

import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.qa.carina.demo.sample.api.DeleteUserMethod;
import com.solvd.qa.carina.demo.sample.api.GetUserMethods;
import com.solvd.qa.carina.demo.sample.api.PostUserMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Andrew")
    public void testCreateUser() throws Exception {
//        LOGGER.info("test");
//        setCases("4555,54545");

        // preparing of the request
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
//        Properties properties = new Properties();
//        properties.put("name", "Leanne Graham");
//        properties.put("username", "generate_word(8)");
//        properties.put("company_name", "generate_word(8)");
//        api.setProperties(properties);
        api.addProperty("company_name", "AAA");

        // making the call to endpoint
        Response response = api.callAPIExpectSuccess();
        String loc = response.getHeader("Location");
        String zip = response.jsonPath().getString("0.address.zipcode");
        LOGGER.info("zip=" + zip);

//        Assert.assertEquals(zip, "11111", "zip is not as expected");

//        AtomicInteger counter = new AtomicInteger(0);

//        api.callAPIWithRetry()
//                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
//                .peek(rs -> counter.getAndIncrement())
//                .until(rs -> counter.get() == 4)
//                .pollEvery(1, ChronoUnit.SECONDS)
//                .stopAfter(10, ChronoUnit.SECONDS)
//                .execute();

        // validation of the response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("sample/api/users/user.properties");
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setProperties("api/users/user.properties");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

}
