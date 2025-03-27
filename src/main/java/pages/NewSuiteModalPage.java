package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import object.Suite;
import static com.codeborne.selenide.Selenide.$x;

public class NewSuiteModalPage extends BasePage{

    public NewSuiteModalPage() {
    }

    public SelenideElement createSuiteButton =  $x("//*[@type='submit']");
    public static final String SUITE_NAME_XPATH = "//*[@id = 'title']";

    public void fillSuiteCreationPopup(Suite suite) {
        $x(SUITE_NAME_XPATH).setValue(suite.getSuiteName());
        new Button().click(createSuiteButton);
    }
}
