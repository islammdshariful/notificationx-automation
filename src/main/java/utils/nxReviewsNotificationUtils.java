package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class nxReviewsNotificationUtils {
    public static class TEXT {
        public static final String add_title = "Reviews Notification";

        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        public static final String comment_name_text = "sabiro just reviewed";

        public static final Date date = new Date();
        public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        public static final String review_text = "A usefull feature indeed " + sdf.format(date);


        public static final String noti_size_text = "450";
    }

    public static class edit_review_notification_LOCATOR {
        // EDIT MODE
        public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-reviews_source\"]/td/div/div/div/div[2]/label";
        public static final String choose_theme_xpath = "//*[@id=\"nx-meta-wporg_theme\"]/td/div/div/div/div[2]/label/img";
        // -----------------------------------Content-------------------------------
        public static final String template_dropdown_xpath = "//*[@id=\"nx_meta_wp_reviews_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String productname_dropdown_xpath = "//*[@id=\"nx_meta_wp_reviews_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String rating_dropdown_xpath = "//*[@id=\"nx_meta_wp_reviews_template_new\"]/div/span[3]/span[1]/span/span[2]";

        // Link option
        public static final String linktype_dropdown_xpath = "//*[@id=\"nx-meta-rs_url\"]/td/div/span/span[1]/span/span[2]";

        // -----------------------------------Display-------------------------------
        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String img_dropdown_xpath = "//*[@id=\"nx-meta-show_notification_image\"]/td/div/span/span[1]/span/span[2]";

        // Visibility
        public static final String showon_dropdown_xpath = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String displayfor_dropdown_xpath = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // -----------------------------------Customize-------------------------------
        public static final String enable_sound_xpth = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        // Appearance
        public static final String position_drpdwn_xpth = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String noti_size_id = "nx_meta_conversion_size";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visible_id = "nx_meta_hide_on_mobile";

        // Queue management
        public static final String active_glb_queue_id = "nx_meta_global_queue_active";

        // Sound settings
        public static final String select_sound_dropdown_xpth = "//*[@id=\"nx-meta-reviews_sound\"]/td/div/span[1]/span[1]/span/span[2]";
    }

    public static class preview_review_notification_LOCATOR {
        // PREVIEW MODE
        public static final String review_image_xpath = "/html/body/div[4]/div/div[1]/img";
        public static final String review_name_xpath = "/html/body/div[4]/div/div[2]/div[1]";
        public static final String review_product_name_xpath = "/html/body/div[4]/div/div[2]/div[2]/span";
        public static final String review_ratings_xpath = "/html/body/div[4]/div/div[2]/div[3]/div/span";
        public static final String notification_close_button_xpath = "/html/body/div[4]/div/span";
        public static final String reviews_link_xpath = "/html/body/div[4]/a";
        public static final String notificationX_link = "/html/body/div[4]/div/div[2]/div[3]/small/a";

    }

    public static class review_product_LOCATOR {

        // PRODUCT DETAILS
        public static final String product_option_menu_xpath = "//*[@id=\"menu-posts-product\"]/a/div[3]";
        public static final String product_xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/strong/a";
        public static final String product_name_id = "title";
        public static final String product_link_id = "sample-permalink";
        public static final String product_page_title_xpath = "/html/body/div[2]/div/div/div/main/div/div[2]/div[2]/h1";
        public static final String view_product = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/div[3]/span[5]/a";

    }
}
