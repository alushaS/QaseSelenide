package tests;

import com.codeborne.selenide.SelenideElement;
import object.Project;
import object.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class TestCaseTest extends BaseTest{

    public static final SelenideElement CREATE_TEST_CASE_BUTTON = $x("//*[contains(text(), 'New test')]");
    public static final SelenideElement TEST_CASE_TITLE = $x("//*[@id='title']");
    public static final SelenideElement SAVE_TEST_CASE_BUTTON = $x("//*[@id='save-case']");

    @Test
    public void createTestCaseTest() {
        Project project = new Project();
        project.setName("Project1");   TestCase testCase = new TestCase();
        testCase.setTitle("Test Case Example");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openProjectPage(project.getName());
        button.click(CREATE_TEST_CASE_BUTTON);
        TEST_CASE_TITLE.setValue(testCase.getTitle());
        button.click(SAVE_TEST_CASE_BUTTON);
        Assert.assertEquals($x("//div[contains(text(), 'Test Case Example')]").getText(), testCase.getTitle());
    }
}
