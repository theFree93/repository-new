package Forms.Pages;

import Forms.BaseAppForm;
import Forms.FirstGameCardForm;
import Forms.SecondGameCardForm;
import Forms.ThirdGameForm;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class GamePage extends BaseAppForm {
    private final IButton btnHideHelp = getElementFactory().getButton(By.xpath("//div[@class='align__cell u-right']/button"), "Help hide button");
    private final ITextBox txbHelpField = getElementFactory().getTextBox(By.className("help-form__text-area"), "Help field");
    private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--transparent')]"), "Accept cookies button");
    private final ITextBox txbCookiesField = getElementFactory().getTextBox(By.xpath("//div[@class='cookies']//div[@class='align align--fluid']"), "Accept cookies");
    private final ITextBox txbTimeField = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'timer--white')]"), "Time field");
    private static final String VALIDATE_START_TIME = "00:00:00";

    public GamePage() {
        super(By.className("password-check"), "Game page");
    }

    public FirstGameCardForm getFirstGameForm() {
        return new FirstGameCardForm();
    }

    public SecondGameCardForm getSecondCardForm() {
        return new SecondGameCardForm();
    }

    public ThirdGameForm getThirdGameForm() {
        return new ThirdGameForm();
    }

    public void clickHidingHelp() {
        btnHideHelp.clickAndWait();
    }

    public boolean helpFormDisappear() {
        txbHelpField.state().waitForNotDisplayed();
        return !txbHelpField.state().isDisplayed();
    }

    public void clickAcceptCookies() {
        btnAcceptCookies.state().waitForDisplayed();
        btnAcceptCookies.clickAndWait();
    }

    public boolean hidingCookiesField() {
        txbCookiesField.state().waitForNotDisplayed();
        return !txbCookiesField.state().isDisplayed();
    }

    public boolean validateTimeStart() {
        return txbTimeField.state().isDisplayed() && txbTimeField.getText().equals(VALIDATE_START_TIME);
    }
}
