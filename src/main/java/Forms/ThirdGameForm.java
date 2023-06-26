package Forms;

import org.openqa.selenium.By;

public class ThirdGameForm extends BaseAppForm {
    public ThirdGameForm() {
        super(By.className("personal-details__form"), "Third game card form");
    }

    public boolean thirdGameFormIsPresent() {
        this.state().waitForDisplayed();
        return this.state().isDisplayed();
    }
}
