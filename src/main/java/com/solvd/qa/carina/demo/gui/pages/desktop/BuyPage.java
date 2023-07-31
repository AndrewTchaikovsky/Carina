package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BuyPageBase.class)
public class BuyPage extends BuyPageBase{

    @FindBy(xpath = "//div[@id='wrapper']/div[1]/div/div/div[2]/div[1]/ul")
    private ExtendedWebElement topLevelCategories;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[1]/a")
    private ExtendedWebElement eBayMotorsInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[2]/a")
    private ExtendedWebElement clothingShoesAndAccessoriesInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[3]/a")
    private ExtendedWebElement sportingGoodsInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[4]/a")
    private ExtendedWebElement homeAndGardenInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[5]/a")
    private ExtendedWebElement toysAndHobbiesInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[6]/a")
    private ExtendedWebElement businessAndIndustrialInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[7]/a")
    private ExtendedWebElement healthAndBeautyInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[8]/a")
    private ExtendedWebElement petSuppliesInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[9]/a")
    private ExtendedWebElement babyEssentialsInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[10]/a")
    private ExtendedWebElement electronicsInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[11]/a")
    private ExtendedWebElement collectiblesAndArtInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "li[12]/a")
    private ExtendedWebElement booksMoviesAndMusicInfoLabel;
    @Context(dependsOn = "topLevelCategories")
    @FindBy(xpath = "//div[@id='wrapper']//h1")
    private ExtendedWebElement allCategories;

    public BuyPage(WebDriver driver) {
        super(driver);
        setPageURL("/n/all-categories");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(allCategories);
    }

    @Override
    public String readEBayMotors() {
        assertElementPresent(eBayMotorsInfoLabel);
        return eBayMotorsInfoLabel.getText().trim();
    }

    @Override
    public String readClothingShoesAndAccessories() {
        assertElementPresent(clothingShoesAndAccessoriesInfoLabel);
        return clothingShoesAndAccessoriesInfoLabel.getText();
    }

    @Override
    public String readSportingGoods() {
        assertElementPresent(sportingGoodsInfoLabel);
        return sportingGoodsInfoLabel.getText();
    }

    @Override
    public String readHomeAndGarden() {
        assertElementPresent(homeAndGardenInfoLabel);
        return homeAndGardenInfoLabel.getText();
    }

    @Override
    public String readToysAndHobbies() {
        assertElementPresent(toysAndHobbiesInfoLabel);
        return toysAndHobbiesInfoLabel.getText();
    }

    @Override
    public String readBusinessAndIndustrial() {
        assertElementPresent(businessAndIndustrialInfoLabel);
        return businessAndIndustrialInfoLabel.getText();
    }

    @Override
    public String readHealthAndBeauty() {
        assertElementPresent(healthAndBeautyInfoLabel);
        return healthAndBeautyInfoLabel.getText();
    }

    @Override
    public String readPetSupplies() {
        assertElementPresent(petSuppliesInfoLabel);
        return petSuppliesInfoLabel.getText();
    }

    @Override
    public String readBabyEssentials() {
        assertElementPresent(babyEssentialsInfoLabel);
        return babyEssentialsInfoLabel.getText();
    }

    @Override
    public String readElectronics() {
        assertElementPresent(electronicsInfoLabel);
        return electronicsInfoLabel.getText();
    }

    @Override
    public String readCollectiblesAndArt() {
        assertElementPresent(collectiblesAndArtInfoLabel);
        return collectiblesAndArtInfoLabel.getText();
    }

    @Override
    public String readBooksMoviesAndMusic() {
        assertElementPresent(booksMoviesAndMusicInfoLabel);
        return booksMoviesAndMusicInfoLabel.getText();
    }

}
