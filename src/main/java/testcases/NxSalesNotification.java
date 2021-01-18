package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.asserts.SoftAssert;

import utils.Config;
import utils.WordpressLogin;
import utils.nxSalesNotificationUtils;

public class NxSalesNotification {
    public static void testCaseforSalesNotification(WebDriver driver, String url) {
        createSalesNotification(driver, url);
        String product_name = doBuy_product(driver);
//		String product_name = "Organic Handpicked Coffee";
        salesNotification(driver, product_name);
        Config.delete_notification(driver, 1);
    }

    public static void createSalesNotification(WebDriver driver, String edit_url) {
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
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.template_name_dropdown_xpath);

            // Clicking on product title
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.product_title_dropdown_xpath);

            // Clicking on Define time
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.define_time_dropdown_xpath);

            // Combine multi order
            Config.double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_id);
            driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_text_id))
                    .clear();
            driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.combine_multi_text_id))
                    .sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.combine_order_txt);

            // Clicking on show purchase of
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.show_purchase_dropdown_xpath);

            // Clicking on exlclude by
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.exclude_by_dropdown_xpath);

            // Link options

            // Clicking on link type
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.link_type_dropdown_xpath);

            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

            // -----------------------------Display----------------------------
            // image
            // Clicking on default image
            js.executeScript("window.scrollBy(0,-174)", "");
            Config.double_click_id(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.show_default_img_id);

            // clicking on image
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.img_dropdown_xpath);

            // visibility
            // clicking on show on
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.showon_dropdown_xpath);
            // clicking on display
            Config.double_click_xpth(driver,
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
            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.select_sound_dropdown_xpth);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-1300)", "");
            Thread.sleep(2000);

            driver.findElement(By.xpath(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_sound_xpath))
                    .click();

            Config.double_click_xpth(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.position_dropdown_xpath);

            // Clicking on noti size
            driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.noti_size_xpth)).clear();
            driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.noti_size_xpth))
                    .sendKeys(nxSalesNotificationUtils.Sales_notification_TEXT.notificaion_size);

            // clicking on display close button
            Config.double_click_id(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.display_close_btn_id);

            // clicking on mobile visibility
            Config.double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.mbl_visibility_id);

            // queue management
            // clicking on global queue
            Config.double_click_id(driver,
                    nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_global_que_id);

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

            Config.double_click_id(driver, nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.loop_noti_id);

            // clicking on enable open in new tab
            driver.findElement(By.id(nxSalesNotificationUtils.Edit_NotificationX_Sale_locator.enable_open_new_tab_id))
                    .click();

            // PUBLISHED PAGE
            driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static String doBuy_product(WebDriver driver) {
        driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_option_xpath)).click();
        WebElement product = driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_xpath));
        String product_name = product.getText();
        WebElement view_product = driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.view_product_xpth));
        Actions cursor = new Actions(driver);
        cursor.moveToElement(product).moveToElement(view_product).click().build().perform();
        // PRODUCT PAGE
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.product_name_page)),
                product_name);
        // ADD TO CART
        driver.findElement(By.xpath(nxSalesNotificationUtils.Buy_product.addtocart_xpath)).click();

        // Checkout page
        driver.get(nxSalesNotificationUtils.Buy_product.checkout_link);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.findElement(By.id(nxSalesNotificationUtils.Buy_product.place_order_id)).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/main/article/header/h1")));
//		String checkout = element.getText();
//		softassert.assertEquals(checkout, "Checkout");
        return product_name;
    }

    public static void salesNotification(WebDriver driver, String prodcut_name) {
        try {
            driver.get(Config.URLS.demosite_url);
            SoftAssert softassert = new SoftAssert();
            Thread.sleep(10000);
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

//			Config.delete_notification(driver);
            softassert.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
