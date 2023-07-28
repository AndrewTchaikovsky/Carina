package com.solvd.qa.carina.demo.web;

import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class WebTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void verifyOpeningPage() {
        // Open eBay home page and verify page is opened
        HomePageWeb homePage = initPage(getDriver(), HomePageWeb.class);
        homePage.open();
        homePage.assertPageOpened();
    }

//        // Select phone brand
//        BrandModelsPageBase productsPage = homePage.selectBrand("Samsung");
//        // Select phone model
//        ModelInfoPageBase productInfoPage = productsPage.selectModel("Galaxy A04");
//        // Verify phone specifications
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
//        softAssert.assertEquals(productInfoPage.readCamera(), "50MP", "Invalid camera info!");
//        softAssert.assertEquals(productInfoPage.readRam(), "3-8GB RAM", "Invalid ram info!");
//        softAssert.assertEquals(productInfoPage.readBattery(), "5000mAh", "Invalid battery info!");
//        softAssert.assertAll();
//    }
}
