package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    static {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
    }

    public static WebDriver driver = new ChromeDriver();
}
