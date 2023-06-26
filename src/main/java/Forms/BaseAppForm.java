package Forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class BaseAppForm extends Form {
    protected BaseAppForm(final By locator, final String name) {
        super(locator, name);
    }
}
