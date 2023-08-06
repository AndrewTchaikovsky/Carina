package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.RequestWeatherByCityNameMethod;
import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.solvd.qa.carina.demo.gui.pages.desktop.BuyPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.util.MyAsserts.assertTrue;

public class WebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testBuyCategories() {
        // Open eBay home page and verify page is opened
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        homePage.assertPageOpened();
        // Open buy page and verify page is opened
        BuyPageBase buyPage = homePage.getFooterMenu().openBuyPage();
        buyPage.assertPageOpened();
        // Verify text in buy categories
        List<String> buyLinks = buyPage.getBuyLinks();
        List<String> buyLinksNames = Arrays.asList("eBay Motors", "Clothing, Shoes & Accessories");
        for (String buyLinkName : buyLinksNames) {
            assertTrue(buyLinks.contains(buyLinkName), "Link is not present " + buyLinkName);
        }
    }

    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testLogoLeadsHome() {
        // Open eBay home page and verify page is opened
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        homePage.assertPageOpened();
        // Open sell page and verify page is opened
        SellPageBase sellPage = homePage.getFooterMenu().openSellPage();
        sellPage.assertPageOpened();
        // Verify eBay logo leads to home page and verify home page is opened
        sellPage.clickLogo().assertPageOpened();
    }

    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        // Open eBay home page and verify page is opened
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        homePage.assertPageOpened();
        // Checking that all search results have search word
        final String searchQ = "Samsung";
        List<SearchItem> searchItems = homePage.openSearchPage(searchQ).searchByName();
        Assert.assertFalse(CollectionUtils.isEmpty(searchItems), "Items not found!");

        SoftAssert softAssert = new SoftAssert();
        for (SearchItem searchItem : searchItems) {
            String title = searchItem.readTitle().trim();
            if (!title.isEmpty()) {
                LOGGER.info(title);
                softAssert.assertTrue(StringUtils.containsIgnoreCase(title, searchQ),
                        "Invalid search results for " + title);
            }
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "containerData", dataProviderClass = BuyPage.class)
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testContainers(String containerName, List<String> containerLinkNames) {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        homePage.assertPageOpened();

        BuyPageBase buyPage = homePage.getFooterMenu().openBuyPage();
        buyPage.assertPageOpened();

        List<String> containerLinks = buyPage.getContainerLinks(containerName);
        for (String containerLinkName : containerLinkNames) {
            assertTrue(containerLinks.contains(containerLinkName), "Link is not present " + containerLinkName);
        }
    }

}
