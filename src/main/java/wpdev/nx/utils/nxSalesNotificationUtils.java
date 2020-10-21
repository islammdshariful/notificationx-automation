package wpdev.nx.utils;

public class nxSalesNotificationUtils {
	public static class Sales_TEXT {
		public static final String add_title = "Sales Notification";
		
		public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";
		
		public static final String delay_before_text = "1";
		public static final String display_for_text = "30";
		public static final String display_from_text = "10";
	}
	public static class Edit_NotificationX_Sales{
		//NOTIFICATION EDIT MODE
		public static final String notificationX_xpath = "//*[@id=\"toplevel_page_nx-admin\"]/a/div[3]";
		public static final String notification_logo_xpath = "//*[@id=\"wpbody-content\"]/div[6]/div[1]/div[1]/div/img";
		
		//ADD NEW 
		public static final String add_new_class = "nx-add-new-btn";
		public static final String add_title_id = "title";
				
		public static final String next_button_class = "nx-meta-next";
		public static final String next_design_button_xpath = "//*[@id=\"nx-design_tab\"]/button";
		public static final String next_content_button_xpath = "//*[@id=\"nx-content_tab\"]/button";
		public static final String next_display_button_xpath = "//*[@id=\"nx-display_tab\"]/button";
		public static final String published_button_xpath = "//*[@id=\"nx-customize_tab\"]/button";
		
	}
	
	public static class Buy_product {
		public static final String product_option_xpath = "//*[@id=\"menu-posts-product\"]/a/div[3]";
		public static final String click_product_xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/strong";
		
		public static final String product_link = "//*[@id=\"sample-permalink\"]/a";
		
		public static final String checkout_link = "http://devmode.local/checkout/";
		public static final String choose_cod_id = "payment_method_cod";
		public static final String place_order_id = "place_order";
		
	}
	
	public static class Sales_notification{
		//EDIT MODE
		public static final String select_sales_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[1]/label";
		public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-conversion_from\"]/td/div/div/div/div[1]/label";
		
		
		public static final String choose_theme_xpath = "//*[@id=\"nx-meta-theme\"]/td/div/div/div/div[2]/label";
		public static final String enable_sound_xpath = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
		
		public static final String delay_before_id = "nx_meta_delay_before";
		public static final String display_for_id = "nx_meta_display_for";
		public static final String display_from_id = "nx_meta_display_from";
		
		public static final String enable_open_new_tab_id = "nx_meta_link_open";
		
		public static final String notificationX_link_xpath = "//*[@id=\"notificationx-5f8ecb7ca2e13\"]/div/div[2]/div[3]/small/a";
		
		//PREVIEW MODE
		public static final String product_image_xpath = "//*[@id=\"notificationx-5f8ed2593ee5a\"]/div/div[1]/img";
		public static final String product_purchased_xpath = "//*[@id=\"notificationx-5f8ed2593ee5a\"]/div/div[2]/div[1]";
		public static final String product_name_xpath = "//*[@id=\"notificationx-5f8ed2da891e7\"]/div/div[2]/div[2]/span";
		public static final String product_notification_xpath = "/html/body/div[9]/a";
		public static final String notification_close_button_xpath = "/html/body/div[9]/div/span";
		public static final String notificationX_link = "//*[@id=\"notificationx-5f8ed36d0b177\"]/div/div[2]/div[3]/small/a";
		
	}
	
	
}
