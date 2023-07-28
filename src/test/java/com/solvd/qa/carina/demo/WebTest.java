package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.web.HomePageWeb;
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
}
