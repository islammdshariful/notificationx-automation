package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testcases.NxNotificationBar;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

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
        NxNotificationBar.testCaseforNotificationBar(driver, Config.URLS.admin_url, 1);
        driver.close();
//		NxNotificationBar.nxCountdownBarCreate(driver, Config.URLS.login_url, Config.URLS.demosite_url, 2);
//		driver.close();
//		NxNotificationBar.nxCountdownBarCreate(driver, Config.URLS.login_url, Config.URLS.demosite_url, 3);
//		driver.close();
//		NxNotificationBar.nxBarCountdown(driver, Config.URLS.demosite_url, 2);
    }
}
