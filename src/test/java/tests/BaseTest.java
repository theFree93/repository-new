package tests;

import Forms.Pages.GamePage;
import Forms.Pages.HomePage;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertiesUtils;

import static enums.PropertyVariable.URL;

public abstract class BaseTest {
    protected Logger logger = AqualityServices.getLogger();
    protected final HomePage homePage = new HomePage();
    protected final GamePage gamePage = new GamePage();
    protected final static String CAPITAL_LITTER_FOR_PASSWORD = "R";
    protected final static int NUMERAL_FOR_PASSWORD = 5;
    protected final static String CYRILLIC_CHARACTER_FOR_PASSWORD = "Э";
    protected final static String NAME_OF_IMAGE_FOR_UPLOADING = "picture-for-avatar.jpg";
    private static final String PROPERTY_FILE_NAME = "config.properties";

    @BeforeMethod
    protected void runTest() {
        getBrowser().goTo(PropertiesUtils.loadingProperties(PROPERTY_FILE_NAME, URL));
        getBrowser().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        getBrowser().quit();
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}
