package com.nfs.bank_co.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninPageTestPom {
    private static WebDriver driver;

    private By h4Cyber = By.xpath("//h4[contains(text(),Cybersecurity)]");

    public SigninPageTestPom() {
        System.setProperty("webdriver.chrome.driver", "/home/legilmalas/Downloads/selenium-java-4.1.4/selenium-chrome-driver-4.1.4.jar");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank_Co_war_exploded/login.jsp");
    }

    public WebElement getH4Cyber() throws InterruptedException {
        System.out.println("implicit wait ");
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        System.out.println("*** end wait ***");
        return driver.findElement(h4Cyber);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public int getNbLink() {
        return driver.findElements(By.xpath("/html/body/nav//a")).size();
    }

    public void closeDriver() {
        driver.close();
    }
}
