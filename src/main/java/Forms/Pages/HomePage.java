package Forms.Pages;

import Forms.BaseAppForm;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;


public class HomePage extends BaseAppForm {
    private final IButton buttonHere = getElementFactory().getButton(By.className("start__link"), "Here");


    public HomePage() {
        super(By.className("start__paragraph"), "Home page");
    }

    public Boolean homePageIsPresent() {
        return this.state().waitForDisplayed();
    }

    public void clickOnButtonHere() {
        buttonHere.clickAndWait();
    }
}
