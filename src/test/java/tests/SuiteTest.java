package tests;

import object.Project;
import object.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static pages.ProjectPage.*;

public class SuiteTest extends BaseTest{

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
        suiteSteps.openSuiteCreationPopup(projectPage, project);
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
        suiteSteps.deleteSuiteStep(projectPage, project);
        Assert.assertEquals($x("//*[contains(text(), 'Looks like you don’t have any suites and cases yet.')]").getText(), "Looks like you don’t have any suites and cases yet.");
    }
}

