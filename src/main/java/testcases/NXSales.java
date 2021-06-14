package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import module.NxSalesNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

import static module.NxSalesNotification.*;

public class NXSales {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void nxSalesTestCase() {
        invokeBrowser();
		driver.get(Config.URLS.login_url);
		WordpressLogin.login(driver);

        createSalesNotification(driver, Config.URLS.admin_url);
        String product_name = doBuy_product(driver);
        salesNotification(driver, product_name);
        Config.delete_notification(driver, 1);

        driver.close();
    }
}
