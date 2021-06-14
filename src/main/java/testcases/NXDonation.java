package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import module.NxDonationNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

import static module.NxDonationNotification.*;

public class NXDonation {
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

        createDonationNotification(driver, Config.URLS.admin_url);
        doDonation(driver);
        donationNotification(driver);
        Config.delete_notification(driver, 1); //if re-generate option is available put 1 else 0

        driver.close();
    }
}
