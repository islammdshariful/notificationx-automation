package utils;

public class nxContactFromNotificationUtils {
    public static class TEXT {
        public static final String add_title = "Contact Form Notification";

        public static final String slelect_form_text = "NotificationX Automation";
        public static final String noti_tem_name_text = "Name";

        public static final String tem_text = "Recently Contacted Via";

        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        public static final String contact_form_url = "http://nx.com/wp-form/";
        public static final String input_fname_text = "Webdriver";
        public static final String input_lname_text = "Automation";
        public static final String input_email_text = "Sabbir@gmail.com";
        public static final String input_message_text = "This Automation is for testing notificationX in Contact From.";


//        public static final String contact_form_url = "http://nx.com/a-notificationx-form-wpform/";
//        public static final String input_fname_text = "Webdriver";
//        public static final String input_lname_text = "Automation";
//        public static final String input_email_text = "Sabbir@gmail.com";
//        public static final String input_message_text = "This Automation is for testing notificationX in Contact From.";

        public static final String name_text = input_fname_text + " Recently Contacted Via";
        public static final String contacform_name_text = slelect_form_text;
    }

    public static class edit_contactform_notification_LOCATOR {
        public static final String choose_cf7_xpth = "//*[@id=\"nx-meta-form_source\"]/td/div/div/div/div[1]/label";
        public static final String choose_wpform_xpth = "//*[@id=\"nx-meta-form_source\"]/td/div/div/div/div[2]/label";
        // ----------------------------design-----------------------
        public static final String choose_theme_xpth = "//*[@id=\"nx-meta-form_theme\"]/td/div/div/div/div[2]/label/img";

        // ----------------------------content-----------------------
        public static final String select_form_dropdown_xpth = "//*[@id=\"nx-meta-wpf_form\"]/td/div/span/span[1]/span/span[2]";
        public static final String input_select_form_xpth = "/html/body/span/span/span[1]/input";
        public static final String noti_template_name_xpth = "//*[@id=\"nx_meta_wpf_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String input_tem_name_xpth = "/html/body/span/span/span[1]/input";
        public static final String input_tem_text_id = "nx_meta_wpf_template_new_second_param";
        public static final String title_drpdwn_xpth = "//*[@id=\"nx_meta_wpf_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String time_drpdwn_xpth = "//*[@id=\"nx_meta_wpf_template_new\"]/div/span[3]/span[1]/span/span[2]";
        //
//		//link options
//		public static final String link_type_drpdwn_xpth = "//*[@id=\"nx-meta-donation_url\"]/td/div/span/span[1]/span/span[2]";
//
        // ---------------------------------Display---------------------------------
        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String choose_img_xpth = "//*[@id=\"nx-meta-default_avatar\"]/td/div/div/div/div[5]";
        public static final String img_drpdwn_xpth = "//*[@id=\"nx-meta-show_notification_image\"]/td/div/span/span[1]/span/span[2]";

        // visibility
        public static final String showon_dropdown_xpth = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String displayfor_dropdown_xpth = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // ---------------------------------Customize------------------------------
        public static final String postion_dropdown_xpth = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String type_position_xpth = "/html/body/span[2]/span/span[1]/input";
        public static final String noti_size_id = "nx_meta_conversion_size";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visibility_id = "nx_meta_hide_on_mobile";
        public static final String enable_sound_xpth = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        // Queue management
        public static final String enable_glb_queue_id = "nx_meta_global_queue_active";

        // Behavior
        public static final String loop_noti_id = "nx_meta_loop";
        public static final String open_in_new_tab_id = "nx_meta_link_open";

        public static final String select_sound_dropdown_xpth = "//*[@id=\"nx-meta-conversions_sound\"]/td/div/span[1]/span[1]/span/span[2]";

    }

    public static class contact_LOCATOR {
//        public static final String page_url = "http://nx.com/elementor-24995/";
//        public static final String input_fname_id = "wpforms-25034-field_0";
//        public static final String input_lname_id = "wpforms-25034-field_0-last";
//        public static final String input_email_id = "wpforms-25034-field_1";
//        public static final String input_message_id = "wpforms-25034-field_2";
//        public static final String submit_button_id = "wpforms-submit-25034";

        public static final String input_fname_id = "wpforms-25034-field_0";
        public static final String input_lname_id = "wpforms-25034-field_0-last";
        public static final String input_email_id = "wpforms-25034-field_1";
        public static final String input_message_id = "wpforms-25034-field_2";
        public static final String submit_button_id = "wpforms-submit-25034";

    }

    public static class preview_contactform_notification_LOCATOR {

        public static final String img_xpth = "/html/body/div[4]/div/div[1]/img";
        public static final String name_xpth = "/html/body/div[4]/div/div[2]/div[1]";
        public static final String contactform_xpth = "/html/body/div[4]/div/div[2]/div[2]/span";
        public static final String time_xpth = "/html/body/div[4]/div/div[2]/div[3]/div/span/small";
        public static final String notificationX_link_xpth = "/html/body/div[4]/div/div[2]/div[3]/small";
        public static final String close_btn_xpth = "/html/body/div[4]/div/span";

    }
}

