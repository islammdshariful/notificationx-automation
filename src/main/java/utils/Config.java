package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Config {
    public static String create_subs(WebDriver driver) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String name = "subs" + sdf.format(date);
        String username = name.replace(":", "");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)", "");

        // users
        driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[2]")).click();

        // add new
        driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/a")).click();

        // user info
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(username + "@dev.com");
        driver.findElement(By.id("first_name")).sendKeys(username.toUpperCase());
        driver.findElement(By.id("last_name")).sendKeys("USER");
        driver.findElement(By.id("pass1")).clear();
        driver.findElement(By.id("pass1")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"createuser\"]/table/tbody/tr[8]/td/label/input")).click();
        Select role = new Select(driver.findElement(By.id("role")));
        role.selectByVisibleText("Subscriber");
        driver.findElement(By.id("createusersub")).click();

        return username;
    }

    public static void logout(WebDriver driver) {
        Actions cursor = new Actions(driver);
        WebElement admin_bar_account = driver.findElement(By.id("wp-admin-bar-my-account"));
        WebElement admin_bar_menu_logout = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
        cursor.moveToElement(admin_bar_account).moveToElement(admin_bar_menu_logout).click().build().perform();
    }

    public static void delete_notification(WebDriver driver, int reg) {
        try {
            driver.get("http://nx.com/wp-admin/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,593)", "");

            // SELECT NOTIFICATION BAR
            driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();
            js.executeScript("window.scrollBy(0,59)", "");
            Thread.sleep(1000);
            if (reg == 1) {
                driver.findElement(By.xpath(Config.DELETE.notification_delete_xpath_w_reg)).click();
            } else if (reg == 3) {
                driver.findElement(By.xpath(Config.DELETE.notification_bar_delete_xpth)).click();
            } else {
                driver.findElement(By.xpath(Config.DELETE.notification_delete_xpath_wo_reg)).click();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void double_click_xpth(WebDriver driver, String xpth) {
        try {
            driver.findElement(By.xpath(xpth)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(xpth)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void double_click_id(WebDriver driver, String id) {
        try {
            driver.findElement(By.id(id)).click();
            Thread.sleep(1000);
            driver.findElement(By.id(id)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class URLS {
        public static final String demosite_url = "http://nx.com/";
        public static final String login_url = "http://nx.com/wp-login.php";
    }

    public static class UTILS {
        public static final String wordpress_home_xpath = "//*[@id=\"menu-dashboard\"]/ul/li[2]/a";
    }

    public static class LOGIN {
        public static final String username = "sabiro";
        public static final String password = "1234";

        public static final String username_field_id = "user_login";
        public static final String password_field_id = "user_pass";
        public static final String login_button_id = "wp-submit";
    }

    public static class DELETE {
        public static final String notification_delete_xpath_w_reg = "//*[@id=\"wpbody-content\"]/div[4]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[5]";
        //		public static final String notification_delete_xpath_wo_reg = "//*[@id=\"wpbody-content\"]/div[6]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[4]";
        public static final String notification_delete_xpath_wo_reg = "//*[@id=\"wpbody-content\"]/div[4]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[4]";
        public static final String notification_bar_delete_xpth = "//*[@id=\"wpbody-content\"]/div[4]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[4]";
    }

    public static class EDITUTILS {
        // NAVIGATE TO NOTIFICATIONX
        public static final String notificationX_xpath = "//*[@id=\"toplevel_page_nx-admin\"]/a/div[3]";
        public static final String notification_logo_xpath = "//*[@id=\"wpbody-content\"]/div[6]/div[1]/div[1]/div/img";

        // ADD NEW
        public static final String add_new_class = "nx-add-new-btn";
        public static final String add_title_id = "title";

        public static final String next_button_class = "nx-meta-next";
        public static final String next_design_button_xpath = "//*[@id=\"nx-design_tab\"]/button";
        public static final String next_content_button_xpath = "//*[@id=\"nx-content_tab\"]/button";
        public static final String next_display_button_xpath = "//*[@id=\"nx-display_tab\"]/button";
        public static final String published_button_xpath = "//*[@id=\"nx-customize_tab\"]/button";

        // NOTIFICATION POSITIONS
        public static final String position_dropdown_xpath = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String position_type_xpath = "/html/body/span[2]/span/span[1]/input";
        public static final String position_left_xpath = "//*[@id=\"select2-nx_meta_conversion_position-result-a4ig-bottom_left\"]";
        public static final String position_right_id = "select2-nx_meta_conversion_position-result-6zp8-bottom_right";

        // DISPLAY
        public static final String delay_before_id = "nx_meta_delay_before";
        public static final String display_for_id = "nx_meta_display_for";
        public static final String display_from_id = "nx_meta_display_from";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        // Queue management
        public static final String enable_glb_queue_id = "nx_meta_global_queue_active";

        // Behavior
        public static final String loop_noti_id = "nx_meta_loop";
        public static final String open_in_new_tab_id = "nx_meta_link_open";

        public static final String noti_size_id = "nx_meta_conversion_size";
        public static final String noti_size_text = "450";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visibility_id = "nx_meta_hide_on_mobile";

        // OPEN IN A NEW TAB
        public static final String enable_open_new_tab_id = "nx_meta_link_open";

        // CHOOSE TYPE OF NOTIFICATION
        public static final String select_sales_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[1]/label";
        public static final String select_comments_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[2]/label";
        public static final String select_reviews_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[3]/label";
        public static final String select_downloadstats_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[4]/label";
        public static final String select_elearning_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[5]/label";
        public static final String select_donation_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[6]/label";
        public static final String select_notification_bar_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[7]/label";
        public static final String select_contactform_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[8]/label";
        public static final String select_emailsubs_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[9]/label";
        public static final String select_pageanalytics_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[10]/label";

        // ENABLE SOUND
        public static final String enable_sound_id = "nx_sound_checkbox";

    }
}
