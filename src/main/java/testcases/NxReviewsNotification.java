package testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Config;
import utils.WordpressLogin;
import utils.nxReviewsNotificationUtils;
import utils.nxReviewsNotificationUtils.edit_review_notification_LOCATOR;


public class NxReviewsNotification {
    public static void testCaseforReviewNotification(WebDriver driver, String url) {
        createReviewsNotification(driver, url);
        String p_name = doReview(driver);
        reviewNotification(driver, p_name);
        Config.delete_notification(driver, 1);
    }

    public static void reviewNotification(WebDriver driver, String p_name) {
        driver.get(Config.URLS.demosite_url);
        System.out.println("Passit" + p_name);
        try {
            Thread.sleep(2000);

            WebElement image = driver.findElement(
                    By.xpath(nxReviewsNotificationUtils.preview_review_notification_LOCATOR.review_image_xpath));
            if (image.isDisplayed()) {
                System.out.println("Notification avatar is Visible");
            }
            assertEquals(driver
                    .findElement(
                            By.xpath(nxReviewsNotificationUtils.preview_review_notification_LOCATOR.review_name_xpath))
                    .getText(), nxReviewsNotificationUtils.TEXT.comment_name_text);
            System.out.println("Avatar name passed !!");
            System.out.println("try" + p_name);
            assertEquals(driver
                    .findElement(By.xpath(
                            nxReviewsNotificationUtils.preview_review_notification_LOCATOR.review_product_name_xpath))
                    .getText(), p_name);
            System.out.println("Review Product passed !!");
            Thread.sleep(2000);

            // PRODUCT REVIEW LINK
            driver.findElement(
                    By.xpath(nxReviewsNotificationUtils.preview_review_notification_LOCATOR.reviews_link_xpath))
                    .click();
            ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            assertEquals(driver
                    .findElement(By.xpath(nxReviewsNotificationUtils.review_product_LOCATOR.product_page_title_xpath))
                    .getText(), p_name);
            System.out.println("Review link passed !!");
            driver.close();
            driver.switchTo().window(tabs1.get(0));
            Thread.sleep(2000);

            // NOTIFICATIONX LINK
//			driver.findElement(
//					By.xpath(nxReviewsNotificationUtils.preview_review_notification_LOCATOR.notificationX_link))
//					.click();
//			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs2.get(1));
//			assertEquals(driver.getTitle(), "NotificationX - Best Social Proof & FOMO Marketing Solution");
//			System.out.println("NotificationX link passed !!");
//			driver.close();
//			driver.switchTo().window(tabs2.get(0));

            driver.findElement(By.xpath(
                    nxReviewsNotificationUtils.preview_review_notification_LOCATOR.notification_close_button_xpath))
                    .click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String doReview(WebDriver driver) {
        driver.findElement(By.xpath(nxReviewsNotificationUtils.review_product_LOCATOR.product_option_menu_xpath))
                .click();
        WebElement product = driver
                .findElement(By.xpath(nxReviewsNotificationUtils.review_product_LOCATOR.product_xpath));
        String product_name = product.getText();
        Actions cursor = new Actions(driver);
        WebElement view_product = driver
                .findElement(By.xpath(nxReviewsNotificationUtils.review_product_LOCATOR.view_product));

        cursor.moveToElement(product).moveToElement(view_product).click().build().perform();
//		driver.findElement(By.xpath(review_product_LOCATOR.product_edit_xpath)).click();
//		System.out.println(product_name);
//		driver.findElement(By.id(review_product_LOCATOR.product_link_id)).click();

        driver.findElement(By.id("tab-title-reviews")).click();
        driver.findElement(By.id("comment")).sendKeys(nxReviewsNotificationUtils.TEXT.review_text);
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[5]")).click();
        driver.findElement(By.id("submit")).click();
        return product_name;
    }

    public static void createReviewsNotification(WebDriver driver, String edit_url) {
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
                    .sendKeys(nxReviewsNotificationUtils.TEXT.add_title);

            // SELETECT REVIEWS NOTIFICATION
            driver.findElement(By.xpath(Config.EDITUTILS.select_reviews_notification_xpath)).click();
            driver.findElement(
                    By.xpath(nxReviewsNotificationUtils.edit_review_notification_LOCATOR.select_woocommerce_xpath))
                    .click();
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();
            // -----------------------------------Design----------------------------------
            // CHOOSE THEME
            js.executeScript("window.scrollBy(0,-405)", "");
            driver.findElement(By.xpath(nxReviewsNotificationUtils.edit_review_notification_LOCATOR.choose_theme_xpath))
                    .click();
            driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            // -----------------------------------Content---------------------------------
            // CONTENT
            js.executeScript("window.scrollBy(0,-623)", "");
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.template_dropdown_xpath);
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.productname_dropdown_xpath);
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.rating_dropdown_xpath);

            // Link option
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.linktype_dropdown_xpath);
            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

            // -----------------------------------Display---------------------------------
            // DISPLAY
            js.executeScript("window.scrollBy(0,-174)", "");
            Config.double_click_id(driver, edit_review_notification_LOCATOR.show_default_img_id);
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.img_dropdown_xpath);

            // Visibility
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.showon_dropdown_xpath);
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.displayfor_dropdown_xpath);
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            // -----------------------------------Customize---------------------------------
            // ENABLE SOUND
            js.executeScript("window.scrollBy(0,-490)", "");
//		Thread.sleep(1000);
            // clicking on enable sound

            driver.findElement(By.xpath(edit_review_notification_LOCATOR.enable_sound_xpth)).click();
            Thread.sleep(1000);
            // Sound setting
            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.select_sound_dropdown_xpth);
//		Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-1500)", "");
            Thread.sleep(2000);

            driver.findElement(By.xpath(edit_review_notification_LOCATOR.enable_sound_xpth)).click();
            Thread.sleep(2000);

            Config.double_click_xpth(driver, edit_review_notification_LOCATOR.position_drpdwn_xpth);
            Config.double_click_id(driver, edit_review_notification_LOCATOR.noti_size_id);
            Config.double_click_id(driver, edit_review_notification_LOCATOR.display_close_btn_id);
            Config.double_click_id(driver, edit_review_notification_LOCATOR.mbl_visible_id);
            // Queue management
            Config.double_click_id(driver, edit_review_notification_LOCATOR.active_glb_queue_id);

            // timing
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.delay_before_id))
                    .sendKeys(nxReviewsNotificationUtils.TEXT.delay_before_text);
            driver.findElement(By.id(Config.EDITUTILS.display_for_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_for_id))
                    .sendKeys(nxReviewsNotificationUtils.TEXT.display_for_text);
            // Behavior
            driver.findElement(By.id(Config.EDITUTILS.display_from_id)).clear();
            driver.findElement(By.id(Config.EDITUTILS.display_from_id))
                    .sendKeys(nxReviewsNotificationUtils.TEXT.display_from_text);
            driver.findElement(By.id(Config.EDITUTILS.enable_open_new_tab_id)).click();
            driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
