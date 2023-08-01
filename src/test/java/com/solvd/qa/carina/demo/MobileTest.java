package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.pages.android.PhonePageAndroid;
import com.solvd.qa.carina.demo.gui.pages.common.MainPageGeneral;
import com.solvd.qa.carina.demo.gui.pages.common.PhonePageGeneral;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class MobileTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "achaykovskiy")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testPhoneOpens() {
        MainPageGeneral mainPage = initPage(getDriver(), MainPageGeneral.class);
        PhonePageGeneral phonePage = mainPage.openPhone();
        phonePage.assertPageOpened();
    }

}
