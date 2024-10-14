package utility;
import framework.MobileBaseTest;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class MobActionLibrary extends MobileBaseTest {
    private static final Logger logger = LogManager.getLogger(MobActionLibrary.class);


    public static MobileElement getElementByVisibility(String locator) {
        By byElement = ElementExtractor.getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds wait
        try {
            logger.info("Checking visibility of element:"+locator);
            return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (Exception e) {
            logger.info(e);
            e.printStackTrace();
            return null;
        }
    }


    public static void clickElement(String locator) {
        MobileElement element = getElementByVisibility(locator);
        assertTrue("The expected element is not displayed",element.isDisplayed());

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
        MobileElement element = getElementByVisibility( locator);
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

}
