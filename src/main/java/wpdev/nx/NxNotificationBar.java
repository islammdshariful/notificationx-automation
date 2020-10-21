package wpdev.nx;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxNotificationBarUtils;
import wpdev.nx.utils.nxNotificationBarUtils.CountDown_TEXT;

public class NxNotificationBar {
	public static void nxCountdownBarCreate(WebDriver driver, String edit_url, String preview_url) {
		try {
			driver.get(edit_url);
			// LOGIN
			WordpressLogin.login(driver);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,827)", "");

			// SELECT NOTIFICATION BAR
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.notificationX_xpath)).click();
			driver.findElement(By.className(nxNotificationBarUtils.Edit_NotificationX_bar.add_new_class)).click();
			driver.findElement(By.id(nxNotificationBarUtils.Edit_NotificationX_bar.add_title_id))
					.sendKeys(CountDown_TEXT.add_title);
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.select_notification_bar_xpath))
					.click();

			// NEXT
			driver.findElement(By.className(nxNotificationBarUtils.Edit_NotificationX_bar.next_button_class)).click();

			// SELECT COUNTDOWN THEME
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.select_countdown_xpath)).click();

			Thread.sleep(1000);
			// NEXT
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.next_design_button_xpath))
					.click();

			// CONTENT
			driver.switchTo().frame("nx_meta_press_content_ifr");
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.content_type_xpath)).click();
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.content_type_xpath))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.add_content);
			driver.switchTo().parentFrame();
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.button_text_id))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.notification_button_text);
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.button_url_id))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.button_url_text);

			// ENABLE COUNTDOWN
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.enable_countdown_id)).click();
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.countdown_text_id))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.countdown_text);

			// expiry date
			WebElement start_date = driver
					.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.start_date_field_id));
			String start_date_text = "arguments[0].setAttribute('value','"
					+ nxNotificationBarUtils.CountDown_TEXT.start_date_text + "')";
			((JavascriptExecutor) driver).executeScript(start_date_text, start_date);

			Thread.sleep(3000);
//			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.start_date_field_id)).click();
//			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.start_choose_date_xpath)).click();

			WebElement end_date = driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.end_date_field_id));
			String end_date_text = "arguments[0].setAttribute('value','"
					+ nxNotificationBarUtils.CountDown_TEXT.end_date_text + "')";
			((JavascriptExecutor) driver).executeScript(end_date_text, end_date);

//			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.end_date_field_id)).click();
//			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.end_choose_date_xpath)).click();

			// NEXT
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.next_contect_button_xpath))
					.click();

			// NEXT
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.next_display_button_xpath))
					.click();

			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id)).clear();
			Thread.sleep(1000);
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.notification_initial_delay_text);

			// PUBLISHED
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.published_button_xpath)).click();

			// NOTIFICATION HOME PAGE
			driver.findElement(By.xpath(nxNotificationBarUtils.Edit_NotificationX_bar.notificationX_xpath)).click();

			driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[6]/div[5]/table/tbody/tr[1]/td[1]/div/strong"))
					.click();
			Thread.sleep(2000);
			String get_url = driver.getCurrentUrl();
			System.out.println(get_url);
			String[] arrOfStr = get_url.split("=", -2);
			String nx_id = arrOfStr[2];
			System.out.println(nx_id);
			nxBarCountdown(driver, nx_id, preview_url);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void nxBarCountdown(WebDriver driver, String id, String url) {
		driver.get(url);
		try {
			Thread.sleep(5000);

			assertEquals(driver.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[1]/div[1]")).getText(),
					nxNotificationBarUtils.CountDown_TEXT.countdown_text);

			assertEquals(driver.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[2]/div")).getText(),
					nxNotificationBarUtils.CountDown_TEXT.notification_content);

			WebElement day = driver
					.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[1]/div[2]/div[1]"));

			WebElement hour = driver
					.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[1]/div[2]/div[2]"));

			WebElement min = driver
					.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[1]/div[2]/div[3]"));

			WebElement sec = driver
					.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[1]/div[2]/div[4]"));

			if (day.isDisplayed() && hour.isDisplayed() && min.isDisplayed() && sec.isDisplayed()) {
				System.out.println("Countdown timer Passed !!");
			}

			Thread.sleep(2000);
			assertEquals(driver.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[2]/a")).getText(),
					nxNotificationBarUtils.CountDown_TEXT.notification_button_text);

			driver.findElement(By.xpath("//*[@id=\"nx-bar-" + id + "\"]/div/div/div[2]/a")).click();
			Thread.sleep(2000);
			assertEquals(driver.getTitle(), nxNotificationBarUtils.CountDown_TEXT.button_url_page_title_text);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.className(nxNotificationBarUtils.CountDown_Locator.notification_close_class)).click();
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
