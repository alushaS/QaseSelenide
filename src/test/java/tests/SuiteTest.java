package tests;

import com.codeborne.selenide.SelenideElement;
import object.Project;
import object.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class SuiteTest extends BaseTest{

    public static final SelenideElement ADD_SUITE_BUTTON = $x("//*[@id = 'create-suite-button']");
    public static final SelenideElement CREATE_SUITE_OR_CASE_BUTTON = $x("//*[@aria-label = 'Create suite or case']");
    public static final SelenideElement CREATE_SUITE_BUTTON = $x("//*[contains(text(), 'Create suite')]");
    public static final SelenideElement DELETE_SUITE_BUTTON = $x("//*[@aria-label = 'Delete suite']");
    public static final SelenideElement DELETE_SUITE_POPUP_BUTTON = $x("//*[@type = 'submit']");


    @Test
    public void createSuiteTest() {
        Project project = new Project();
        Suite suite = new Suite();
        suite.setSuiteName("Suite_example_test");
        project.setName("Project1");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openProjectPage(project.getName());
        button.click(ADD_SUITE_BUTTON);
        newSuiteModalPage.fillSuiteCreationPopup(suite);
        Assert.assertEquals($x("//h3[contains(text(), 'Suite_example_test')]").getText(), suite.getSuiteName());
    }

    @Test
    public void createSuiteWithPlusButtonTest() {
        Project project = new Project();
        Suite suite = new Suite();
        suite.setSuiteName("Suite_example_plus_button");
        project.setName("Project1");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openProjectPage(project.getName());
        button.click(CREATE_SUITE_OR_CASE_BUTTON);
        button.click(CREATE_SUITE_BUTTON);
        newSuiteModalPage.fillSuiteCreationPopup(suite);
        Assert.assertEquals($x("//h3[contains(text(), 'Suite_example_plus_button')]").getText(), suite.getSuiteName());
    }

    @Test
    public void deleteSuiteTest() {
        Project project = new Project();
        Suite suite = new Suite();
        suite.setSuiteName("Suite_example_test");
        project.setName("Project1");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openProjectPage(project.getName());
        button.click(DELETE_SUITE_BUTTON);
        button.click(DELETE_SUITE_POPUP_BUTTON);
        Assert.assertEquals($x("//*[contains(text(), 'Looks like you don’t have any suites and cases yet.')]").getText(), "Looks like you don’t have any suites and cases yet.");
    }
}

