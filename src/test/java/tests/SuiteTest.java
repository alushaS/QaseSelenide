package tests;

import object.Project;
import object.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest{

    @Test
    public void createSuiteTest() {
        Project project = new Project();
        Suite suite = new Suite();
        suite.setSuiteName("Suite_example_test");
        project.setName("Project1");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectSteps.openProjectStep(project);
        suiteSteps.addSuiteStep(suite);
        Assert.assertEquals(projectPage.getExistSuiteName(suite.getSuiteName()), suite.getSuiteName());
    }

    @Test
    public void createSuiteWithPlusButtonTest() {
        Project project = new Project();
        Suite suite = new Suite();
        suite.setSuiteName("Suite_example_plus_button");
        project.setName("Project1");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectSteps.openProjectStep(project);
        suiteSteps.createSuiteStep(suite, project);
        Assert.assertEquals(projectPage.getExistSuiteNameCreatedWithPlusButton(suite.getSuiteName()), suite.getSuiteName());
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
        Assert.assertEquals(projectPage.getExistSuiteAfterDeletion(), "Looks like you don’t have any suites and cases yet.");
    }
}

