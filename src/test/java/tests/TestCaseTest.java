package tests;

import object.Project;
import object.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest{ ;

    @Test
    public void createTestCaseTest() {
        Project project = new Project();
        project.setName("Project1");   TestCase testCase = new TestCase();
        testCase.setTitle("Test Case Example");
        testCase.setDescription("Description of the test case");
        testCase.setPrecondition("Precondition of the test case");
        testCase.setPostcondition("Postcondition of the test case");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectSteps.openProjectStep(project);
        testCaseSteps.createTestCaseStep(testCase);
        Assert.assertEquals(testCaseCreationPage.getExistTestCaseName(testCase.getTitle()), testCase.getTitle());
    }
}
