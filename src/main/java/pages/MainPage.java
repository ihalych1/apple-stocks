package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final AndroidDriver<MobileElement> driver;

    public MainPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public DetailCard searchFor(String searchValue) {
        By searchInput = By.id("yfin-usr-qry");
        driver.findElement(searchInput).sendKeys(searchValue);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=quote-header]")));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return new DetailCard(driver);
    }
}
