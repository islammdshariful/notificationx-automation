package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import module.NxELearningNotification;
import utils.Config;
import utils.DriverManager;
import utils.WordpressLogin;

import static module.NxELearningNotification.*;

public class NXELearning {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test
    public void nxCommentsTestCase() {
        invokeBrowser();
		driver.get(Config.URLS.login_url);
		WordpressLogin.login(driver);

        createELearningNotification(driver, Config.URLS.admin_url);
        String username = newCandidate(driver);
//		String username = "SUBS095753 USER just enrolled";
        eLearnignNotification(driver, username);
        driver.get(Config.URLS.login_url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WordpressLogin.login(driver);
        Config.delete_notification(driver, 1);

        driver.close();
    }
}
