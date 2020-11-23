package wpdev.nx;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import wpdev.nx.utils.Config;
import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxNotificationBarUtils;
import wpdev.nx.utils.nxNotificationBarUtils.CountDown_TEXT;

public class NxNotificationBar {
	public static void nxCountdownBarCreate(WebDriver driver, String edit_url, String preview_url, int theme) {
		try {
			driver.get(edit_url);
			// LOGIN
			WordpressLogin.login(driver);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,827)", "");

			// SELECT NOTIFICATION BAR
			driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();
			
			driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
			driver.findElement(By.id(Config.EDITUTILS.add_title_id)).sendKeys(CountDown_TEXT.add_title);
			driver.findElement(By.xpath(Config.EDITUTILS.select_notification_bar_xpath)).click();

			// NEXT
			driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
			
			// SELECT COUNTDOWN THEME 
			if(theme == 1) {
				driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
				System.out.println("Number :one: theme is Selected");
			}else if(theme == 2) {
				driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.select_countdown_2_xpath)).click();
				System.out.println("Number :two: theme is Selected");
				Thread.sleep(1000);
				driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
			}else {
				driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.select_countdown_3_xpath)).click();
				System.out.println("Number :three: theme is Selected");
				Thread.sleep(1000);
				driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
			}
			System.out.println(":heavy_check_mark: Theme Seleted Done.");

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
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.start_date_field_id)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.start_choose_date_xpath)).click();

			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.end_date_field_id)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.arrow_down_xpath)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.end_choose_date_xpath)).click();

			// NEXT
			driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

			// NEXT
			driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id)).clear();
			Thread.sleep(1000);
			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id))
					.sendKeys(nxNotificationBarUtils.CountDown_TEXT.notification_initial_delay_text);

			// PUBLISHED
			driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();

			// NOTIFICATION HOME PAGE
			driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();

			Thread.sleep(2000);
			nxBarCountdown(driver, preview_url, theme);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void nxBarCountdown(WebDriver driver, String url, int theme) {
		driver.get(url);
		SoftAssert softAssert = new SoftAssert();
		try {
			Thread.sleep(1000);
			
			softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_text_xpath)).getText(),
					nxNotificationBarUtils.CountDown_TEXT.countdown_text);
			
			System.out.println("Countdown text is VISIBLE");
			softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_content_xpath)).getText(),
					nxNotificationBarUtils.CountDown_TEXT.notification_content);

			WebElement day = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_day_xpath));
			WebElement hour = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_hour_xpath));
			WebElement min = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_min_xpath));
			WebElement sec = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath));

			String second = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath)).getText();
			
			if (day.isDisplayed() && hour.isDisplayed() && min.isDisplayed() && sec.isDisplayed()) {
				System.out.println("Countdown timer Passed !!");
				if(theme == 3) {
					softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_day_text_xpath)).getText(),
							nxNotificationBarUtils.CountDown_TEXT.notification_countdown_day_text);
					softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_hour_text_xpath)).getText(),
							nxNotificationBarUtils.CountDown_TEXT.notification_countdown_hour_text);
					softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_min_text_xpath)).getText(),
							nxNotificationBarUtils.CountDown_TEXT.notification_countdown_min_text);
					softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_text_xpath)).getText(),
							nxNotificationBarUtils.CountDown_TEXT.notification_countdown_sec_text);
					
				}

				String new_second = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath)).getText();
				
				if( second != new_second) {
					System.out.println("Notification countdown is working");
				}else {
					System.out.println("Notification countdown is NOT working");
				}
				
			}

			Thread.sleep(1000);
			softAssert.assertEquals(driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_xpath)).getText(),
					nxNotificationBarUtils.CountDown_TEXT.notification_button_text);

			if(theme == 1) {
				driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_1_xpath)).click();
			}else{
				driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_xpath)).click();
			}
			
			Thread.sleep(2000);
			softAssert.assertEquals(driver.getTitle(), nxNotificationBarUtils.CountDown_TEXT.button_url_page_title_text);
			driver.navigate().back();
			Thread.sleep(4000);
			
			if(theme == 1) {
				driver.findElement(By.xpath("/html/body/div[3]/div/p")).click();
			}else {
				driver.findElement(By.className(nxNotificationBarUtils.CountDown_Locator.notification_close_class)).click();
			}
			
			Thread.sleep(1000);
			
			Config.delete_notification(driver);
			softAssert.assertAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
