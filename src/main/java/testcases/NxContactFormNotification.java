package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import utils.Config;
import utils.WordpressLogin;
import utils.nxContactFromNotificationUtils;
import utils.nxContactFromNotificationUtils.edit_contactform_notification_LOCATOR;
import utils.nxContactFromNotificationUtils.preview_contactform_notification_LOCATOR;
import utils.Config.EDITUTILS;

public class NxContactFormNotification {
    public static void testCaseforContactFormNotification(WebDriver driver, String url) {
        createContactFormNotification(driver, url);
        doSubmitForm(driver);
        contactFormNotification(driver);
        Config.delete_notification(driver, 0);
    }

    public static void doSubmitForm(WebDriver driver) {
        driver.get(nxContactFromNotificationUtils.TEXT.contact_form_url);
        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_fname_id))
                .sendKeys(nxContactFromNotificationUtils.TEXT.input_fname_text);
        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_lname_id))
                .sendKeys(nxContactFromNotificationUtils.TEXT.input_lname_text);
        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_email_id))
                .sendKeys(nxContactFromNotificationUtils.TEXT.input_email_text);
        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_message_id))
                .sendKeys(nxContactFromNotificationUtils.TEXT.input_message_text);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,308)", "");
        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.submit_button_id)).click();
    }

//    public static void doSubmitForm(WebDriver driver) {
//        driver.get(nxContactFromNotificationUtils.TEXT.contact_form_url);
//        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_fname_id))
//                .sendKeys(nxContactFromNotificationUtils.TEXT.input_fname_text);
//        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_lname_id))
//                .sendKeys(nxContactFromNotificationUtils.TEXT.input_lname_text);
//        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_email_id))
//                .sendKeys(nxContactFromNotificationUtils.TEXT.input_email_text);
//        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.input_message_id))
//                .sendKeys(nxContactFromNotificationUtils.TEXT.input_message_text);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,308)", "");
//        driver.findElement(By.id(nxContactFromNotificationUtils.contact_LOCATOR.submit_button_id)).click();
//    }

    public static void contactFormNotification(WebDriver driver) {
        driver.get(Config.URLS.demosite_url);
        SoftAssert softassert = new SoftAssert();
        try {
            WebElement image = driver.findElement(By.xpath(preview_contactform_notification_LOCATOR.img_xpth));
            if (image.isDisplayed()) {
                System.out.println("Notification avatar is Visible");
            } else {
                System.out.println("Notification avatar is NOT Visible");
            }

            softassert.assertEquals(
                    driver.findElement(By.xpath(preview_contactform_notification_LOCATOR.name_xpth)).getText(),
                    nxContactFromNotificationUtils.TEXT.name_text, "NAME TEXT IS FAILED");

            softassert.assertEquals(
                    driver.findElement(By.xpath(preview_contactform_notification_LOCATOR.contactform_xpth)).getText(),
                    nxContactFromNotificationUtils.TEXT.contacform_name_text, "CONTACT FORM TEXT IS FAILED");
            Thread.sleep(1000);

            WebElement time = driver.findElement(By.xpath(preview_contactform_notification_LOCATOR.time_xpth));
            if (time.isDisplayed()) {
                System.out.println("Time is Visible");
            } else {
                System.out.println("Time is NOT Visible");
            }

            Thread.sleep(1000);
            driver.findElement(By.xpath(preview_contactform_notification_LOCATOR.close_btn_xpth)).click();
            Thread.sleep(1000);
            softassert.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void createContactFormNotification(WebDriver driver, String edit_url) {
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
                    .sendKeys(nxContactFromNotificationUtils.TEXT.add_title);

            // SELETECT CONTACT FORM NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_contactform_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxContactFromNotificationUtils.edit_contactform_notification_LOCATOR.choose_wpform_xpth))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
            // -----------------------------------Design----------------------------------
            // CHOOSE THEME
            js.executeScript("window.scrollBy(0,528)", "");
            Thread.sleep(1000);
            driver.findElement(
                    By.xpath(nxContactFromNotificationUtils.edit_contactform_notification_LOCATOR.choose_theme_xpth))
                    .click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            // --------------------------------------Content------------------------------
//			Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.name_dropdown_xpth);
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-289)", "");
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.select_form_dropdown_xpth)).click();
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.input_select_form_xpth))
                    .sendKeys(nxContactFromNotificationUtils.TEXT.slelect_form_text);
            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.input_select_form_xpth))
                    .sendKeys(Keys.ENTER);

            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.noti_template_name_xpth)).click();
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.input_tem_name_xpth))
                    .sendKeys(nxContactFromNotificationUtils.TEXT.noti_tem_name_text);
            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.input_tem_name_xpth))
                    .sendKeys(Keys.ENTER);

            driver.findElement(By.id(edit_contactform_notification_LOCATOR.input_tem_text_id)).click();
            driver.findElement(By.id(edit_contactform_notification_LOCATOR.input_tem_text_id)).clear();
            driver.findElement(By.id(edit_contactform_notification_LOCATOR.input_tem_text_id))
                    .sendKeys(nxContactFromNotificationUtils.TEXT.tem_text);

            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.title_drpdwn_xpth);

            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.time_drpdwn_xpth);

            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();
            // ---------------------------------------Display---------------------------------
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-205)", "");
            driver.findElement(By.id(edit_contactform_notification_LOCATOR.show_default_img_id)).click();
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.choose_img_xpth)).click();

            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.img_drpdwn_xpth);

            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.showon_dropdown_xpth);
            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.displayfor_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // ---------------------------------------Customize---------------------------------
            // Appearance
            js.executeScript("window.scrollBy(0,-358)", "");
            driver.findElement(By.xpath(edit_contactform_notification_LOCATOR.enable_sound_xpth)).click();
            Thread.sleep(1000);
//			Config.double_click_xpth(driver, edit_downstat_notification_LOCATOR.select_sound_dropdown_xpth);
//			js.executeScript("window.scrollBy(0,-1500)", "");

            Config.double_click_xpth(driver, edit_contactform_notification_LOCATOR.postion_dropdown_xpth);

            driver.findElement(By.id(edit_contactform_notification_LOCATOR.noti_size_id)).clear();
            driver.findElement(By.id(edit_contactform_notification_LOCATOR.noti_size_id))
                    .sendKeys(Config.EDITUTILS.noti_size_text);
            Config.double_click_id(driver, Config.EDITUTILS.display_close_btn_id);
            Config.double_click_id(driver, Config.EDITUTILS.mbl_visibility_id);
            // Queue Management
            Config.double_click_id(driver, edit_contactform_notification_LOCATOR.enable_glb_queue_id);

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

            Config.double_click_id(driver, Config.EDITUTILS.loop_noti_id);
            driver.findElement(By.id(Config.EDITUTILS.open_in_new_tab_id)).click();

            driver.findElement(By.xpath(EDITUTILS.published_button_xpath)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
