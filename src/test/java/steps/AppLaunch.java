package steps;

import com.jalasoft.sdfc.pages.AppLaunchPage;
import cucumber.api.java.en.And;

public class AppLaunch {
    @And("I click on the App Launcher button and select item {string}")
    public void iClickOnTheAppLauncherButtonAndSelectItem(String arg0) {
        AppLaunchPage appLaunchPage = new AppLaunchPage();
        appLaunchPage.LaunchApp(arg0);
    }
}
