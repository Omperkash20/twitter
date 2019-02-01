package twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;

public class MainPage extends BasePageObject {

    @FindBy(xpath = "//*[@id=\"tweet-box-home-timeline\"]")
    protected WebElement tweetBox;

    @FindBy(xpath= "/html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[3]/div[2]/button/span[1]")
    protected WebElement tweetButton;


    public MainPage(WebDriver webDriver){
        super(webDriver);
        defaultWebpageElementLocator(webDriver);
    }


    public boolean isPageLoaded() {
        logger.info("Verifying that the login page is loaded by visibility of login button");
        boolean isLogoShown= elementHelper.isElementDisplayedWithinTime(tweetBox,5000);
        if(isLogoShown){
            logger.info("The main page is visible");
            return true;
        }
        logger.info("The main page is  not visible");
        return false;

    }

    public boolean checkIfTweetHasBeenMade(String tweet){
        elementHelper.clickWithinTime(tweetBox,3000);
        elementHelper.sendKeysWithControlledSpeed(tweetBox,tweet,0);
        sleep(1000);
        tweetButton.click();
        elementHelper.clickWithinTime(tweetButton,3000);
        logger.info("tweet button clicked and tweet has been made");
        return true;
    }

}
