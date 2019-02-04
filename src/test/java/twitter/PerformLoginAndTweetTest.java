package twitter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.QAUser;

public class PerformLoginAndTweetTest extends TwitterBaseTest {

    @Test(timeOut=18000, dataProvider="getWebDriver", groups={"standard"})
    public void performLoginAndWriteTweet(WebDriver webDriver) {
        logger.info("It varifies that login page has loaded");
        initPages(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load");

        QAUser user = BaseTestConfig.getInstance().getTestdata().users.get(0);
        loginPage.performLogin(user);

        Assert.assertTrue(mainpage.isPageLoaded(),"Main page failed to load ");

        String tweet="Fifth Testing Tweet via pigeon";
        Assert.assertTrue(mainpage.checkIfTweetHasBeenMade(tweet),"The tweet has not beaan made");

    }

}
