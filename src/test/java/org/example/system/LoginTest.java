package org.example.system;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click on sign in
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);

        //enter email address
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("user@email.com");
        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("regularU$er123");

        //click on sign In
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);
        driver.quit();

    }

}