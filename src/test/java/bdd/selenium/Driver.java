package bdd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    private final WebDriver webDriver;

    public Driver(String browser) {
        if (browser.equals("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new RuntimeException("wrong type of browser");
        }
    }

    public void AccessUrl(String url){
        webDriver.get(url);
    }

    public void getElement(String elementType, String elementPath){
        switch (elementType) {
            case "class" :
                webDriver.findElement(By.className(elementPath));
                System.out.println("Element by class \"" + elementPath + "\" found.");
                break;
            case "xpath" :
                webDriver.findElement(By.xpath(elementPath));
                System.out.println("Element by xpath \"" + elementPath + "\" found.");
                break;
            default:
                System.out.println("Element \"" + elementType + "\" not found.");
        }
    }

    public void doSearch(String elementClassName, String searchVal){
        try {
            webDriver.findElement(By.className(elementClassName)).sendKeys(searchVal);
            // to wait due to temporary overlay
            new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[contains(@value, 'Google Search')]"))).click();
        } catch (Exception e) {
            System.out.println("Fail to do google search : " + e);
        }
    }

    public void verifyPageContainText(String Xpath, String text){
        webDriver.findElement(By.xpath(Xpath + "[contains(., '" + text + "')]"));
    }

    public void terminate() {
        webDriver.close();
    }
}