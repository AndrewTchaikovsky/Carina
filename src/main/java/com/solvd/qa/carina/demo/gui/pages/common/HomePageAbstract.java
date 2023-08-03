package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.footer.FooterMenuDesktop;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageAbstract extends AbstractPage {

    protected HomePageAbstract(WebDriver driver) {
        super(driver);
    }

    public abstract FooterMenuDesktop getFooterMenu();

    public abstract SearchPageBase openSearchPage(String searchQ);
}
