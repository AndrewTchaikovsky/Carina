package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.pages.android.PhonePageAndroid;
import com.solvd.qa.carina.demo.gui.pages.common.MainPageAbstract;
import com.solvd.qa.carina.demo.gui.pages.common.PhonePageAbstract;
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
        MainPageAbstract mainPage = initPage(getDriver(), MainPageAbstract.class);
        PhonePageAbstract phonePage = mainPage.openPhone();
        phonePage.assertPageOpened();
    }

}
