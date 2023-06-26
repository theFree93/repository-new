package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInterfaceTest extends BaseTest {
    @Test
    public void homePage() {
        logger.info("Open the home page and click on button 'HERE' to go to the next page.");
        Assert.assertTrue(homePage.homePageIsPresent(), "Home page is does not present.");
        homePage.clickOnButtonHere();

        Assert.assertTrue(gamePage.getFirstGameForm().firstGameCardPageIsPresent(), "Login page dose not present.");
        logger.info("Input random password according to the terms.");
        gamePage.getFirstGameForm().clickOnFieldPasswordAndInputRandomPassword(CAPITAL_LITTER_FOR_PASSWORD, NUMERAL_FOR_PASSWORD, CYRILLIC_CHARACTER_FOR_PASSWORD);
        logger.info("Input random email.");
        gamePage.getFirstGameForm().clickOnEmailFieldAndInputRandomEmail();
        logger.info("Input random domain.");
        gamePage.getFirstGameForm().clickOnFieldDomainAndInputRandomDomain();
        logger.info("Choosing random domain from the list.");
        gamePage.getFirstGameForm().clickOnDomainButtonAndChoosingRandomDomainFromList();
        logger.info("Accepting of terms and conditions.");
        gamePage.getFirstGameForm().clickToAcceptTermsAndConditions();
        logger.info("Click on button 'Next' to go to next page.");
        gamePage.getFirstGameForm().clickButtonNext();


        Assert.assertTrue(gamePage.getSecondCardForm().secondGameCardFormIsPresent(), "Second game card form does not present");
        logger.info("Uploading avatar");
        gamePage.getSecondCardForm().clickOnUploadButton();
        gamePage.getSecondCardForm().uploadingAvatar(NAME_OF_IMAGE_FOR_UPLOADING);
        logger.info("Click unselect all check boxes and choosing random interests");
        gamePage.getSecondCardForm().clickUnselectAllCheckBoxes();
        gamePage.getSecondCardForm().checkBoxesInterestsRandomChoosing();
        logger.info("Click button 'Next' to go to next page");
        gamePage.getSecondCardForm().clickOnButtonNext();

        Assert.assertTrue(gamePage.getThirdGameForm().thirdGameFormIsPresent(), "Third game form does not present");
    }

    @Test
    public void helpFormTestTest() {
        Assert.assertTrue(homePage.homePageIsPresent(), "Home page does not open");
        logger.info("Click button here to go to next page");
        homePage.clickOnButtonHere();
        logger.info("Click hiding help");
        gamePage.clickHidingHelp();
        Assert.assertTrue(gamePage.helpFormDisappear(), "Help form does not disappear");
    }

    @Test
    public void acceptCookiesTest() {
        Assert.assertTrue(homePage.homePageIsPresent(), "Home page does not open");
        homePage.clickOnButtonHere();
        logger.info("Click accept cookies");
        gamePage.clickAcceptCookies();
        Assert.assertTrue(gamePage.hidingCookiesField(), "Cookies field does not disappear");
    }

    @Test
    public void validTimeTest() {
        Assert.assertTrue(homePage.homePageIsPresent(), "Home page does not open");
        homePage.clickOnButtonHere();
        Assert.assertTrue(gamePage.validateTimeStart(), "Time dose not start from 00:00");
    }
}
