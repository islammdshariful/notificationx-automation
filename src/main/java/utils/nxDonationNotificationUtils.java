package utils;

public class nxDonationNotificationUtils {
    public static class TEXT {
        public static final String add_title = "Donation Notification";
        public static final String name_title = "Last Name";
        public static final String from_title = "From";
        public static final String donate_txt = "Donated";

        public static final String city_title = "City, Country";
        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";


        public static final String name_text = "Sabbir From Somewhere";
        public static final String donation_name_text = "Donated NotificationX";
        public static final String noti_size_text = "450";

        public static final String 	position_text = "Bottom Right";
        public static final String donation_page_title = "NotificationX – NX";
    }

    public static class donate_locator{
        public static final String donation_form_url = "http://nx.com/donations/3843/";
        public static final String donate_next_page_xpth = "/html/body/div[1]/div[2]/div[1]/button[2]";
        public static final String donate_ammount_id = "give-amount";
        public static final String continute_button_xpth = "/html/body/div[1]/form/div[2]/button";
        public static final String final_donate_now_button_id = "give-purchase-button";
    }

    public static class edit_donation_notification_LOCATOR {
        public static final String choose_givewp_xpth = "//*[@id=\"nx-meta-donation_source\"]/td/div/div/div/div/label";
        // ----------------------------design-----------------------
        public static final String choose_theme_xpth = "//*[@id=\"nx-meta-donation_theme\"]/td/div/div/div/div[6]/label/img";

        // ----------------------------content-----------------------
        public static final String name_dropdown_xpth = "//*[@id=\"nx_meta_maps_theme_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String input_name_xpth = "/html/body/span/span/span[1]/input";
        public static final String input_from_id = "nx_meta_maps_theme_template_new_from";
        public static final String city_drpdwn_xpth = "//*[@id=\"nx_meta_maps_theme_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String input_city_xpth = "/html/body/span/span/span[1]/input";
        public static final String input_donate_txt_id = "nx_meta_maps_theme_template_new_third_param";
        public static final String title_drpdwn_xpth = "//*[@id=\"nx_meta_maps_theme_template_new\"]/div/span[3]/span[1]/span/span[2]";
        public static final String show_noti_drpdwn_xpth = "//*[@id=\"nx-meta-give_forms_control\"]/td/div/span/span[1]/span/span[2]";

        //link options
        public static final String link_type_drpdwn_xpth = "//*[@id=\"nx-meta-donation_url\"]/td/div/span/span[1]/span/span[2]";

        // ---------------------------------Display---------------------------------
        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String img_drpdwn_xpth = "//*[@id=\"nx-meta-show_notification_image\"]/td/div/span/span[1]/span/span[2]";

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

    public static class preview_donation_notification_LOCATOR{

        public static final String img_xpth = "/html/body/div[4]/div/div[1]/img";
        public static final String name_xpth = "/html/body/div[4]/div/div[2]/div[1]";
        public static final String donate_xpth = "/html/body/div[4]/div/div[2]/div[2]";
        public static final String time_xpth = "/html/body/div[4]/div/div[2]/div[3]/div";
        public static final String notificationX_link_xpth = "/html/body/div[4]/div/div[2]/div[3]/small";
        public static final String close_btn_xpth = "/html/body/div[4]/div/span";
        public static final String donate_page_link_xpth = "/html/body/div[4]/a";

    }
}
