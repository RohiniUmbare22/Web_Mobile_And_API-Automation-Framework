package stepdef.ui;

import framework.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.PageActionLibrary;

import static locators.Web.webLocator.*;

public class WebLoginStepDef extends BaseTest {

    private static final Logger logger = LogManager.getLogger(WebLoginStepDef.class);

    @Given("I Open the application")
    public void open_Browser_and_navigate_to()  {
        logger.info("You are Api Step Definition");
        getDriver();
       // waitForMilliSeconds(5000);
    }

    @Given("I enter Username and Password")
    public void open_Browser_and_navigate_to_website_and_perform_login() {
        PageActionLibrary.sendText(LOGIN_USERNAME_TEXT_BOX, getConfigMAP().get("login_Username"));
        PageActionLibrary.sendText(LOGIN_PASSWORD_TEXT_BOX, getConfigMAP().get("login_password"));
    }
    @When("Click on Login Button")
    public void Click_on_Login_Button() {
        PageActionLibrary.clickElement(LOGIN_BUTTON);
        waitForMilliSeconds(10000);
    }

    @Then("Verify that landing to dashboard page {string}")
    public void Verify_that_landing_to_dashboard_page(String Title) {
        PageActionLibrary.verifytext(PAGE_TITLE,Title);

    }
   @And("I select a item and Added in cart")
   public void I_select_a_item() {
       PageActionLibrary.clickElement(ITEM);
       PageActionLibrary.clickElement(ADD_TO_CART);


   }


}
