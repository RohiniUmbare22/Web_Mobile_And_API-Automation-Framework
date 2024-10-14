package utility;

import framework.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static locators.Web.webLocator.PAGE_TITLE;

public class PageActionLibrary extends BaseTest{ private static final Logger logger = LogManager.getLogger(PageActionLibrary.class);


    public static WebElement getElementByVisibility(String locator) {

        By byElement = ElementExtractor.getElement(locator);
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, 10);
        try {
            logger.info("Checking visibility of element:"+locator);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (Exception e) {
            logger.info(e);
            e.printStackTrace();
            return null;
        }
    }


    public static void clickElement(String locator) {
        WebElement element = getElementByVisibility(locator);
        if (element != null) {
            try {
                logger.info("Clicking on element:"+locator);
                element.click();
            } catch (Exception e) {
                logger.info(e);
                System.out.println(e);
            }
        }
    }



    public static void waitForMilliSeconds(int milliSeconds) {
        try {
            logger.info("Waiting for " + milliSeconds + " Miliseconds..");
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            logger.info(e);
            e.printStackTrace();
        }
    }



    public static boolean sendText(String locator, String text) {
        WebElement element = getElementByVisibility( locator);
        if (element != null) {
            try {
                logger.info("Send keys on element:"+element+text);
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                logger.info(e);
                System.out.println(e);
            }
        }
        return false;
    }


    public static void verifytext(String locator,String Title) {
        WebElement element = getElementByVisibility( locator);
        if (element != null) {
            try {
                element.isDisplayed();
                Assert.assertEquals(element.getText(),Title);

            } catch (Exception e) {
                logger.info(e);
                System.out.println(e);
            }
        }

    }


}
