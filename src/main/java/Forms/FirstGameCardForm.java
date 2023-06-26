package Forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import utilities.StringsUtils;

import java.util.List;
import java.util.Random;

public class FirstGameCardForm extends BaseAppForm {
    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password field");
    private final ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email field");
    private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain field");
    private final IButton btnDomain = getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown__field')]"), "Domains list");
    private final static String btnListOfDomains = "//div[contains(@class,'dropdown__list-item')]";
    private final ICheckBox chkBoxAcceptTerms = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'checkbox__check')]"), "Accept terms and conditions checkbox");
    private final IButton btnNext = getElementFactory().getButton(By.className("button--secondary"), "Next button");

    public FirstGameCardForm() {
        super(By.className("login-form__container"), "First game card from");
    }

    public boolean firstGameCardPageIsPresent() {
        this.state().waitForDisplayed();
        return this.state().isDisplayed();
    }

    public void clickOnFieldPasswordAndInputRandomPassword(String capitalLitter, int numeral, String cyrillicCharacter) {
        txbPassword.clickAndWait();
        txbPassword.clearAndType(StringsUtils.getRandomPassword(capitalLitter, numeral, cyrillicCharacter));
    }

    public void clickOnEmailFieldAndInputRandomEmail() {
        txbEmail.clickAndWait();
        txbEmail.clearAndType(StringsUtils.getRandomEmail());
    }

    public void clickOnFieldDomainAndInputRandomDomain() {
        txbDomain.clickAndWait();
        txbDomain.clearAndType(StringsUtils.randomDomain());
    }

    public void clickOnDomainButtonAndChoosingRandomDomainFromList() {
        btnDomain.clickAndWait();
        List<IButton> listButtonsOfDomain = getElementFactory().findElements(By.xpath(btnListOfDomains), ElementType.BUTTON);
        Random random = new Random();
        int randoIndex = random.nextInt(listButtonsOfDomain.size());
        listButtonsOfDomain.stream().skip(randoIndex).findFirst().ifPresent(IElement::clickAndWait);
    }

    public void clickToAcceptTermsAndConditions() {
        chkBoxAcceptTerms.clickAndWait();
    }

    public void clickButtonNext() {
        btnNext.clickAndWait();
    }
}
