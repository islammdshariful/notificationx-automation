package wpdev.nx.utils;

public class nxCommentsNotificationUtils {
	public static class TEXT {
		public static final String add_title = "Comments Notification";
		
		public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";
		
		public static final String delay_before_text = "1";
		public static final String display_for_text = "30";
		public static final String display_from_text = "10";
		
		public static final String comment_name_text = "Mr s commented on";
		public static final String comment_text = "A usefull feature indeed";
		
		public static final String post_name_text = "CommentsNotificationX";
	}
	
	public static class LOCATOR{
		//EDIT MODE
		public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-comments_source\"]/td/div/div/div/div/label";
		public static final String choose_theme_xpath = "//*[@id=\"nx-meta-comment_theme\"]/td/div/div/div/div[4]/label/img";
		
		
		//PREVIEW MODE
		public static final String comment_image_xpath = "/html/body/div[9]/div/div[1]/img";		
		public static final String comment_name_xpath = "/html/body/div[9]/div/div[2]/div[1]";
		public static final String comment_content_xpath = "/html/body/div[9]/div/div[2]/div[2]/span";
		public static final String notification_close_button_xpath = "/html/body/div[9]/div/span";
		public static final String comment_link_xpath = "/html/body/div[9]/a";
		public static final String notificationX_link = "/html/body/div[9]/div/div[2]/div[3]/small/a";
		
		public static final String post_page_title_xpath = "/html/body/div[2]/div/div/div/main/article/div/header/div/h1";
		
	}
}
