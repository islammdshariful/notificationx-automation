package wpdev.nx.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import wpdev.nx.NxContactFromNotification;
import wpdev.nx.utils.Config;
import wpdev.nx.utils.DriverManager;
import wpdev.nx.utils.WordpressLogin;

public class NX_ContactFromNotification {
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
	public void nxContactFormTestCase() {
//		SoftAssert softassert = new SoftAssert();
		NxContactFromNotification.nxContactFormNotificationCreate(driver, Config.URLS.login_url);
//		driver.get("http://nx.com/wp-login.php");
//		WordpressLogin.login(driver);
//		NxContactFromNotification.preview(driver);
//		driver.close();
	}
}