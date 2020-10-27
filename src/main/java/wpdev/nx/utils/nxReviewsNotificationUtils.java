package wpdev.nx.utils;

public class nxReviewsNotificationUtils {
	public static class TEXT {
		public static final String add_title = "Reviews Notification";

		public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

		public static final String delay_before_text = "1";
		public static final String display_for_text = "40";
		public static final String display_from_text = "10";

		public static final String comment_name_text = "sabiro just reviewed";
		public static final String review_text = "A useful product";
	}

	public static class LOCATOR {
		// EDIT MODE
		public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-reviews_source\"]/td/div/div/div/div[2]/label";
		public static final String choose_theme_xpath = "//*[@id=\"nx-meta-wporg_theme\"]/td/div/div/div/div[2]/label/img";

		
		// PREVIEW MODE
		public static final String review_image_xpath = "/html/body/div[9]/div/div[1]/img";
		public static final String review_name_xpath = "/html/body/div[9]/div/div[2]/div[1]";
		public static final String review_product_name_xpath = "/html/body/div[9]/div/div[2]/div[2]/span";
		public static final String review_ratings_xpath = "/html/body/div[9]/div/div[2]/div[3]/div/span";
		public static final String notification_close_button_xpath = "/html/body/div[9]/div/span";
		public static final String reviews_link_xpath = "/html/body/div[9]/a";
		public static final String notificationX_link = "/html/body/div[9]/div/div[2]/div[3]/small/a";

		//PRODUCT DETAILS
		public static final String product_option_menu_xpath = "//*[@id=\"menu-posts-product\"]/a/div[3]";
		public static final String product_edit_xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/strong/a";
		public static final String product_name_id = "title";
		public static final String product_link_xpath = "//*[@id=\"sample-permalink\"]";
		public static final String product_page_title_xpath = "/html/body/div[2]/div/div/div/main/div/div[2]/div[2]/h1";

	}
}
