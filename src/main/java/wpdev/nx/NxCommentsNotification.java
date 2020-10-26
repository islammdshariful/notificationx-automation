package wpdev.nx;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wpdev.nx.utils.Config;
import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxCommentsNotificationUtils;

public class NxCommentsNotification {
	public static void comment(WebDriver driver, String url) {
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1358)", "");
		
		driver.findElement(By.id("comment")).sendKeys(nxCommentsNotificationUtils.TEXT.comment_text);
		driver.findElement(By.id("submit")).click();
	}
	
	public static void commentNotification(WebDriver driver) {
		driver.get("http://devmode.local/");
		
		try {
			Thread.sleep(2000);
			
			WebElement image = driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_image_xpath));
			if(image.isDisplayed()) {
				System.out.println("Notification avatar is Visible");
			}
			assertEquals(driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_name_xpath)).getText(), nxCommentsNotificationUtils.TEXT.comment_name_text);
			System.out.println("Avatar name passed !!");
			assertEquals(driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_content_xpath)).getText(), nxCommentsNotificationUtils.TEXT.comment_text);
			System.out.println("Comment content passed !!");
			Thread.sleep(2000);
//			WebElement link = driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_content_xpath));
//			Actions cursor = new Actions(driver);
//			cursor.moveToElement(link).click().build().perform();
			
			driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_link_xpath)).click();
			
			Thread.sleep(2000);
			assertEquals(driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.post_page_title_xpath)).getText(), nxCommentsNotificationUtils.TEXT.post_name_text);			
			System.out.println("Post title passed !!");
			driver.navigate().back();
			Thread.sleep(4000);
			driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.notificationX_link)).click();
			
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution");
			System.out.println("NotificationX link passed !!");
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			
//			Thread.sleep(3000);
			driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.notification_close_button_xpath)).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void nxCommentsNotificationCreate(WebDriver driver, String edit_url) {
		driver.get(edit_url);

		// LOGIN
		WordpressLogin.login(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,827)", "");

		// NAVIGATE TO NOTIFICATIONX
		driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();

		// NAME THE NOTIFICATIONX
		driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
		driver.findElement(By.id(Config.EDITUTILS.add_title_id)).sendKeys(nxCommentsNotificationUtils.TEXT.add_title);

		// SELETECT COMMENT NOTIFICATION
		driver.findElement(By.xpath(Config.EDITUTILS.select_comments_notification_xpath)).click();
		driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.select_woocommerce_xpath)).click();
		driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();

		// CHOOSE THEME
		driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.choose_theme_xpath)).click();
		driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
		
		driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();
		driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();
		
		//SET POSITION
		driver.findElement(By.xpath(Config.EDITUTILS.position_dropdown_xpath)).click();
		driver.findElement(By.xpath(Config.EDITUTILS.position_type_xpath)).sendKeys("Right");
		driver.findElement(By.xpath(Config.EDITUTILS.position_type_xpath)).sendKeys(Keys.ENTER);

		
		
		//SET TIME
		driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).sendKeys(nxCommentsNotificationUtils.TEXT.delay_before_text);
		driver.findElement(By.id(Config.EDITUTILS.display_for_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.display_for_id)).sendKeys(nxCommentsNotificationUtils.TEXT.display_for_text);
		driver.findElement(By.id(Config.EDITUTILS.display_from_id)).clear();
		driver.findElement(By.id(Config.EDITUTILS.display_from_id)).sendKeys(nxCommentsNotificationUtils.TEXT.display_from_text);
		driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();
		
		comment(driver, "http://devmode.local/commentsnotificationx/");
		commentNotification(driver);
	}
}
