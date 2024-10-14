package stepdef.Mob;

import framework.MobileBaseTest;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.MobActionLibrary;

import java.net.MalformedURLException;

import static locators.Web.androidLocator.*;

public class MobileLoginStepDef extends MobileBaseTest {
    private static final Logger logger = LogManager.getLogger(MobileLoginStepDef.class);


    @Given("I Open the Mobile application")
    public void open_Application() throws MalformedURLException {
        logger.info("You are Api Step Definition");
        getDriver();
        waitForMilliSeconds(10000);
    }

    @When("I Click on Login from Menu Bar")
    public void I_Click_on_Login_from_MenuBar() {
        MobActionLibrary.clickElement(LOGIN);
        waitForMilliSeconds(10000);
    }
    @When("I Click on Login Button")
    public void Click_on_Login_Button() {
        MobActionLibrary.clickElement(LOGIN_BUTTON);
        waitForMilliSeconds(10000);
    }
    @Then("I enter Username and Password details")
    public void I_enter_Username_and_Password_details() {
        MobActionLibrary.clickElement(LOGIN_USERNAME_TEXT_BOX);
        MobActionLibrary.sendText(LOGIN_USERNAME_TEXT_BOX, getConfigMAP().get("Mobile_login_Username"));
        MobActionLibrary.clickElement(LOGIN_PASSWORD_TEXT_BOX);
        MobActionLibrary.sendText(LOGIN_PASSWORD_TEXT_BOX, getConfigMAP().get("Mobile_login_password"));
        driver.hideKeyboard();
        waitForMilliSeconds(10000);

    }
    @Then("I Click Menu Bar on dashboard page")
    public void I_click_Menu_Bar_on_dashboard_page() {
        MobActionLibrary.clickElement(MENU_BAR);
        waitForMilliSeconds(10000);

    }

}
