package Forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import org.openqa.selenium.By;
import utilities.UploaderFiles;

import java.util.List;

public class SecondGameCardForm extends BaseAppForm {
    private final IButton btnUpload = getElementFactory().getButton(By.xpath("//a[contains(@class, 'upload-button')]"), "Upload button");
    private final ICheckBox chkBoxUnselectAll = getElementFactory().getCheckBox(By.xpath("//input[@id='interest_unselectall']/parent::label"), "Unselect all check boxes");
    private final static String ALL_CHECK_BOXES_INTERESTS = "//span[@class='checkbox__box']";
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--stroked')]"), "Next button");
    private final static int AMOUNT_RANDOM_SELECTED_CHECKBOXES = 3;

    public SecondGameCardForm() {
        super(By.className("avatar-and-interests__form"), "Second game card from");
    }

    public boolean secondGameCardFormIsPresent() {
        this.state().waitForDisplayed();
        return this.state().isDisplayed();
    }

    public void clickOnUploadButton() {
        this.state().waitForDisplayed();
        btnUpload.clickAndWait();
    }

    public void uploadingAvatar(String imageName) {
        UploaderFiles.UploaderImages(imageName);
    }

    public void clickUnselectAllCheckBoxes() {
        chkBoxUnselectAll.state().waitForClickable();
        chkBoxUnselectAll.clickAndWait();
    }

    public void checkBoxesInterestsRandomChoosing() {
        List<ICheckBox> listCheckBoxes = getElementFactory().findElements(By.xpath(ALL_CHECK_BOXES_INTERESTS), ElementType.CHECKBOX);
        for (int i = 0; i < AMOUNT_RANDOM_SELECTED_CHECKBOXES; i++) {
            int randomLabel = (int) (listCheckBoxes.size() * Math.random());
            listCheckBoxes.get(randomLabel).click();
            listCheckBoxes.remove(listCheckBoxes.get(randomLabel));
        }
    }

    public void clickOnButtonNext() {
        btnNext.clickAndWait();
    }
}
