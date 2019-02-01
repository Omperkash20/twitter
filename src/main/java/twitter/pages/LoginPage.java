package twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.QAUser;

public class LoginPage extends BasePageObject {

    @FindBy(css=".submit.EdgeButton.EdgeButton--primary.EdgeButtom--medium")
    protected WebElement loginButton;


    @FindBy(css= ".js-username-field.email-input.js-initial-focus")
    protected WebElement usernameTextBox;

    @FindBy(css= ".js-password-field")
    protected WebElement passwordTextBox;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
        defaultWebpageElementLocator(webDriver);
    }


    public boolean isPageLoaded() {
        logger.info("Verifying that the login page is loaded by visibility of login button");
        boolean isLogoShown= elementHelper.isElementDisplayedWithinTime(loginButton,5000);
        if(isLogoShown){
        logger.info("The Login button is visible");
        return true;
        }
        logger.info("The Login button is  not visible");
        return false;

    }

    public void performLogin(QAUser user){
        elementHelper.sendKeysWithControlledSpeed(usernameTextBox,user.username,0);
        elementHelper.sendKeysWithControlledSpeed(passwordTextBox,user.password,0);
        elementHelper.clickWithinTime(loginButton,3000);
     }

}
