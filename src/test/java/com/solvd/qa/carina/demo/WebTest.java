package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.dp.WebDP;
import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
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

    // WEB BROWSER ONLY
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

    // WEB BROWSER ONLY
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

    // WEB AND MOBILE
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

    // WEB BROWSER ONLY
    @Test(dataProvider = "containerData", dataProviderClass = WebDP.class)
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
    // COULD NOT FIND AN ACTION TO SWIPE TO COLLECTIBLES LINK
    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P5)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testCollectiblePopularCategories() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        homePage.assertPageOpened();

        CollectiblesPageBase collectiblesPage = homePage.getNavigatorMenu().openCollectiblesPage();
        collectiblesPage.assertPageOpened();

        List<String> popularCategoriesLinks = collectiblesPage.getPopularCategoriesLinks();
        List<String> popularCategoriesNames = Arrays.asList("Sports Trading Cards", "Toys & Hobbies", "Coins & Paper Money", "Collectible Card Games", "Sports Memorabilia");
        for (String popularCategoriesName : popularCategoriesNames) {
            assertTrue(popularCategoriesLinks.contains(popularCategoriesName), "Link is not present " + popularCategoriesName);
        }
    }

}
