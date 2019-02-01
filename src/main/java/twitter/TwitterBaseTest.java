package twitter;


import org.openqa.selenium.WebDriver;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import twitter.pages.LoginPage;
import twitter.pages.MainPage;

public class TwitterBaseTest extends BaseTestCase {

protected MainPage mainpage;
protected LoginPage loginPage;

public TwitterBaseTest(){
    super();
}

protected void initPages(WebDriver webDriver){
    logger.info("Initializing Pages that would be used in Test");
    loginPage= new LoginPage(webDriver);
    mainpage= new MainPage(webDriver);
}

protected void initializeWebDriver(WebDriver webDriver){
    webDriver.navigate().to("https://twitter.com/login");
    logger.info("Navigate to twitter's login-page, the sleep function provied 1000 milli seconds to load the page");
    sleep(5000);
}

protected String getDefaultPropertyFile() {
    return "twitter_config.xml";

}

}
