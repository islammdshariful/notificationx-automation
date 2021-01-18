package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import utils.Config;
import utils.WordpressLogin;
import utils.nxNotificationBarUtils;
import utils.nxNotificationBarUtils.CountDown_TEXT;

public class NxNotificationBar {
    public static void testCaseforNotificationBar(WebDriver driver, String url, int theme) {
        createNotificationBar(driver, url, theme);
        nxBar(driver, theme);
        Config.delete_notification(driver, 3);
    }

    public static void createNotificationBar(WebDriver driver, String edit_url, int theme) {
        try {
            driver.get(edit_url);
            // LOGIN
            WordpressLogin.login(driver);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,827)", "");

            // SELECT NOTIFICATION BAR
            driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();

            driver.findElement(By.className(Config.EDITUTILS.add_new_class)).click();
            driver.findElement(By.id(Config.EDITUTILS.add_title_id)).sendKeys(CountDown_TEXT.add_title);
            driver.findElement(By.xpath(Config.EDITUTILS.select_notification_bar_xpath)).click();

            // NEXT
            driver.findElement(By.className(Config.EDITUTILS.next_button_class)).click();

            // SELECT COUNTDOWN THEME
            if (theme == 1) {
                driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            } else if (theme == 2) {
                driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.select_countdown_2_xpath)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            } else {
                driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.select_countdown_3_xpath)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(Config.EDITUTILS.next_design_button_xpath)).click();
            }

            // CONTENT
            driver.switchTo().frame("nx_meta_press_content_ifr");
            driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.content_type_xpath)).click();
            driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.content_type_xpath))
                    .sendKeys(nxNotificationBarUtils.CountDown_TEXT.add_content);
            driver.switchTo().parentFrame();
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.button_text_id))
                    .sendKeys(nxNotificationBarUtils.CountDown_TEXT.notification_button_text);
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.button_url_id))
                    .sendKeys(nxNotificationBarUtils.CountDown_TEXT.button_url_text);

            // ENABLE COUNTDOWN
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.enable_countdown_id)).click();
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.countdown_text_id))
                    .sendKeys(nxNotificationBarUtils.CountDown_TEXT.countdown_text);

            // expiry date
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.start_date_field_id)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.start_choose_date_xpath)).click();

//			driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.countdown_text_id)).click();

            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.end_date_field_id)).click();
            Thread.sleep(1000);
            Actions cursor = new Actions(driver);

            WebElement arrow = driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.arrow_next_xpath));
            cursor.moveToElement(arrow).click().build().perform();
//			driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.arrow_next_xpath)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.end_choose_date_xpath)).click();

            // NEXT
            driver.findElement(By.xpath(Config.EDITUTILS.next_content_button_xpath)).click();

            // NEXT
            driver.findElement(By.xpath(Config.EDITUTILS.next_display_button_xpath)).click();

            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id)).clear();
            Thread.sleep(1000);
            driver.findElement(By.id(nxNotificationBarUtils.CountDown_Locator.notification_initial_delay_id))
                    .sendKeys(nxNotificationBarUtils.CountDown_TEXT.notification_initial_delay_text);

            driver.findElement(By.id(Config.EDITUTILS.enable_open_new_tab_id)).click();
            // PUBLISHED
            driver.findElement(By.xpath(Config.EDITUTILS.published_button_xpath)).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void nxBar(WebDriver driver, int theme) {
        driver.get(Config.URLS.demosite_url);
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);

            softAssert.assertEquals(driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_text_xpath))
                    .getText(), nxNotificationBarUtils.CountDown_TEXT.countdown_text);

            System.out.println("Countdown text is VISIBLE");
            softAssert.assertEquals(
                    driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_content_xpath))
                            .getText(),
                    nxNotificationBarUtils.CountDown_TEXT.notification_content);

            WebElement day = driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_day_xpath));
            WebElement hour = driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_hour_xpath));
            WebElement min = driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_min_xpath));
            WebElement sec = driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath));

            String sec_time = sec.getText();

            String second = driver
                    .findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath))
                    .getText();

            Thread.sleep(1000);
            if (day.isDisplayed() && hour.isDisplayed() && min.isDisplayed() && sec.isDisplayed()) {

                if (sec_time != driver
                        .findElement(
                                By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath))
                        .getText()) {
                    System.out.println("Countdown timer Passed !!");
                } else {
                    System.out.println("Countdown timer Failed !!");
                }
                if (theme == 3) {
                    softAssert.assertEquals(driver
                            .findElement(By.xpath(
                                    nxNotificationBarUtils.CountDown_Locator.notification_countdown_day_text_xpath))
                            .getText(), nxNotificationBarUtils.CountDown_TEXT.notification_countdown_day_text);
                    softAssert.assertEquals(driver
                            .findElement(By.xpath(
                                    nxNotificationBarUtils.CountDown_Locator.notification_countdown_hour_text_xpath))
                            .getText(), nxNotificationBarUtils.CountDown_TEXT.notification_countdown_hour_text);
                    softAssert.assertEquals(driver
                            .findElement(By.xpath(
                                    nxNotificationBarUtils.CountDown_Locator.notification_countdown_min_text_xpath))
                            .getText(), nxNotificationBarUtils.CountDown_TEXT.notification_countdown_min_text);
                    softAssert.assertEquals(driver
                            .findElement(By.xpath(
                                    nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_text_xpath))
                            .getText(), nxNotificationBarUtils.CountDown_TEXT.notification_countdown_sec_text);

                }

                String new_second = driver
                        .findElement(
                                By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_countdown_sec_xpath))
                        .getText();

                if (second != new_second) {
                    System.out.println("Notification countdown is working");
                } else {
                    System.out.println("Notification countdown is NOT working");
                }

            }

            Thread.sleep(1000);
            softAssert.assertEquals(
                    driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_xpath))
                            .getText(),
                    nxNotificationBarUtils.CountDown_TEXT.notification_button_text);

            if (theme == 1) {
                driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_1_xpath))
                        .click();
            } else {
                driver.findElement(By.xpath(nxNotificationBarUtils.CountDown_Locator.notification_button_xpath))
                        .click();
            }

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            softAssert.assertEquals(driver.getTitle(),
                    nxNotificationBarUtils.CountDown_TEXT.button_url_page_title_text);
            driver.close();
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(1000);

            if (theme == 0) {
                driver.findElement(By.xpath("/html/body/div[3]/div/p")).click();
            } else {
                driver.findElement(By.className(nxNotificationBarUtils.CountDown_Locator.notification_close_class))
                        .click();
            }

            Thread.sleep(1000);
            softAssert.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

