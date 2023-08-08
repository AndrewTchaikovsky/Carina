package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.AbstractEbayPage;
import com.solvd.qa.carina.demo.gui.pages.desktop.SearchPage;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageAbstract extends AbstractPage {
    @FindBy(id = "vlGlobalFooter")
    public AbstractEbayPage footerMenu;
    public HomePageAbstract(WebDriver driver) {
        super(driver);
    }
    public AbstractEbayPage getFooterMenu() {
        return footerMenu;
    }
    public abstract SearchPageBase openSearchPage(String searchInput);
    public abstract AbstractEbayPage getNavigatorMenu();

}
