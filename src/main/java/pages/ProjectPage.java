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
    public static final String CREATED_SUITE_XPATH = "//h3[contains(text(), '%s')]";
    public static final String CREATED_SUITE_WITH_PLUS_BUTTON = "//h3[contains(text(), '%s')]";
    public static final SelenideElement NO_SUITS_XPATH = $x("//*[contains(text(), 'Looks like you don’t have any suites and cases yet.')]");

    public ProjectPage() {
    }

    public ProjectPage isOpened() {
        ADD_SUITE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public NewSuiteModalPage openSuitePopupWithPlusButton(Project project) {
        CREATE_SUITE_OR_CASE_BUTTON.click();
        CREATE_SUITE_BUTTON.click();
        return new NewSuiteModalPage();
    }

    public NewSuiteModalPage addSuite() {
        ADD_SUITE_BUTTON.click();
        return new NewSuiteModalPage();
    }

    public ProjectPage deleteSuite(Project project) {
        DELETE_SUITE_BUTTON.click();
        DELETE_SUITE_POPUP_BUTTON.click();
        return this;
    }

    public String getExistSuiteName(String suiteName) {
        return $x(String.format(CREATED_SUITE_XPATH, suiteName)).getText();
    }

    public String getExistSuiteNameCreatedWithPlusButton(String suiteName) {
        return $x(String.format(CREATED_SUITE_WITH_PLUS_BUTTON, suiteName)).getText();
    }

    public String getExistSuiteAfterDeletion() {
        return NO_SUITS_XPATH.getText();
    }

}
