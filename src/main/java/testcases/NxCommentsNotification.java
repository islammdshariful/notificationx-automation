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
import utils.nxCommentsNotificationUtils;
import utils.nxSalesNotificationUtils;

public class NxCommentsNotification {
    public static void testCaseforCommnetNotification(WebDriver driver, String url) {
        createCommentsNotification(driver, url);
        doComments(driver, nxCommentsNotificationUtils.TEXT.post_link);
        commentNotification(driver);
        Config.delete_notification(driver, 1); //if re-generate option is available put 1 else 0
    }

    public static void doComments(WebDriver driver, String url) {
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,530)", "");

        driver.findElement(By.id("comment")).sendKeys(nxCommentsNotificationUtils.TEXT.comment_text);
        driver.findElement(By.id("submit")).click();
    }

    public static void commentNotification(WebDriver driver) {
        driver.get("http://nx.com/");

        SoftAssert softassert = new SoftAssert();
        try {
            Thread.sleep(2000);

            WebElement image = driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.comment_image_xpath));
            if (image.isDisplayed()) {
                System.out.println("Notification avatar is Visible");
            } else {
                System.out.println("Notification avatar is NOT Visible");
            }

            softassert.assertEquals(driver
                    .findElement(By
                            .xpath(nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.comment_name_xpath))
                    .getText(), nxCommentsNotificationUtils.TEXT.comment_name_text, "COMMENTER NAME TEXT IS FAILED");

            softassert.assertEquals(driver
                    .findElement(By.xpath(
                            nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.comment_content_xpath))
                    .getText(), nxCommentsNotificationUtils.TEXT.comment_text, "COMMENT CONTENT TEXT IS FAILED");

//			Thread.sleep(2000);
//			WebElement link = driver.findElement(By.xpath(nxCommentsNotificationUtils.LOCATOR.comment_content_xpath));
//			Actions cursor = new Actions(driver);
//			cursor.moveToElement(link).click().build().perform();

            Thread.sleep(1000);
            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.comment_link_xpath))
                    .click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            softassert.assertEquals(driver
                    .findElement(By.xpath(
                            nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.post_page_title_xpath))
                    .getText(), nxCommentsNotificationUtils.TEXT.post_name_text, "POST TITLE IS FAILED");
            driver.close();
            driver.switchTo().window(tabs.get(0));

//			----------------------------------- NotificationX Link -----------------------------------
//			driver.findElement(
//					By.xpath(nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.notificationX_link))
//					.click();
//
//			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs2.get(1));
//
//			softassert.assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution", "NOTIFCATION LINK IS FAILED");
//			driver.close();
//			driver.switchTo().window(tabs2.get(0));

            Thread.sleep(2000);
            driver.findElement(By.xpath(
                    nxCommentsNotificationUtils.preview_comment_notification_LOCATOR.notification_close_button_xpath))
                    .click();
            Thread.sleep(2000);
            softassert.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createCommentsNotification(WebDriver driver, String edit_url) {
        try {
            driver.get(edit_url);

            // LOGIN
            WordpressLogin.login(driver);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,827)", "");

            // NAVIGATE TO NOTIFICATIONX
            driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();

            // NAME THE NOTIFICATIONX
            driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
            driver.findElement(By.id(Config.EDITUTILS.add_title_id))
                    .sendKeys(nxCommentsNotificationUtils.TEXT.add_title);

            // -----------------------------------------Source------------------------------------
            // SELETECT COMMENT NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_comments_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.select_woocommerce_xpath))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();

            // -----------------------------------------Design------------------------------------
            // CHOOSE THEME
            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.choose_theme_xpath)).click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();

            // -----------------------------------------Content------------------------------------
            // Content
            js.executeScript("window.scrollBy(0,-490)", "");
            Thread.sleep(1000);
            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.name_dropdown_xpth);

            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.post_dropdown_xpth);

            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.time_dropdown_xpth);

            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.linktype_dropdown_xpth);

            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

            // -----------------------------------------Display------------------------------------
            // Image
            js.executeScript("window.scrollBy(0,-174)", "");
            driver.findElement(By.id(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.show_default_img_id)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.choose_dft_img_xpth)).click();
//			Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.show_default_img_id);

            driver.findElement(By.id(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.show_gravatar_id)).click();
//			Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.show_gravatar_id);

            // visibility
            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.showon_dropdown_xpth);

            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.displayfor_dropdown_xpth);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // -----------------------------------------Customize------------------------------------

            // ENABLE SOUND
            js.executeScript("window.scrollBy(0,-490)", "");
            Thread.sleep(1000);
            // clicking on enable sound

            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.ennablesound_xpth)).click();
            Thread.sleep(1000);
            // Sound setting
            Config.double_click_xpth(driver,
                    nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.select_sound_dropdown_xpth);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-1300)", "");
            Thread.sleep(2000);

            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.ennablesound_xpth)).click();

//			Config.double_click_xpth(driver,
//					nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.position_dropdown_xpth);

            // SET POSITION
            Thread.sleep(1000);
            driver.findElement(By.xpath(Config.EDITUTILS.position_dropdown_xpath)).click();
            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.input_position_xpth))
                    .sendKeys("Right");
            driver.findElement(
                    By.xpath(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.input_position_xpth))
                    .sendKeys(Keys.ENTER);


            // Clicking on notification size
            driver.findElement(By.id(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.noti_size_xpth))
                    .clear();
            driver.findElement(By.id(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.noti_size_xpth))
                    .sendKeys(nxCommentsNotificationUtils.TEXT.notificaion_size);

            // clicking on display close button
            Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.display_close_btn_id);
            // clicking on mobile visibility
            Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.mbl_visibility_id);

            // queue management
            // clicking on global queue
            Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.enable_global_que_id);

            // timing

            // SET TIME
            // DELAY BEFORE FIRST NOTIFICATION
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id))
                    .sendKeys(nxCommentsNotificationUtils.TEXT.delay_before_text);
            // DISPLAY FOR
            driver.findElement(By.id(Config.EDITUTILS.display_for_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_for_id))
                    .sendKeys(nxCommentsNotificationUtils.TEXT.display_for_text);
            // Behavior
            // DISPLAY FROM
            driver.findElement(By.id(Config.EDITUTILS.display_from_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_from_id))
                    .sendKeys(nxCommentsNotificationUtils.TEXT.display_from_text);

            // Loop notification
            Config.double_click_id(driver, nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.loop_noti_id);

            // clicking on enable open in new tab
            driver.findElement(
                    By.id(nxCommentsNotificationUtils.edit_comment_notification_LOCATOR.enable_open_new_tab_id))
                    .click();

            // PUBLISHED PAGE
            driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
