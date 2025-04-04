package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import object.Project;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsListPage extends BasePage{

    public static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    public static final String PROJECT_NAME_XPATH = "//a[contains(text(), '%s')]";
    public static final String PROJECT_LIST_URL = "https://app.qase.io/projects/";
    public static final SelenideElement PROJECT_REMOVE_BUTTON = $x("//*[@data-testid='remove']");
    public static final SelenideElement PROJECT_CONTEXT_MENU_BUTTON = $x("//table//a[contains(text(), 'Project1')]//ancestor::tbody//span[@class='qc0jO1']");
    public static final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[contains(text(), 'Delete project')]");
    public static final SelenideElement NO_PROJECTS_XPATH = $x("//*[@class = 'wf6Aof']");

    Button button = new Button();

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage openProjectListPage() {
        open(PROJECT_LIST_URL);
        return this;
    }

    public Project openProjectCreationPopup() {
        CREATE_NEW_PROJECT.click();
        return new Project();
    }

    public ProjectsListPage removeProject() {
        button.click(PROJECT_CONTEXT_MENU_BUTTON);
        button.click(PROJECT_REMOVE_BUTTON);
        button.click(DELETE_PROJECT_BUTTON);
        return new ProjectsListPage();
    }

    public String getExistProjectName(String projectName) {
            return $x(String.format(PROJECT_NAME_XPATH, projectName)).getText();
    }

    public void openProjectPage(String projectName) {
        $x(String.format(PROJECT_NAME_XPATH, projectName)).click();
    }
}
