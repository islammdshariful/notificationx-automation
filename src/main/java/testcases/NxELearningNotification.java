package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import utils.Config;
import utils.WordpressLogin;
import utils.Config.EDITUTILS;
import utils.nxELearningNotificationUtils;
import utils.nxELearningNotificationUtils.edit_elearning_notification_LOCATOR;
import utils.nxELearningNotificationUtils.preview_learning_notification_LOCATOR;

public class NxELearningNotification {
    public static void testCaseforELearningNotification(WebDriver driver, String url) {
        createELearningNotification(driver, url);
        String username = newCandidate(driver);
//		String username = "SUBS095753 USER just enrolled";
        eLearnignNotification(driver, username);
        driver.get(Config.URLS.login_url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WordpressLogin.login(driver);
        Config.delete_notification(driver, 1);
    }
    public static String newCandidate(WebDriver driver) {
        String username = Config.create_subs(driver);
        Config.logout(driver);
        WordpressLogin.login(driver, username, "1234");

        // Enrolling
        driver.get("http://nx.com/courses/notifciationx-automation-for-tutor-lms/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,610)", "");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div/div[1]/div[4]/form/div/button"))
                .click();
        return username;
    }

    public static void eLearnignNotification(WebDriver driver, String username) {
        driver.get(Config.URLS.demosite_url);
        SoftAssert softassert = new SoftAssert();
        try {
            WebElement image = driver.findElement(By.xpath(preview_learning_notification_LOCATOR.img_xpth));
            if (image.isDisplayed()) {
                System.out.println("Notification avatar is Visible");
            } else {
                System.out.println("Notification avatar is NOT Visible");
            }

            softassert.assertEquals(
                    driver.findElement(By.xpath(preview_learning_notification_LOCATOR.name_xpth)).getText(),
                    username.toUpperCase() + " " + nxELearningNotificationUtils.TEXT.tem_text, "NAME TEXT IS FAILED");

            softassert.assertEquals(
                    driver.findElement(By.xpath(preview_learning_notification_LOCATOR.coursename_xpth)).getText(),
                    nxELearningNotificationUtils.TEXT.course_name_text, "COURSE NAME TEXT IS FAILED");
            Thread.sleep(1000);

            WebElement time = driver.findElement(By.xpath(preview_learning_notification_LOCATOR.time_xpth));
            if (time.isDisplayed()) {
                System.out.println("Time is Visible");
            } else {
                System.out.println("Time is NOT Visible");
            }

            driver.findElement(
                    By.xpath(nxELearningNotificationUtils.preview_learning_notification_LOCATOR.course_link_xpth))
                    .click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            softassert.assertEquals(driver.getTitle(), nxELearningNotificationUtils.TEXT.course_page_title, "POST TITLE IS FAILED");
            driver.close();
            driver.switchTo().window(tabs.get(0));

//			Thread.sleep(4000);
//			driver.findElement(
//					By.xpath(nxELearningNotificationUtils.preview_learning_notification_LOCATOR.notificationX_link_xpth))
//					.click();
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
            driver.findElement(By.xpath(preview_learning_notification_LOCATOR.close_btn_xpth)).click();
            Thread.sleep(1000);
            softassert.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void createELearningNotification(WebDriver driver, String edit_url) {
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
                    .sendKeys(nxELearningNotificationUtils.TEXT.add_title);

            // SELETECT CONTACT FORM NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_elearning_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxELearningNotificationUtils.edit_elearning_notification_LOCATOR.choose_tutor_xpth))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
            // -----------------------------------Design----------------------------------
            // CHOOSE THEME
            js.executeScript("window.scrollBy(0,528)", "");
            Thread.sleep(1000);
            driver.findElement(
                    By.xpath(nxELearningNotificationUtils.edit_elearning_notification_LOCATOR.choose_theme_xpth))
                    .click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            // --------------------------------------Content------------------------------
//			Config.double_click_xpth(driver, edit_donation_notification_LOCATOR.name_dropdown_xpth);
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-289)", "");
            driver.findElement(By.xpath(edit_elearning_notification_LOCATOR.select_tem_name_dropdown_xpth)).click();
            driver.findElement(By.xpath(edit_elearning_notification_LOCATOR.input_tem_name_xpth))
                    .sendKeys(nxELearningNotificationUtils.TEXT.slelect_tem_name_text);
            Thread.sleep(1000);
            driver.findElement(By.xpath(edit_elearning_notification_LOCATOR.input_tem_name_xpth)).sendKeys(Keys.ENTER);

            Thread.sleep(1000);
            driver.findElement(By.id(edit_elearning_notification_LOCATOR.input_tem_text_id)).clear();
            driver.findElement(By.id(edit_elearning_notification_LOCATOR.input_tem_text_id))
                    .sendKeys(nxELearningNotificationUtils.TEXT.tem_text);

            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.title_drpdwn_xpth);
            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.time_drpdwn_xpth);

            // link type
            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.link_type_drpdwn_xpth);

            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();
            // ---------------------------------------Display---------------------------------
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-215)", "");
            driver.findElement(By.id(edit_elearning_notification_LOCATOR.show_default_img_id)).click();
            driver.findElement(By.xpath(edit_elearning_notification_LOCATOR.choose_img_xpth)).click();

            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.img_drpdwn_xpth);

            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.showon_dropdown_xpth);
            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.displayfor_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // ---------------------------------------Customize---------------------------------
            // Appearance
            js.executeScript("window.scrollBy(0,-358)", "");
            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.enable_sound_xpth);
            Thread.sleep(1000);

            Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.postion_dropdown_xpth);

            driver.findElement(By.id(Config.EDITUTILS.noti_size_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.noti_size_id)).sendKeys(Config.EDITUTILS.noti_size_text);
            Config.double_click_id(driver, Config.EDITUTILS.display_close_btn_id);
            Config.double_click_id(driver, Config.EDITUTILS.mbl_visibility_id);
            // Queue Management
            Config.double_click_id(driver, Config.EDITUTILS.enable_glb_queue_id);

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

//			Config.double_click_xpth(driver, edit_elearning_notification_LOCATOR.sound_drpdwn_xpth);

            driver.findElement(By.xpath(EDITUTILS.published_button_xpath)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
