package wpdev.nx.utils;

public class Config {
	public static class URLS {
		public static final String demosite_url = "http://devmode.local/";
		public static final String login_url = "http://devmode.local/wp-login.php";
	}
	
	public static class UTILS{
		public static final String wordpress_home_xpath = "//*[@id=\"menu-dashboard\"]/ul/li[2]/a";
	}
		
	public static class LOGIN {
		public static final String username = "sabiro";
		public static final String password = "12345";
		
		public static final String username_field_id = "user_login";
		public static final String password_field_id = "user_pass";
		public static final String login_button_id = "wp-submit";
	}
}
