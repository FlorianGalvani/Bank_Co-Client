package com.nfs.bank_co;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTest {
    private static WebDriver driver;
    private static String testForm = "test du formulaire";

    @BeforeAll // exe avant tous les test
    public static void init(){
        System.out.println("INIT TEST");
        System.setProperty("webdriver.chrome.driver", "/home/legilmalas/Downloads/chromedriver_linux64/chromedriver");
        // créer le navigateur de test
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank_Co_war_exploded/login.jsp");
    }

    @Test
    public void testUrl() {
        System.out.println(driver.getCurrentUrl());
        assertEquals(0, driver.getCurrentUrl().compareTo("http://localhost:8080/Bank_Co_war_exploded/login.jsp"));
        //      WebElement newMsg = new WebDriverWait(driver,10).until(driver -> driver.findElement(By.xpath(/html/body/)))
    }

    @Test
    public void testGoHome() {
        WebElement goHome = driver.findElement(By.className("goHome"));
        goHome.click();
        if(driver.getCurrentUrl().compareTo("http://localhost:8080/Bank_Co_war_exploded/") == 0){
            assertEquals(0, 0);
        } else {
            assertEquals(0, 1);
        }
    }
    @Test
    public void testH1() {
        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertTrue(h1.getText().compareTo("Accéder à votre espace") == 0);
    }

    @Test
    public void loginFormWithIncorrectID() {
        WebElement customerNumber = driver.findElement(By.name("customerNumber"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("submit"));
        customerNumber.sendKeys("0123456789012345678901234");
        password.sendKeys("yuidtydtyidtyi");
        loginBtn.click();
    }


    @AfterAll // exe à la fin de tous les tests
    public static void closeAll() {
        System.out.println("Close");

        driver.close();
    }
}