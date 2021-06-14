package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import module.NxNotificationBar;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

import static module.NxNotificationBar.createNotificationBar;
import static module.NxNotificationBar.nxBar;

public class NXNotificationBar {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void nxBarCountdownTestCase() {
        invokeBrowser();
        driver.get(Config.URLS.login_url);
        WordpressLogin.login(driver);

        byte theme = 1; // put theme number accordingly
        createNotificationBar(driver, Config.URLS.admin_url, theme);
        nxBar(driver, theme);
        Config.delete_notification(driver, 3);

        driver.close();
    }
}
