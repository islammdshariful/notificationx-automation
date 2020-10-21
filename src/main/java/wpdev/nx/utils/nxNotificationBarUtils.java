package wpdev.nx.utils;

public class nxNotificationBarUtils {
	public static class CountDown_TEXT {
		//EDIT
		public static final String add_title = "Noticifation bar countdown";
		public static final String add_content = "Testing notification bar";
		//PREVIEW
		public static final String notification_content = "Testing notification bar";
		public static final String notification_button_text = "Click Here";
	
		public static final String countdown_text = "Get it now before it gets sold";
		public static final String expired_text = "Ends In";
		public static final String button_url_text = "https://translate.google.com/";
		public static final String button_url_page_title_text = "Google Translate";
		
		public static final String notification_initial_delay_text = "1";
		
		public static final String start_date_text = "Tue, Oct 21, 2020 12:00 PM";
		public static final String end_date_text = "Tue, Oct 29, 2020 12:00 PM";
	}
	public static class Edit_NotificationX_bar{
		//NOTIFICATION EDIT MODE
		public static final String notificationX_xpath = "//*[@id=\"toplevel_page_nx-admin\"]/a/div[3]";
		public static final String notification_logo_xpath = "//*[@id=\"wpbody-content\"]/div[6]/div[1]/div[1]/div/img";
		
		//ADD NEW 
		public static final String add_new_class = "nx-add-new-btn";
		public static final String add_title_id = "title";
		public static final String select_notification_bar_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[7]/label";
		public static final String next_button_class = "nx-meta-next";
		public static final String next_design_button_xpath = "//*[@id=\"nx-design_tab\"]/button";
		public static final String next_contect_button_xpath = "//*[@id=\"nx-content_tab\"]/button";
		public static final String next_display_button_xpath = "//*[@id=\"nx-display_tab\"]/button";
		public static final String published_button_xpath = "//*[@id=\"nx-customize_tab\"]/button";
		
	}
	public static class CountDown_Locator {
				
		//EDIT MODE
		public static final String select_countdown_xpath = "//*[@id=\"nx-meta-bar_theme\"]/td/div[1]/div/div/div[3]/label";
//		public static final String content_type_id = "tinymce";
		public static final String content_type_xpath = "//*[@id=\"tinymce\"]/p";
//		public static final String contect_text_click_id = "nx_meta_press_content-html";
//		public static final String content_textarea_xpath = "//*[@id=\"nx_meta_press_content\"]";
		public static final String button_text_id = "nx_meta_button_text";
		public static final String button_url_id = "nx_meta_button_url";
		
		//ENABLE COUNTDOWN
		public static final String enable_countdown_id = "nx_meta_enable_countdown";
		public static final String countdown_text_id = "nx_meta_countdown_text";
		public static final String expired_text_id = "nx_meta_countdown_expired_text";
		public static final String start_date_field_id = "nx_meta_countdown_start_date";
		public static final String start_choose_date_xpath = "/html/body/div[8]/div[2]/div/div[2]/div/span[24]";
		public static final String end_date_field_id = "nx_meta_countdown_end_date";
		public static final String end_choose_date_xpath = "/html/body/div[9]/div[2]/div/div[2]/div/span[35]";
		
		public static final String show_on_id = "select2-nx_meta_show_on-container";
				
		//NOTIFICATION BAR COUNTDOWN PREVIEW
		public static final String notification_countdown_text_xpath = "//*[@id=\"nx-bar-4650\"]/div/div/div[1]/div[1]";
		
		public static final String notification_content_xpath = "//*[@id=\"nx-bar-4650\"]/div/div/div[2]/div";
		public static final String notification_button_xpath = "//*[@id=\"nx-bar-4638\"]/div/div/div[2]/a";
		
		public static final String notification_close_class = "nx-close";
		public static final String notification_countdown_day_xpath = "//*[@id=\"nx-bar-4638\"]/div/div/div[1]/div[2]/div[1]";
		public static final String notification_countdown_hour_xpath = "//*[@id=\"nx-bar-4638\"]/div/div/div[1]/div[2]/div[2]";
		public static final String notification_countdown_min_xpath = "//*[@id=\"nx-bar-4638\"]/div/div/div[1]/div[2]/div[3]";
		public static final String notification_countdown_sec_xpath = "//*[@id=\"nx-bar-4638\"]/div/div/div[1]/div[2]/div[4]";
	
		public static final String notification_initial_delay_id = "nx_meta_initial_delay";
		
	}
}
