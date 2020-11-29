package wpdev.nx;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import wpdev.nx.utils.Config;
import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxSalesNotificationUtils;

public class NxSalesNotification {
	public static void double_click_xpth(WebDriver driver, String xpth) {
		try {
			driver.findElement(By.xpath(xpth)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(xpth)).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void double_click_id(WebDriver driver, String xpth) {
		try {
			driver.findElement(By.id(xpth)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(xpth)).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void nxSalesNotificationCreate(WebDriver driver, String edit_url) {
		driver.get(edit_url);

		try {
			// LOGIN
			WordpressLogin.login(driver);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,827)", "");

			// SELECT NOTIFICATIONX
			driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();
			driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
			driver.findElement(By.id(Config.EDITUTILS.add_title_id))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.add_title);

			driver.findElement(By.xpath(Config.EDITUTILS.select_sales_notification_xpath)).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.select_woocommerce_xpath))
					.click();

			driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();

			// -----------------------------------------THEME----------------------------
			// ---------------------------------------PAGE-----------------------------------
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.choose_theme_xpath))
					.click();

			// -----------------------------------DESIGN PAGE------------------------------
			driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();

			// ------------------------------CONTENT PAGE--------------------------

			js.executeScript("window.scrollBy(0,-490)", "");
			Thread.sleep(1000);
			// Clicking on Name
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.template_name_dropdown_xpath);

			// Clicking on product title
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.product_title_dropdown_xpath);

			// Clicking on Define time
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.define_time_dropdown_xpath);

			// Combine multi order
			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_id);
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_text_id))
					.clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_text_id))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.combine_order_txt);

			// Clicking on show purchase of
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.show_purchase_dropdown_xpath);

			// Clicking on exlclude by
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.exclude_by_dropdown_xpath);

			// Link options

			// Clicking on link type
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.link_type_dropdown_xpath);

			driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

			// -----------------------------Display----------------------------
			// image
			// Clicking on default image
			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.show_default_img_id);

			// clicking on image
			double_click_xpth(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.img_dropdown_xpath);

			// visibility
			// clicking on show on
			double_click_xpth(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.showon_dropdown_xpath);
			// clicking on display
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_for_dropdown_xpath);
			driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

			// --------------------------------Customize-----------------------

			// ENABLE SOUND
			js.executeScript("window.scrollBy(0,-490)", "");
			Thread.sleep(1000);
			// clicking on enable sound

			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_sound_xpath))
					.click();
			Thread.sleep(1000);
			// Sound setting
			double_click_xpth(driver,
					nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.select_sound_dropdown_xpth);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,-1300)", "");
			Thread.sleep(2000);

			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_sound_xpath))
					.click();

			double_click_xpth(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.position_dropdown_xpath);

			// Clicking on noti size
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.noti_size_xpth)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.noti_size_xpth))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.notificaion_size);

			// clicking on display close button
			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_close_btn_id);

			// clicking on mobile visibility
			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.mbl_visibility_id);

			// queue management
			// clicking on global queue
			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_global_que_id);

			// timing
			// DELAY BEFORE FIRST NOTIFICATION
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.delay_before_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.delay_before_id))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.delay_before_text);

			// DISPLAY FOR
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_for_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_for_id))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.display_for_text);

			// Behavior
			// DISPLAY FROM
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_from_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_from_id))
					.sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.display_from_text);

			double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.loop_noti_id);

			// clicking on enable open in new tab
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_open_new_tab_id))
					.click();

			// PUBLISHED PAGE
			driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();

			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_option_xpath)).click();
			String product_name = driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.click_product_xpath))
					.getText();
			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.click_product_xpath)).click();

			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_link)).click();

			buy_product(driver, product_name);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void buy_product(WebDriver driver, String product_name) {
		try {

			// PRODUCT PAGE
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(
					driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_name_page)), product_name);
			// ADD TO CART
			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.addtocart_xpath)).click();
			Thread.sleep(2000);

			// Checkout page
			driver.get(nxSalesNotificationUtils.Buy_product.checkout_link);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,945)", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.place_order_xpth)).click();

			Thread.sleep(3000);

			driver.get("http://nx.com/");

			salesNotification(driver, product_name);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void salesNotification(WebDriver driver, String prodcut_name) {
		try {
			SoftAssert softassert = new SoftAssert();
			Thread.sleep(5000);
			driver.findElement(
					By.xpath(nxSalesNotificationUtils.Preview_NotificationX_Sale_locator.product_notification_xpath))
					.click();

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			String actual = driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_name_page))
					.getText();
			softassert.assertEquals(actual, prodcut_name);

			driver.close();
			driver.switchTo().window(tabs2.get(0));

			String name = driver
					.findElement(By
							.xpath(nxSalesNotificationUtils.Preview_NotificationX_Sale_locator.product_purchased_xpath))
					.getText();

			softassert.assertEquals(name, nxSalesNotificationUtils.Sales_notification_TEXT.purchased);
			WebElement time = driver.findElement(By
					.xpath(nxSalesNotificationUtils.Preview_NotificationX_Sale_locator.product_purchasing_time_xpath));
			if (time.isDisplayed()) {
				System.out.println("Time Is VISIBLE");
			} else {
				System.out.println("Time Is NOT VISIBLE");
			}
			Thread.sleep(1500);
//			driver.findElement(By.xpath(nxSalesNotificationUtils.Preview_NotificationX_Sale_locator.notificationX_link))
//					.click();
//			
//
//			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs3.get(1));
//
//			softassert.assertEquals(driver.getTitle().toString(),
//					nxSalesNotificationUtils.Sales_notification_TEXT.notificationX_link_page_title);
//
//			driver.close();
//			driver.switchTo().window(tabs3.get(0));
//
//			Thread.sleep(3000);
			driver.findElement(By
					.xpath(nxSalesNotificationUtils.Preview_NotificationX_Sale_locator.notification_close_button_xpath))
					.click();

			Config.delete_notification(driver);
			softassert.assertAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
