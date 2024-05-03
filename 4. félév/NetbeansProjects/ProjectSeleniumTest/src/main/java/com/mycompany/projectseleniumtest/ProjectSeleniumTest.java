package com.mycompany.projectseleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProjectSeleniumTest {
    
    public static void main(String[] args) {
        
        ProjectSeleniumTest.loginTest("nagybeni@gmail.com", "Alma123*");
        
    }
    
    public static void loginTest(String email, String pw){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayer.hedda\\Documents\\NetbeansProjects\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/mayer.hedda/Documents/CyberRead/GitHub/Log-in/login.html");

        
        driver.findElement(By.xpath("//input[@id='inputEmail']")).click();
        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='inputPwd']")).click();
        driver.findElement(By.xpath("//input[@id='inputPwd']")).sendKeys(pw);
        driver.findElement(By.xpath("//input[@id='inputEmail']")).click();
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();
    }
    
}
