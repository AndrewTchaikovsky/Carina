package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.AbstractEbayPage;
import com.solvd.qa.carina.demo.gui.components.EbayPageDesktop;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageAbstract extends AbstractPage {

    public HomePageAbstract(WebDriver driver) {
        super(driver);
    }
    public abstract AbstractEbayPage getFooterMenu();

    public abstract EbayPageDesktop getTopLevelBar();

    public abstract SearchPageBase openSearchPage(String searchInput);
    public abstract AbstractEbayPage getNavigatorMenu();

}
