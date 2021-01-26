package utils;

public class nxSalesNotificationUtils {
    public static class Sales_notification_TEXT {
        //Edit mode
        public static final String add_title = "Sales Notification";
        public static final String notificationX_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";

        public static final String combine_order_txt = "More Products";
        public static final String notificaion_size = "450";
        public static final String delay_before_text = "1";
        public static final String display_for_text = "50";
        public static final String display_from_text = "10";

        public static final String purchased = "Mr. S just purchased";
        public static final String notificationX_link_page_title = "NotificationX - Best Social Proof & FOMO Marketing Solution";
    }

    public static class Edit_NotificationX_Sale_locator {
        // -----------------------------------Source-------------------------------------
        public static final String select_sales_notification_xpath = "//*[@id=\"nx-meta-display_type\"]/td/div/div/div/div[1]/label";
        public static final String select_woocommerce_xpath = "//*[@id=\"nx-meta-conversion_from\"]/td/div/div/div/div[1]/label";

        // ---------------------------------Design---------------------------------------
        public static final String choose_theme_xpath = "//*[@id=\"nx-meta-theme\"]/td/div/div/div/div[2]/label";

        // ---------------------------------------------Content-------------------------------
        public static final String template_name_dropdown_xpath = "//*[@id=\"nx_meta_woo_template_new\"]/div/span[1]/span[1]/span/span[2]";
        public static final String product_title_dropdown_xpath = "//*[@id=\"nx_meta_woo_template_new\"]/div/span[2]/span[1]/span/span[2]";
        public static final String define_time_dropdown_xpath = "//*[@id=\"nx_meta_woo_template_new\"]/div/span[3]/span[1]/span/span[2]";

        // Combine multi product
        public static final String combine_multi_id = "nx_meta_combine_multiorder";
        public static final String combine_multi_text_id = "nx_meta_combine_multiorder_text";

        // Show purchase of
        public static final String show_purchase_dropdown_xpath = "//*[@id=\"nx-meta-product_control\"]/td/div/span/span[1]/span/span[2]";
        // Exclude by
        public static final String exclude_by_dropdown_xpath = "//*[@id=\"nx-meta-product_exclude_by\"]/td/div/span/span[1]/span/span[2]";

        // Link option
        public static final String link_type_dropdown_xpath = "//*[@id=\"nx-meta-conversion_url\"]/td/div/span/span[1]/span/span[2]";

        // --------------------------------------------DISPLAY--------------------------------------------
        // image
        public static final String show_default_img_id = "nx_meta_show_default_image";
        public static final String img_dropdown_xpath = "//*[@id=\"nx-meta-show_notification_image\"]/td/div/span/span[1]/span/span[2]";

        // Visibility
        public static final String showon_dropdown_xpath = "//*[@id=\"nx-meta-show_on\"]/td/div/span/span[1]/span/span[2]";
        public static final String display_for_dropdown_xpath = "//*[@id=\"nx-meta-show_on_display\"]/td/div/span/span[1]/span/span[2]";

        // -------------------------------------------Customize--------------------------------------------
        // Appearance
        public static final String position_dropdown_xpath = "//*[@id=\"nx-meta-conversion_position\"]/td/div/span/span[1]/span/span[2]";
        public static final String noti_size_xpth = "nx_meta_conversion_size";
        public static final String display_close_btn_id = "nx_meta_close_button";
        public static final String mbl_visibility_id = "nx_meta_hide_on_mobile";

        // QUEUE MANAGEMENT
        public static final String enable_sound_xpath = "//*[@id=\"nx-meta-section-sound_checkbox_wrap\"]/div[2]/div/label";
        public static final String enable_global_que_id = "nx_meta_global_queue_active";

        // Timing
        public static final String delay_before_id = "nx_meta_delay_before";
        public static final String display_for_id = "nx_meta_display_for";
        public static final String display_from_id = "nx_meta_display_from";

        //Behavior
        public static final String loop_noti_id = "nx_meta_loop";
        public static final String enable_open_new_tab_id = "nx_meta_link_open";

        //sound setting
        public static final String select_sound_dropdown_xpth = "//*[@id=\"nx-meta-conversions_sound\"]/td/div/span[1]/span[1]/span/span[2]";

        public static final String notificationX_link_xpath = "//*[@id=\"notificationx-5f8ecb7ca2e13\"]/div/div[2]/div[3]/small/a";

    }

    public static class Buy_product {
        public static final String product_option_xpath = "//*[@id=\"menu-posts-product\"]/a/div[3]";
        public static final String product_xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/strong";
        public static final String product_link = "//*[@id=\"sample-permalink\"]/a";
        public static final String view_product_xpth = "/html/body/div[1]/div[2]/div[3]/div[1]/div[5]/form[1]/table/tbody/tr[1]/td[2]/div[3]/span[5]/a";

        public static final String product_name_page = "/html/body/div[2]/div/div/div/main/div/div[2]/div[2]/h1";
        public static final String addtocart_xpath = "/html/body/div[2]/div/div/div/main/div/div[2]/div[2]/form/button";

        public static final String checkout_link = "http://nx.com/checkout/";
        public static final String choose_cod_id = "payment_method_cod";
        public static final String place_order_id = "place_order";

    }

    public static class Preview_NotificationX_Sale_locator {
        // PREVIEW MODE
        public static final String product_image_xpath = "/html/body/div[4]/div/div[1]/img";
        public static final String product_purchased_xpath = "/html/body/div[4]/div/div[2]/div[1]";
        public static final String product_name_xpath = "/html/body/div[4]/div/div[2]/div[2]";
        public static final String product_notification_xpath = "/html/body/div[4]/a";
        public static final String notification_close_button_xpath = "/html/body/div[4]/div/span";
        public static final String product_purchasing_time_xpath = "/html/body/div[4]/div/div[2]/div[3]/div";
        public static final String notificationX_link = "/html/body/div[4]/div/div[2]/div[3]/small";

    }
}
