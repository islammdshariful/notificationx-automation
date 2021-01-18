package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testcases.NxSalesNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

public class NXSales {
    WebDriver driver = null;

    @Test
    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test(dependsOnMethods = "invokeBrowser")
    public void nxSalesTestCase() {
//		driver.get("http://nx.com/wp-login.php");
//		WordpressLogin.login(driver);
        NxSalesNotification.testCaseforSalesNotification(driver, Config.URLS.login_url);
        driver.close();
    }
}
