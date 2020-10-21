package wpdev.nx;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wpdev.nx.utils.Config;
import wpdev.nx.utils.WordpressLogin;
import wpdev.nx.utils.nxSalesNotificationUtils;

public class NxSalesNotification {
	public static void nxSalesNotificationCreate(WebDriver driver, String edit_url) {

		try {
			driver.get(edit_url);
			// LOGIN
			WordpressLogin.login(driver);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,827)", "");

			// SELECT NOTIFICATIONX
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sales.notificationX_xpath)).click();
			driver.findElement(By.className(nxSalesNotificationUtils.Edit_NotificationX_Sales.add_new_class)).click();
			driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sales.add_title_id))
					.sendKeys(nxSalesNotificationUtils.Sales_TEXT.add_title);

			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.select_sales_notification_xpath))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.select_woocommerce_xpath)).click();

			driver.findElement(By.className(nxSalesNotificationUtils.Edit_NotificationX_Sales.next_button_class))
					.click();

			// THEME PAGE
			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.choose_theme_xpath)).click();

			// DESIGN PAGE
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sales.next_design_button_xpath))
					.click();

			// CONTENT PAGE
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sales.next_content_button_xpath))
					.click();

			// DISPLAY PAGE
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sales.next_display_button_xpath))
					.click();

			// ENABLE SOUND
//			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.enable_sound_xpath)).click();

			// DELAY BEFORE FIRST NOTIFICATION
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.delay_before_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.delay_before_id))
					.sendKeys(nxSalesNotificationUtils.Sales_TEXT.delay_before_text);

			// DISPLAY FOR
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.display_for_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.display_for_id))
					.sendKeys(nxSalesNotificationUtils.Sales_TEXT.display_for_text);

			// DISPLAY FROM
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.display_from_id)).clear();
			driver.findElement(By.id(nxSalesNotificationUtils.Sales_notification.display_from_id))
					.sendKeys(nxSalesNotificationUtils.Sales_TEXT.display_from_text);

			// PUBLISHED PAGE
			driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sales.published_button_xpath))
					.click();

			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_option_xpath)).click();
			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.click_product_xpath)).click();

			Thread.sleep(2000);
			String get_url = driver.getCurrentUrl();
			System.out.println(get_url);
			String[] arrOfStr = get_url.split("=", -2);
			String pd_link = arrOfStr[1];
			String[] get_id = pd_link.split("&");
			String pd_id = get_id[0];
			System.out.println(pd_id);

			driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_link)).click();

			buy_product(driver, pd_id);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void buy_product(WebDriver driver, String id) {
		try {

			// PRODUCT PAGE
			String product_name = driver.findElement(By.xpath("//*[@id=\"product-" + id + "\"]/div[2]/h1")).getText();

			// ADD TO CART
			driver.findElement(By.xpath("//*[@id=\"product-" + id + "\"]/div[2]/form/button")).click();
			Thread.sleep(2000);

			// Checkout page
			driver.get(nxSalesNotificationUtils.Buy_product.checkout_link);
			WebElement cod = driver.findElement(By.id(nxSalesNotificationUtils.Buy_product.choose_cod_id));
			if(!cod.isSelected()) {
				WebElement click_cod = driver.findElement(By.id(nxSalesNotificationUtils.Buy_product.choose_cod_id));
				click_cod.click();	
			}
			Thread.sleep(2000);
			WebElement order = driver.findElement(By.id(nxSalesNotificationUtils.Buy_product.place_order_id));
			order.click();
//			driver.findElement(By.id(nxSalesNotificationUtils.Buy_product.place_order_id)).click();
//			try {
//				driver.findElement(By.name("woocommerce_checkout_place_order")).click();
//			}
//			catch(org.openqa.selenium.StaleElementReferenceException ex)
//			{
//				driver.findElement(By.name("woocommerce_checkout_place_order")).click();
//			}
			
			Thread.sleep(5000);
			
			driver.get("http://devmode.local/");

			salesNotification(driver, product_name, id);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void salesNotification(WebDriver driver, String prodcut_name, String p_id) {
//		driver.get(Config.URLS.demosite_url);
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.product_notification_xpath)).click();
			
			String actual = driver.findElement(By.xpath("//*[@id=\"product-" + p_id + "\"]/div[2]/h1")).getText();
			assertEquals(actual, prodcut_name);
			driver.navigate().back();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath(nxSalesNotificationUtils.Sales_notification.notification_close_button_xpath)).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
