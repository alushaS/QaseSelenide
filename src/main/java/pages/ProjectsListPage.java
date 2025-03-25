package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Input;
import object.Project;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsListPage extends BasePage{

    public static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    public static final String PROJECT_NAME_XPATH = "//a[contains(text(), '%s')]";
    public static final String PROJECT_LIST_URL = "https://app.qase.io/projects/";

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage openProjectListPage() {
        open(PROJECT_LIST_URL);
        return this;
    }

    public String getExistProjectName(String projectName) {
            return $x(String.format(PROJECT_NAME_XPATH, projectName)).getText();
    }

    public void openProjectPage(String projectName) {
        $x(String.format(PROJECT_NAME_XPATH, projectName)).click();
    }
}
