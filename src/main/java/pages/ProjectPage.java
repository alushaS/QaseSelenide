package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import object.Project;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage{

    public static final SelenideElement ADD_SUITE_BUTTON = $x("//*[@id = 'create-suite-button']");
    public static final SelenideElement CREATE_SUITE_OR_CASE_BUTTON = $x("//*[@aria-label = 'Create suite or case']");
    public static final SelenideElement CREATE_SUITE_BUTTON = $x("//*[contains(text(), 'Create suite')]");
    public static final SelenideElement DELETE_SUITE_BUTTON = $x("//*[@aria-label = 'Delete suite']");
    public static final SelenideElement DELETE_SUITE_POPUP_BUTTON = $x("//*[@type = 'submit']");

    public ProjectPage() {
    }

    public ProjectPage isOpened() {
        ADD_SUITE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage openSuitePopup(Project project) {
        CREATE_SUITE_OR_CASE_BUTTON.click();
        CREATE_SUITE_BUTTON.click();
        return this;
    }

    public ProjectPage deleteSuite(Project project) {
        DELETE_SUITE_BUTTON.click();
        DELETE_SUITE_POPUP_BUTTON.click();
        return this;
    }
}
