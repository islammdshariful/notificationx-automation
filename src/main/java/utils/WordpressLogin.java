package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLogin {
    public static void login(WebDriver driver) {

        driver.findElement(By.id(Config.LOGIN.username_field_id)).clear();
        driver.findElement(By.id(Config.LOGIN.password_field_id)).clear();

        driver.findElement(By.id(Config.LOGIN.username_field_id)).sendKeys(Config.LOGIN.username);
        driver.findElement(By.id(Config.LOGIN.password_field_id)).sendKeys(Config.LOGIN.password);
        driver.findElement(By.id(Config.LOGIN.login_button_id)).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Config.UTILS.wordpress_home_xpath)));
//		driver.switchTo().alert().dismiss();
    }

    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id(Config.LOGIN.username_field_id)).clear();
        driver.findElement(By.id(Config.LOGIN.password_field_id)).clear();

        driver.findElement(By.id(Config.LOGIN.username_field_id)).sendKeys(username);
        driver.findElement(By.id(Config.LOGIN.password_field_id)).sendKeys(password);
        driver.findElement(By.id(Config.LOGIN.login_button_id)).click();
    }
}
