package com.mycompany.seleniumdualis;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDualis {
    public static void main(String[] args) throws InterruptedException{
        /*
        //Böngésző ablak nyitása - chrome
        //System.setProperty("webdrive.chrome.driver","/Users/asus/Documents/Netbeans/Dependencies/SeleniumJarFiles/chromedriver_mac_arm64/chromedriver");
        //WebDriver driver = new ChromeDriver();
        
        //Böngésző ablak nyitása - firefox
        System.setProperty("webdriver.firefox.driver", "/Users/asus/Documents/Netbeans/Dependencies/SeleniumJarFiles/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://seleniumhq.org");
        
        //böngésző bezárása test script végén
        // driver.quit();
        
//        //ELemre kattintás példányosítással
//        WebElement element = driver.findElement(By.xpath("//a[@id='navbarDropdown']"));
//        element.click();
        
        //Elemre katitntás példányosítás nélkül:
        driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();
        
        //új tab nyitása
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // 0-> selenium 1-> üres
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("http://google.com");
        
//        //Statikus várakozás - nem jó
//        Thread.sleep(10000);

        //Dinamikus várakozás - max 10mp, a betöltéskor vége
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uMousc']")));
        //betöltött ablakra hivatkozva gombra kattintás - jó módszer
//        WebElement acceptButton = cookiePopup.findElement(By.xpath("//div[normalize-space()='Az összes elfogadása']"));
//        acceptButton.click();
        
        //háttér ablakra hivatkozva gombra kattintás - rosszabb módszer
//        driver.findElement(By.xpath("//div[normalize-space()='Az összes elfogadása']")).click();


        // További dinamikus várakozási lehetőség
        //létezik
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='uMousc']")));
        //kattintható
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='uMousc']")));
        // nem látható
        boolean elementNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='uMousc']")));
        //  Text betölt benne - mi adjuk meg a textet, egyeznie kell
        boolean textPresent = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='uMousc']")), "Expected Text"));
        

        Thread.sleep(5000);

        Cookie cookie = new Cookie("SOCS","CAISHAgBEhJnd3NfMjAyNDAxMjQtMF9SQzIaAmh1IAEaBgiA-OCtBg");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        */
        
        //checkText();
        gmailLogin("norbi1119","");
    }
    
    public static void checkText(){
        System.setProperty("webdriver.firefox.driver", "/Users/asus/Documents/Netbeans/Dependencies/SeleniumJarFiles/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://iakk.hu");
        
        String Title = driver.getTitle();
        String btnText = driver.findElement(By.xpath("//a[@title='Többet szeretnék tudni']")).getText();
        
        System.out.println(Title);
        
        System.out.println(btnText.equals("Többet szeretnék tudni!") ? "Egyezik" : "Nem egyezik, a gomb szövege: "+ btnText + " volt");
        
        
    }
    
    public static void gmailLogin(String email, String pw){
        System.setProperty("webdriver.firefox.driver", "/Users/asus/Documents/Netbeans/Dependencies/SeleniumJarFiles/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");


        // Dinamikus várakozás, max 10mp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uMousc']")));
        //Elfogadás gomb kiválasztása és kattintás
        WebElement acceptButton = cookiePopup.findElement(By.xpath("//div[normalize-space()='Az összes elfogadása']"));
        acceptButton.click();
        
        driver.findElement(By.xpath("//a[@aria-label='Bejelentkezés']")).click();
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(email);
        driver.findElement(By.xpath("//span[normalize-space()='Tovább']")).click();
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(pw);
        driver.findElement(By.xpath("//span[normalize-space()='Tovább']")).click();
    }
}
