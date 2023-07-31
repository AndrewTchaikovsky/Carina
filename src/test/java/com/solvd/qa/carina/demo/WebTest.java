package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageGeneral;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testBuyCategories() {
        // Open eBay home page and verify page is opened
        HomePageGeneral homePage = initPage(getDriver(), HomePageGeneral.class);
        homePage.open();
        homePage.assertPageOpened();
        // Open buy page and verify page is opened
        BuyPageBase buyPage = homePage.getFooterMenu().openBuyPage();
        buyPage.assertPageOpened();
        // Verify text in buy categories
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(buyPage.readEBayMotors(), "eBay Motors\n" +
                "selected - internal link", "Invalid eBay Motors info!");
        softAssert.assertEquals(buyPage.readClothingShoesAndAccessories(), "Clothing, Shoes & Accessories\n" +
                "- internal link", "Invalid Clothing, Shoes & Accessories info!");
        softAssert.assertEquals(buyPage.readSportingGoods(), "Sporting Goods\n" +
                "- internal link", "Invalid Sporting Goods info!");
        softAssert.assertEquals(buyPage.readHomeAndGarden(), "Home & Garden\n" +
                "- internal link", "Invalid Home and Garden info!");
        softAssert.assertEquals(buyPage.readToysAndHobbies(), "Toys & Hobbies\n" +
                "- internal link", "Invalid Toys & Hobbies info!");
        softAssert.assertEquals(buyPage.readBusinessAndIndustrial(), "Business & Industrial\n" +
                "- internal link", "Invalid Business & Industrial info!");
        softAssert.assertEquals(buyPage.readHealthAndBeauty(), "Health & Beauty\n" +
                "- internal link", "Invalid Health & Beauty info!");
        softAssert.assertEquals(buyPage.readPetSupplies(), "Pet Supplies\n" +
                "- internal link", "Invalid Pet Supplies info!");
        softAssert.assertEquals(buyPage.readBabyEssentials(), "Baby Essentials\n" +
                "- internal link", "Invalid Baby Essentials info!");
        softAssert.assertEquals(buyPage.readElectronics(), "Electronics\n" +
                "- internal link", "Invalid Electronics info!");
        softAssert.assertEquals(buyPage.readCollectiblesAndArt(), "Collectibles & Art\n" +
                "- internal link", "Invalid Collectibles & Art info!");
        softAssert.assertEquals(buyPage.readBooksMoviesAndMusic(), "Books, Movies & Music\n" +
                "- internal link", "Invalid Books, Movies & Music info!");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLogoLeadsHome() {
        // Open eBay home page and verify page is opened
        HomePageGeneral homePage = initPage(getDriver(), HomePageGeneral.class);
        homePage.open();
        homePage.assertPageOpened();
        // Open sell page and verify page is opened
        SellPageBase sellPage = homePage.getFooterMenu().openSellPage();
        sellPage.assertPageOpened();
        // Verify eBay logo leads to home page
        sellPage.clickLogo();
        homePage.assertPageOpened();
    }

    @Test
    @MethodOwner(owner = "achaykovskiy")
    @TestLabel(name = "feature", value = { "web", "acceptance" })
    public void testSearch() {
        // Open eBay home page and verify page is opened
        HomePageGeneral homePage = initPage(getDriver(), HomePageGeneral.class);
        homePage.open();
        homePage.assertPageOpened();
        // Checking that all search results have search word
        final String searchQ = "Samsung";
        List<SearchItem> searchItems = homePage.search(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(searchItems), "Items not found!");

        SoftAssert softAssert = new SoftAssert();
        for (SearchItem searchItem : searchItems) {
            String title = searchItem.readTitle().trim();
            if (!title.isEmpty()) {
                System.out.println(title);
                softAssert.assertTrue(StringUtils.containsIgnoreCase(title, searchQ),
                        "Invalid search results for " + title);
            }
        }
        softAssert.assertAll();
    }

}
