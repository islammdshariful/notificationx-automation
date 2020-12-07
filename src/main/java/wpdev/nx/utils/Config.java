package wpdev.nx.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Config {

	public static void delete_notification(WebDriver driver) {
		try {
			driver.get("http://nx.com/wp-admin/");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,593)", "");

			// SELECT NOTIFICATION BAR
			driver.findElement(By.xpath(Config.EDITUTILS.notificationX_xpath)).click();
			js.executeScript("window.scrollBy(0,569)", "");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Config.DELETE.notification_delete_xpath)).click();
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
//		public static final String notification_delete_xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[8]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[5]";
		public static final String notification_delete_xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/div[5]/table/tbody/tr[1]/td[1]/div/div/a[5]";
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
