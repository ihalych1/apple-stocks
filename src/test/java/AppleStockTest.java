import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.LinkedList;

public class AppleStockTest extends BaseTest {

    @Test
    void verifyApplesStockProfitTest() {
        MainPage mainPage = new MainPage(driver);

        LinkedList<Double> appleStocks = mainPage.searchFor("Apple")
                .openHistoricalData()
                .getStockInRange(7);

        Assert.assertTrue(appleStocks.getFirst() > appleStocks.getLast(), "Non profitable week :)");
    }

}