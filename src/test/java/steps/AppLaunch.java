package steps;

import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.Header;
import cucumber.api.java.en.And;

public class AppLaunch {

    @And("I click on the AppLauncher Icon")
    public void iClickOnTheAppLauncherIcon() {
        Header header = new Header();
        header.clickAppLauncherIcon();
    }

    @And("I select the item {string}")
    public void iSelectTheItem(String item) {
        AppLaunchPage appLauncher = new AppLaunchPage();
        appLauncher.clickOnItem(item);
    }
}
