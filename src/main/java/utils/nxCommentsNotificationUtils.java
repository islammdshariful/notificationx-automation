package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class nxCommentsNotificationUtils {
    public static class TEXT {
        public static final String add_title = "Comments Notification";

        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solutio";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        public static final String comment_name_text = "Mr. S commented on";
        public static final Date date = new Date();
        public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        public static final String comment_text = "A good article " + sdf.format(date);

        public static final String post_name_text = "NotificationX – Comment";

        public static final String notificaion_size = "450";

        public static final String post_link = "http://nx.com/notificationx-comment/";
    }

    public static class edit_comment_notification_LOCATOR {
        // EDIT MODE
        public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-comments_source\"]/td/div/div/div/div/label";
        public static final String choose_theme_xpath = "//*[@id=\"nx-meta-comment_theme\"]/td/div/div/div/div[4]/label/img";
        // -----------------------------------------Content-----------------------------------------
        // Content
        public static final String name_dropdown_xpth = "//*[@id=\"nx_meta_comments_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String post_dropdown_xpth = "//*[@id=\"nx_meta_comments_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String time_dropdown_xpth = "//*[@id=\"nx_meta_comments_template_new\"]/div/span[3]/span[1]/span/span[2]";

        // Link option
        public static final String linktype_dropdown_xpth = "//*[@id=\"nx-meta-comments_url\"]/td/div/span/span[1]/span/span[2]";

        // -----------------------------------------Display-----------------------------------------
        // image
        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String choose_dft_img_xpth = "//*[@id=\"nx-meta-default_avatar\"]/td/div/div/div/div[5]/label/img";
        public static final String show_gravatar_id = "nx_meta_show_avatar";

        // Visibility
        public static final String showon_dropdown_xpth = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String displayfor_dropdown_xpth = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // -----------------------------------------Customize-----------------------------------------
        public static final String ennablesound_xpth = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        // Appearance
        public static final String position_dropdown_xpth = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String input_position_xpth = "/html/body/span/span/span[1]/input";
        public static final String noti_size_xpth = "nx_meta_conversion_size";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visibility_id = "nx_meta_hide_on_mobile";

        // QUEUE MANAGEMENT
        public static final String enable_global_que_id = "nx_meta_global_queue_active";

        // Timing
        public static final String delay_before_id = "nx_meta_delay_before";
        public static final String display_for_id = "nx_meta_display_for";
        public static final String display_from_id = "nx_meta_display_from";

        // Behavior
        public static final String loop_noti_id = "nx_meta_loop";
        public static final String enable_open_new_tab_id = "nx_meta_link_open";

        // Sound settings
        public static final String select_sound_dropdown_xpth = "//*[@id=\"nx-meta-comments_sound\"]/td/div/span[1]/span[1]/span/span[2]";

    }

    public static class preview_comment_notification_LOCATOR {
        // PREVIEW MODE
        public static final String comment_image_xpath = "/html/body/div[4]/div/div[1]/img";
        public static final String comment_name_xpath = "/html/body/div[4]/div/div[2]/div[1]";
        public static final String comment_content_xpath = "/html/body/div[4]/div/div[2]/div[2]/span";
        public static final String notification_close_button_xpath = "/html/body/div[4]/div/span";
        public static final String comment_link_xpath = "/html/body/div[4]/a";
        public static final String time_xpth = "/html/body/div[4]/div/div[2]/div[3]/div/span/small";
        public static final String notificationX_link = "/html/body/div[4]/div/div[2]/div[3]/small";

        public static final String post_page_title_xpath = "/html/body/div[2]/div/div/div/main/article/div/header/div/h1";
    }
}
