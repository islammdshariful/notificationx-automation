package utils;

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

        public static final String notification_countdown_day_text = "Days";
        public static final String notification_countdown_hour_text = "Hrs";
        public static final String notification_countdown_min_text = "Mins";
        public static final String notification_countdown_sec_text = "Secs";
    }

    public static class CountDown_Locator {

        //----------------EDIT MODE---------------------
        // CONTENT

        public static final String select_countdown_1_xpath = "//*[@id=\"nx-meta-bar_theme\"]/td/div[1]/div/div/div[1]/label";
        public static final String select_countdown_2_xpath = "//*[@id=\"nx-meta-bar_theme\"]/td/div[1]/div/div/div[2]/label";
        public static final String select_countdown_3_xpath = "//*[@id=\"nx-meta-bar_theme\"]/td/div[1]/div/div/div[3]/label";

        public static final String content_type_xpath = "//*[@id=\"tinymce\"]/p";
        public static final String button_text_id = "nx_meta_button_text";
        public static final String button_url_id = "nx_meta_button_url";

        //COUNTDOWN TIMER
        public static final String enable_countdown_id = "nx_meta_enable_countdown";
        public static final String countdown_text_id = "nx_meta_countdown_text";
        public static final String expired_text_id = "nx_meta_countdown_expired_text";
        public static final String start_date_field_id = "nx_meta_countdown_start_date";
        public static final String start_choose_date_xpath = "/html/body/div[10]/div[2]/div/div[2]/div/span[18]";
        public static final String arrow_next_xpath = "/html/body/div[11]/div[1]/span[2]";
        public static final String end_date_field_id = "nx_meta_countdown_end_date";
        public static final String end_choose_date_xpath = "/html/body/div[11]/div[2]/div/div[2]/div/span[18]";
        public static final String permanent_close_id = "nx_meta_close_forever";

        // TIMING
        public static final String initial_delay_id = "nx_meta_initial_delay";
        public static final String open_link_in_new_tab_id = "nx_meta_link_open";


        //NOTIFICATION BAR COUNTDOWN PREVIEW
        public static final String notification_countdown_text_xpath = "/html/body/div[1]/div/div/div[1]/div[1]";

        public static final String notification_content_xpath = "/html/body/div[1]/div/div/div[2]/div";
        public static final String notification_button_xpath = "/html/body/div[1]/div/div/div[2]/a";
        public static final String notification_button_1_xpath = "/html/body/div[1]/div/div/div[2]/a";

        public static final String notification_close_class = "nx-close";
        public static final String notification_countdown_day_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/span[1]";
        public static final String notification_countdown_hour_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[2]/span[1]";
        public static final String notification_countdown_min_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[3]/span[1]";
        public static final String notification_countdown_sec_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[4]/span[1]";

        public static final String notification_countdown_day_text_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/span[2]";
        public static final String notification_countdown_hour_text_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[2]/span[2]";
        public static final String notification_countdown_min_text_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[3]/span[2]";
        public static final String notification_countdown_sec_text_xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[4]/span[2]";

        public static final String notification_initial_delay_id = "nx_meta_initial_delay";

    }
}
