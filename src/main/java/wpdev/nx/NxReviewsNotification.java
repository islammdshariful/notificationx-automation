package wpdev.nx;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wpdev.nx.utils.Config;
import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxReviewsNotificationUtils;

public class NxReviewsNotification {
	public static void commentNotification(WebDriver driver, String p_name) {
		driver.get("http://devmode.local/");
		System.out.println("Passit" + p_name);
		try {
			Thread.sleep(2000);

			WebElement image = driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.review_image_xpath));
			if (image.isDisplayed()) {
				System.out.println("Notification avatar is Visible");
			}
			assertEquals(driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.review_name_xpath)).getText(),
					nxReviewsNotificationUtils.TEXT.comment_name_text);
			System.out.println("Avatar name passed !!");
			System.out.println("try" + p_name);
			assertEquals(driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.review_product_name_xpath))
					.getText(), p_name);
			System.out.println("Review Product passed !!");
			Thread.sleep(2000);
//			WebElement link = driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_content_xpath));
//			Actions cursor = new Actions(driver);
//			cursor.moveToElement(link).click().build().perform();

			// PRODUCT REVIEW LINK
			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.reviews_link_xpath)).click();
			ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			assertEquals(
					driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.product_page_title_xpath)).getText(),
					p_name);
			System.out.println("Review link passed !!");
			driver.close();
			driver.switchTo().window(tabs1.get(0));
			Thread.sleep(4000);

			// NOTIFICATIONX LINK
			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.notificationX_link)).click();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution");
			System.out.println("NotificationX link passed !!");
			driver.close();
			driver.switchTo().window(tabs2.get(0));

			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.notification_close_button_xpath)).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void review(WebDriver driver) {
		try {
			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.product_option_menu_xpath)).click();
			Thread.sleep(1000);
			String product_name = driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.product_edit_xpath))
					.getText();
			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.product_edit_xpath)).click();
			Thread.sleep(3000);
			System.out.println(product_name);
			driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.product_link_xpath)).click();

			driver.findElement(By.id("tab-title-reviews")).click();
			driver.findElement(By.id("comment")).sendKeys(nxReviewsNotificationUtils.TEXT.review_text);
			driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[5]")).click();
			driver.findElement(By.id("submit")).click();
			commentNotification(driver, product_name);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void nxReviewsNotificationCreate(WebDriver driver, String edit_url) {
		driver.get(edit_url);

		// LOGIN
		WordpressLogin.login(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,827)", "");

		// NAVIGATE TO NOTIFICATIONX
		driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();

		// NAME THE NOTIFICATIONX
		driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
		driver.findElement(By.id(Config.EDITUTILS.add_title_id)).sendKeys(nxReviewsNotificationUtils.TEXT.add_title);

		// SELETECT REVIEWS NOTIFICATION
		driver.findElement(By.xpath(Config.EDITUTILS.select_reviews_notification_xpath)).click();
		driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.select_woocommerce_xpath)).click();
		driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();

		// CHOOSE THEME
		driver.findElement(By.xpath(nxReviewsNotificationUtils.LOCATOR.choose_theme_xpath)).click();
		driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();

		// CONTENT
		driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

		// DISPLAY
		driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

		// CUSTOMIZE
		driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.delay_before_id))
				.sendKeys(nxReviewsNotificationUtils.TEXT.delay_before_text);
		driver.findElement(By.id(Config.EDITUTILS.display_for_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.display_for_id))
				.sendKeys(nxReviewsNotificationUtils.TEXT.display_for_text);
		driver.findElement(By.id(Config.EDITUTILS.display_from_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.display_from_id))
				.sendKeys(nxReviewsNotificationUtils.TEXT.display_from_text);

		driver.findElement(By.id(Config.EDITUTILS.enable_open_new_tab_id)).click();
		driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();

		review(driver);
	}
}
