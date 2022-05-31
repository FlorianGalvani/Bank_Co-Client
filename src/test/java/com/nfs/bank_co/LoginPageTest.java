package com.nfs.bank_co;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

// page_url = about:blank
public class LoginPageTest {
    // No page elements added
    private static WebDriver driver;
    private static String testForm = "test du formulaire";

    @BeforeAll // exe avant tous les test
    public static void init(){
        System.out.println("INIT");
        System.setProperty("webdriver.chrome.driver", "/home/legilmalas/Downloads/selenium-java-4.1.4 (1)/selenium-chrome-driver-4.1.4.jar");
        // si chrome = webdriver.chrome.driver
        // créer le navigateur de test
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank_Co_war_exploded/login.jsp");
    }

    @Test
    public void openPage() {
        driver.findElement(By.id("customerNumber")).sendKeys(testForm);
        driver.findElement(By.id("loginForm")).submit();
//        WebElement newMsg = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath(/html/body/)))
    }

    @AfterAll // exe à la fin de tous les tests
    public static void closeAll() {
        System.out.println("Close");

        driver.close();
    }
}