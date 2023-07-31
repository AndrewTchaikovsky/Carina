package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class BuyPageBase extends AbstractPage {
    protected BuyPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readEBayMotors();
    public abstract String readClothingShoesAndAccessories();
    public abstract String readSportingGoods();
    public abstract String readHomeAndGarden();
    public abstract String readToysAndHobbies();
    public abstract String readBusinessAndIndustrial();
    public abstract String readHealthAndBeauty();
    public abstract String readPetSupplies();
    public abstract String readBabyEssentials();
    public abstract String readElectronics();
    public abstract String readCollectiblesAndArt();
    public abstract String readBooksMoviesAndMusic();
}
