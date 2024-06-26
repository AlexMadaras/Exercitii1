package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyHomePage(){
       return driver.getTitle();
    }

    public void scrollDownToTheBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.className("single-widget"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        String elementText = element.getText();
        String subscriptionText = elementText.substring(0, 12);
        assert subscriptionText.equals("SUBSCRIPTION");

    }
    public void goUp(){
        WebElement goUp = driver.findElement(By.id("scrollUp"));
        goUp.click();
    }

    public void goUpWithoutclickArrowButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2"));
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void verifyTextUpperPage(){
        WebElement text = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2"));
        String text1 =text.getText();
        assert  text1.equals("Full-Fledged practice website for Automation Engineers");
    }

}
