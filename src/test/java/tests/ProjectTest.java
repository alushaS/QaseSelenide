package tests;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import object.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectTest extends BaseTest {

    public static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    public static final SelenideElement PROJECT_REMOVE_BUTTON = $x("//*[@data-testid='remove']");
    public static final SelenideElement PROJECT_CONTEXT_MENU_BUTTON = $x("//table//a[contains(text(), 'Project1')]//ancestor::tbody//span[@class='qc0jO1']");
    public static final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[contains(text(), 'Delete project')]");
    public static final SelenideElement NO_PROJECTS_XPATH = $x("//*[@class = 'wf6Aof']");


    @Test
    public void createProjectTest() {
        Project project = new Project();
        project.setName("Project1");
        project.setProjectCode("PR1");
        project.setDescription("Description of the project");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        button.click(CREATE_NEW_PROJECT);
        newProjectModalPage.createNewProject(project);
        projectsListPage.openProjectListPage();
        Assert.assertEquals(projectsListPage.getExistProjectName(project.getName()), project.getName());
    }

    @Test
    public void removeProjectTest() {
        Project project = new Project();
        project.setName("Project1");
        project.setProjectCode("PR1");
        project.setDescription("Description of the project");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        button.click(PROJECT_CONTEXT_MENU_BUTTON);
        button.click(PROJECT_REMOVE_BUTTON);
        button.click(DELETE_PROJECT_BUTTON);
        Assert.assertEquals(NO_PROJECTS_XPATH.getText(), "Looks like you don’t have any projects yet.");
    }
}
