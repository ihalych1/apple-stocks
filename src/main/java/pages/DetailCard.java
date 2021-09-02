package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class DetailCard {
    private final AndroidDriver<MobileElement> driver;

    public DetailCard(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public DetailCard openHistoricalData() {
        driver.findElement(By.cssSelector("[data-test=HISTORICAL_DATA]")).click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test=qsp-historical]")));
        return this;
    }

    public LinkedList<Double> getStockInRange(int limit) {
        return driver.findElements(By.cssSelector("[data-test=historical-prices] tbody > tr"))
                .stream()
                .limit(limit)
                .map(el -> el.findElements(By.cssSelector("td")).get(5).getText())
                .map(Double::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
