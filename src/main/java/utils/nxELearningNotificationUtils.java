package utils;

public class nxELearningNotificationUtils {
    public static class TEXT {
        public static final String add_title = "eLearning Tutor LMS";

        public static final String slelect_tem_name_text = "First Name";
        public static final String noti_tem_name_text = "Name";

        public static final String tem_text = "USER just enrolled";

        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

        public static final String delay_before_text = "1";
        public static final String display_for_text = "60";
        public static final String display_from_text = "10";

        public static final String course_name_text = "NotifciationX Automation for Tutor LMS";
        public static final String course_page_title = "NotifciationX Automation for Tutor LMS – NX";

    }

    public static class edit_elearning_notification_LOCATOR {
        public static final String choose_tutor_xpth = "//*[@id=\"nx-meta-elearning_source\"]/td/div/div/div/div[1]/label";
        // ----------------------------design-----------------------
        public static final String choose_theme_xpth = "//*[@id=\"nx-meta-elearning_theme\"]/td/div/div/div/div[4]/label/img";

        // ----------------------------content-----------------------
        public static final String select_tem_name_dropdown_xpth = "//*[@id=\"nx_meta_elearning_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String input_tem_name_xpth = "/html/body/span/span/span[1]/input";
        public static final String input_tem_text_id = "nx_meta_elearning_template_new_second_param";
        public static final String title_drpdwn_xpth = "//*[@id=\"nx_meta_elearning_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String time_drpdwn_xpth = "//*[@id=\"nx_meta_elearning_template_new\"]/div/span[3]/span[1]/span/span[2]";

        public static final String show_noti_type_drpdwn_xpth = "//*[@id=\"nx-meta-tutor_product_control\"]/td/div/span/span[1]/span/span[2]";
        public static final String input_noti_type_xpth = "/html/body/span/span/span[1]/input";
        public static final String input_select_course_xpth = "//*[@id=\"nx-meta-tutor_course_list\"]/td/div/span/span[1]/span/ul";


        //link options
        public static final String link_type_drpdwn_xpth = "//*[@id=\"nx-meta-elearning_url\"]/td/div/span/span[1]/span/span[2]";

        // ---------------------------------Display---------------------------------

        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String choose_img_xpth = "//*[@id=\"nx-meta-default_avatar\"]/td/div/div/div/div[3]/label";
        public static final String img_drpdwn_xpth = "//*[@id=\"nx-meta-show_notification_image\"]/td/div/span/span[1]/span/span[2]";

        // visibility
        public static final String showon_dropdown_xpth = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String displayfor_dropdown_xpth = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // ---------------------------------Customize------------------------------
        public static final String enable_sound_xpth = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        public static final String postion_dropdown_xpth = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String type_position_xpth = "/html/body/span/span/span[1]/input";
        // Queue management
        public static final String enable_glb_queue_id = "nx_meta_global_queue_active";

        //sound
        public static final String sound_drpdwn_xpth = "//*[@id=\"nx-meta-conversions_sound\"]/td/div/span[1]/span[1]/span/span[2]";
    }

    public static class learnign_page_LOCATOR{
        public static final String page_url = "http://nx.com/elementor-24995/";
        public static final String input_fname_id = "wpforms-25034-field_0";
        public static final String input_lname_id = "wpforms-25034-field_0-last";
        public static final String input_email_id = "wpforms-25034-field_1";
        public static final String input_message_id = "wpforms-25034-field_2";
        public static final String submit_button_id = "wpforms-submit-25034";
    }

    public static class preview_learning_notification_LOCATOR{

        public static final String img_xpth = "/html/body/div[2]/div/div[1]/img";
        public static final String name_xpth = "/html/body/div[2]/div/div[2]/div[1]";
        public static final String coursename_xpth = "/html/body/div[2]/div/div[2]/div[2]/span";
        public static final String time_xpth = "/html/body/div[2]/div/div[2]/div[3]/div/span/small";
        public static final String notificationX_link_xpth = "/html/body/div[2]/div/div[2]/div[3]/small";
        public static final String close_btn_xpth = "/html/body/div[2]/div/span";
        public static final String course_link_xpth = "/html/body/div[2]/a";

    }
}
