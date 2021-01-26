package utils;

public class nxDownloadStatNotificationUtils {
    public static class TEXT {
        public static final String add_title = "Download Stat Notification";

        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        public static final String  name_text = "Essential Addons for Elementor";
        public static final String welcome_note_text = "Get Started for Free.";
        public static final String noti_size_text = "450";

        public static final String slug_name_text = "essential-addons-for-elementor-lite";
        public static final String 	position_text = "Bottom Right";
        public static final String plugin_page_title = "Essential Addons for Elementor – WordPress plugin | WordPress.org";
    }

    public static class edit_downstat_notification_LOCATOR {
        public static final String choose_wordpress_xpth = "//*[@id=\"nx-meta-stats_source\"]/td/div/div/div/div[1]/label";
        // ----------------------------design-----------------------
        public static final String choose_theme_xpth = "//*[@id=\"nx-meta-wpstats_theme\"]/td/div/div/div/div[2]/label";

        // ----------------------------design-----------------------
        public static final String product_type_dropdown_xpth = "//*[@id=\"nx-meta-wp_stats_product_type\"]/td/div/span/span[1]/span/span[2]";
        public static final String slug_id = "nx_meta_wp_stats_slug";

        public static final String name_dropdown_xpth = "//*[@id=\"nx_meta_wp_stats_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String days_dropdow_xpth = "//*[@id=\"nx_meta_wp_stats_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String from_days_dropdown_xpth = "//*[@id=\"nx_meta_wp_stats_template_new\"]/div/span[3]/span[1]/span/span[2]";

        // Link options
        public static final String linktype_dropdown_xpth = "//*[@id=\"nx-meta-rs_url\"]/td/div/span/span[1]/span/span[2]";
        // ---------------------------------Display---------------------------------
        // visibility
        public static final String showon_dropdown_xpth = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String displayfor_dropdown_xpth = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // ---------------------------------Customize------------------------------
        public static final String postion_dropdown_xpth = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String type_position_xpth = "/html/body/span/span/span[1]/input";
        public static final String noti_size_id = "nx_meta_conversion_size";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visibility_id = "nx_meta_hide_on_mobile";
        public static final String enable_sound_xpth = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        // Queue management
        public static final String enable_glb_queue_id = "nx_meta_global_queue_active";

        // Behavior
        public static final String loop_noti_id = "nx_meta_loop";
        public static final String open_in_new_tab_id = "nx_meta_link_open";

        public static final String select_sound_dropdown_xpth = "//*[@id=\"nx-meta-download_stats_sound\"]/td/div/span[1]/span[1]/span/span[2]";

    }

    public static class preview_downstat_notification_LOCATOR{
        public static final String plugin_link_xpth = "/html/body/div[4]/a";
        //		public static final String plugin_link_xpth = "/html/body/div[5]/div/div[1]";
        public static final String  close_btn_xpth= "/html/body/div[4]/div/span";
    }

}
