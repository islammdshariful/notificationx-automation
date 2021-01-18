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
import utils.WordpressLogin;
import utils.nxDonationNotificationUtils;
import utils.nxDonationNotificationUtils.edit_donation_notification_LOCATOR;
import utils.nxDonationNotificationUtils.preview_donation_notification_LOCATOR;
import utils.Config.EDITUTILS;
import utils.nxDownloadStatNotificationUtils.TEXT;
import utils.nxDownloadStatNotificationUtils.edit_downstat_notification_LOCATOR;

public class NxDonationNotification {
    public static void testCaseforDonationNotification(WebDriver driver, String url) {
        createDonationNotification(driver, url);
//		doDonation(driver);
        donationNotification(driver);
        Config.delete_notification(driver, 1);
    }

    public static void doDonation(WebDriver driver) {
        driver.get(nxDonationNotificationUtils.donate_locator.donation_form_url);
//		Actions cursor = new Actions(driver);
//		WebElement btn = driver.findElement(By.xpath(nxDonationNotificationUtils.donate_locator.donate_next_page_xpth));
//		cursor.moveToElement(btn).click().build().perform();
//		driver.findElement(By.xpath(nxDonationNotificationUtils.donate_locator.donate_next_page_xpth)).click();
//		driver.findElement(By.className("give-btn advance-btn")).click();
        driver.findElement(By.id(nxDonationNotificationUtils.donate_locator.donate_ammount_id)).click();
        driver.findElement(By.id(nxDonationNotificationUtils.donate_locator.donate_ammount_id)).clear();
        driver.findElement(By.id(nxDonationNotificationUtils.donate_locator.donate_ammount_id)).sendKeys("123");
        driver.findElement(By.xpath(nxDonationNotificationUtils.donate_locator.continute_button_xpth)).click();
        driver.findElement(By.id(nxDonationNotificationUtils.donate_locator.final_donate_now_button_id)).click();
    }

    public static void donationNotification(WebDriver driver) {
        driver.get(Config.URLS.demosite_url);
        SoftAssert softassert = new SoftAssert();
        try {
            WebElement image = driver.findElement(By.xpath(preview_donation_notification_LOCATOR.img_xpth));
            if (image.isDisplayed()) {
                System.out.println("Notification avatar is Visible");
            } else {
                System.out.println("Notification avatar is NOT Visible");
            }

            WebElement name = driver.findElement(By.xpath(preview_donation_notification_LOCATOR.name_xpth));
            if(name.isDisplayed()) {
                System.out.println("Name is Visible");
            }else {
                System.out.println("Name is NOT Visible");
            }

//			softassert.assertEquals(
//					driver.findElement(By.xpath(preview_donation_notification_LOCATOR.name_xpth)).getText(),
//					nxDonationNotificationUtils.TEXT.name_text, "NAME TEXT IS FAILED");

            softassert.assertEquals(
                    driver.findElement(By.xpath(preview_donation_notification_LOCATOR.donate_xpth)).getText(),
                    nxDonationNotificationUtils.TEXT.donation_name_text, "DONATE NOTE TEXT IS FAILED");
            Thread.sleep(1000);
            driver.findElement(By.xpath(preview_donation_notification_LOCATOR.donate_page_link_xpth)).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            softassert.assertEquals(driver.getTitle(), nxDonationNotificationUtils.TEXT.donation_page_title, "PAGE TITLE IS FAILED");
            driver.close();
            driver.switchTo().window(tabs.get(0));

            WebElement time = driver.findElement(By.xpath(preview_donation_notification_LOCATOR.time_xpth));
            if (time.isDisplayed()) {
                System.out.println("Time is Visible");
            } else {
                System.out.println("Time is NOT Visible");
            }

//			Thread.sleep(2000);
//			driver.findElement(By.xpath(preview_donation_notification_LOCATOR.notificationX_link_xpth)).click();
//
//			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs2.get(1));
//
//			softassert.assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution",
//					"NOTIFCATION LINK IS FAILED");
////			System.out.println("NotificationX link passed !!");
//			driver.close();
//			driver.switchTo().window(tabs2.get(0));

            Thread.sleep(1000);
            driver.findElement(By.xpath(preview_donation_notification_LOCATOR.close_btn_xpth)).click();
//			Thread.sleep(2000);
            softassert.assertAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void createDonationNotification(WebDriver driver, String edit_url) {
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
                    .sendKeys(nxDonationNotificationUtils.TEXT.add_title);

            // SELETECT DONATION NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_donation_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxDonationNotificationUtils.edit_donation_notification_LOCATOR.choose_givewp_xpth))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
            // -----------------------------------Design----------------------------------
            // CHOOSE THEME
            js.executeScript("window.scrollBy(0,-566)", "");
            Thread.sleep(1000);
            driver.findElement(
                    By.xpath(nxDonationNotificationUtils.edit_donation_notification_LOCATOR.choose_theme_xpth)).click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            // --------------------------------------Content------------------------------
//			Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.name_dropdown_xpth);
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-358)", "");
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.name_dropdown_xpth)).click();
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.input_name_xpth))
                    .sendKeys(nxDonationNotificationUtils.TEXT.name_title);
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.input_name_xpth)).sendKeys(Keys.ENTER);

            driver.findElement(By.id(nxDonationNotificationUtils.edit_donation_notification_LOCATOR.input_from_id))
                    .clear();
            driver.findElement(By.id(edit_donation_notification_LOCATOR.input_from_id))
                    .sendKeys(nxDonationNotificationUtils.TEXT.from_title);

            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.city_drpdwn_xpth)).click();
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.input_city_xpth))
                    .sendKeys(nxDonationNotificationUtils.TEXT.city_title);
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.input_city_xpth)).sendKeys(Keys.ENTER);

            driver.findElement(By.id(edit_donation_notification_LOCATOR.input_donate_txt_id)).clear();
            driver.findElement(By.id(edit_donation_notification_LOCATOR.input_donate_txt_id))
                    .sendKeys(nxDonationNotificationUtils.TEXT.donate_txt);
            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.title_drpdwn_xpth);

            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.show_noti_drpdwn_xpth);

            // Link type
            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.link_type_drpdwn_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();
            // ---------------------------------------Display---------------------------------
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-205)", "");
            Config.double_click_id(driver, edit_donation_notification_LOCATOR.show_default_img_id);
            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.img_drpdwn_xpth);

            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.showon_dropdown_xpth);
            Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.displayfor_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // ---------------------------------------Customize---------------------------------
            // Appearance
            js.executeScript("window.scrollBy(0,-490)", "");
            driver.findElement(By.xpath(edit_downstat_notification_LOCATOR.enable_sound_xpth)).click();
            Thread.sleep(1000);
//			Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.select_sound_dropdown_xpth);
//			js.executeScript("window.scrollBy(0,-1500)", "");

            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.postion_dropdown_xpth)).click();
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.type_position_xpth))
                    .sendKeys(nxDonationNotificationUtils.TEXT.position_text);
            driver.findElement(By.xpath(edit_donation_notification_LOCATOR.type_position_xpth)).sendKeys(Keys.ENTER);

            driver.findElement(By.id(edit_donation_notification_LOCATOR.noti_size_id)).clear();
            driver.findElement(By.id(edit_donation_notification_LOCATOR.noti_size_id)).sendKeys(TEXT.noti_size_text);
            Config.double_click_id(driver, edit_donation_notification_LOCATOR.display_close_btn_id);
            Config.double_click_id(driver, edit_donation_notification_LOCATOR.mbl_visibility_id);
            // Queue Management
            Config.double_click_id(driver, edit_donation_notification_LOCATOR.enable_glb_queue_id);

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

            Config.double_click_id(driver, edit_donation_notification_LOCATOR.loop_noti_id);
            driver.findElement(By.id(edit_donation_notification_LOCATOR.open_in_new_tab_id)).click();

            driver.findElement(By.xpath(EDITUTILS.published_button_xpath)).click();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
