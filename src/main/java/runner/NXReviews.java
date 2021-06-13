package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testcases.NxReviewsNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

public class NXReviews {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void nxCommentsTestCase() {
        invokeBrowser();
		driver.get(Config.URLS.login_url);
		WordpressLogin.login(driver);
        NxReviewsNotification.testCaseforReviewNotification(driver, Config.URLS.admin_url);
        driver.close();
    }
}
