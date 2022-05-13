package com.nfs.bank_co.servlet;

import com.nfs.bank_co.pom.SigninPageTestPom;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://localhost:8080/Bank_Co_war_exploded/login.jsp
public class SignInPageTest {

    private static SigninPageTestPom page;

    @BeforeAll
    public static void init() {
        page = new SigninPageTestPom();
    }

    //Methode xpath
    @FindBy(xpath = "//*[@id='customerNumber']")
    public WebElement customernumberInput;

    //Methode css
    @FindBy(css = "#password")
    public WebElement passwordInput;


    @Test
    public void testSignIn() {
        customernumberInput.sendKeys("jdoe@gmail.com");
        passwordInput.sendKeys("rtysrysry");
    }

    @AfterAll
    public static void tearDown() {
        page.closeDriver();
    }

}