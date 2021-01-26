package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testcases.NxELearningNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

public class NXELearning {
    WebDriver driver = null;

    @Test
    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test(dependsOnMethods = "invokeBrowser")
    public void nxCommentsTestCase() {
//		driver.get(Config.URLS.login_url);
//		WordpressLogin.login(driver);
        NxELearningNotification.testCaseforELearningNotification(driver, Config.URLS.login_url);
        driver.close();
    }
}
