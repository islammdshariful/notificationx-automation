package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import utils.Config;
import utils.Config.EDITUTILS;
import utils.WordpressLogin;
import utils.nxDownloadStatNotificationUtils;
import utils.nxDownloadStatNotificationUtils.TEXT;
import utils.nxDownloadStatNotificationUtils.edit_downstat_notification_LOCATOR;
import utils.nxDownloadStatNotificationUtils.preview_downstat_notification_LOCATOR;

public class NxDownloadStatNotification {
    public static void testCaseforDownloadStatNotification(WebDriver driver, String url) {
        createnxDownStatNotification(driver, url);
        downloadStatNotification(driver);
        Config.delete_notification(driver, 1);
    }

    public static void downloadStatNotification(WebDriver driver) {
        try {
            driver.get(Config.URLS.demosite_url);
            Thread.sleep(5000);
            SoftAssert softassert = new SoftAssert();
            driver.findElement(By.xpath(preview_downstat_notification_LOCATOR.plugin_link_xpth)).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            softassert.assertEquals(driver.getTitle(), TEXT.plugin_page_title, "PAGE TITLE IS FAILED");
            driver.close();
            driver.switchTo().window(tabs.get(0));

//			driver.findElement(By.xpath(preview_downstat_notification_LOCATOR.notificationX_link_xpth)).click();
//
//			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs2.get(1));
//
//			softassert.assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution",
//					"NOTIFCATION LINK IS FAILED");
//			driver.close();
//			driver.switchTo().window(tabs2.get(0));

            Thread.sleep(1000);
            driver.findElement(By.xpath(preview_downstat_notification_LOCATOR.close_btn_xpth)).click();
            Thread.sleep(1000);
            softassert.assertAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createnxDownStatNotification(WebDriver driver, String edit_url) {
        driver.get(edit_url);

        try {
            // LOGIN
            WordpressLogin.login(driver);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,827)", "");

            // NAVIGATE TO NOTIFICATIONX
            driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();
            // ------------------------------------Source-----------------------------
            // NAME THE NOTIFICATIONX
            driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
            driver.findElement(By.id(Config.EDITUTILS.add_title_id))
                    .sendKeys(nxDownloadStatNotificationUtils.TEXT.add_title);

            // SELETECT REVIEWS NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_downloadstats_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxDownloadStatNotificationUtils.edit_downstat_notification_LOCATOR.choose_wordpress_xpth))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
            // -----------------------------------Design----------------------------------
            // CHOOSE THEME
            driver.findElement(
                    By.xpath(nxDownloadStatNotificationUtils.edit_downstat_notification_LOCATOR.choose_theme_xpth))
                    .click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            // --------------------------------------Content------------------------------
            js.executeScript("window.scrollBy(0,-581)", "");
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.product_type_dropdown_xpth);
            driver.findElement(By.id(edit_downstat_notification_LOCATOR.slug_id)).sendKeys(TEXT.slug_name_text);
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.name_dropdown_xpth);
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.days_dropdow_xpth);
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.from_days_dropdown_xpth);

            // Link type
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.linktype_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();
            // ---------------------------------------Display---------------------------------
            js.executeScript("window.scrollBy(0,-174)", "");
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.showon_dropdown_xpth);
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.displayfor_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // ---------------------------------------Customize---------------------------------
            // Appearance
            js.executeScript("window.scrollBy(0,-490)", "");
            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.enable_sound_xpth)).click();
            Thread.sleep(1000);
            Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.select_sound_dropdown_xpth);
            js.executeScript("window.scrollBy(0,-1500)", "");

            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.enable_sound_xpth)).click();

            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.postion_dropdown_xpth)).click();
            ;
            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.type_position_xpth))
                    .sendKeys(TEXT.position_text);
            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.type_position_xpth)).sendKeys(Keys.ENTER);

            driver.findElement(By.id(edit_downstat_notification_LOCATOR.noti_size_id)).clear();
            driver.findElement(By.id(edit_downstat_notification_LOCATOR.noti_size_id)).sendKeys(TEXT.noti_size_text);
            Config.double_click_id(driver, edit_downstat_notification_LOCATOR.display_close_btn_id);
            Config.double_click_id(driver, edit_downstat_notification_LOCATOR.mbl_visibility_id);
            // Queue Management
            Config.double_click_id(driver, edit_downstat_notification_LOCATOR.enable_glb_queue_id);

            // Timing
            // SET TIME
            // DELAY BEFORE FIRST NOTIFICATION
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).sendKeys(Config.EDITUTILS.delay_before_text);
            // DISPLAY FOR
            driver.findElement(By.id(Config.EDITUTILS.display_for_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_for_id)).sendKeys(Config.EDITUTILS.display_for_text);
            // Behavior
            // DISPLAY FROM
            driver.findElement(By.id(Config.EDITUTILS.display_from_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_from_id)).sendKeys(Config.EDITUTILS.display_from_text);

            Config.double_click_id(driver, edit_downstat_notification_LOCATOR.loop_noti_id);
            driver.findElement(By.id(edit_downstat_notification_LOCATOR.open_in_new_tab_id)).click();
            ;
            driver.findElement(By.xpath(EDITUTILS.published_button_xpath)).click();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
