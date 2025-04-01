package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import object.TestCase;
import pages.TestCaseCreationPage;

@Data
@AllArgsConstructor
public class TestCaseSteps extends BaseSteps{

    public TestCaseSteps() {
        this.testCaseCreationPage = new TestCaseCreationPage();
    }

    TestCaseCreationPage testCaseCreationPage;

    @Step ("Create test case step")
    public void createTestCaseStep(TestCase testCase) {
        testCaseCreationPage.openTestCaseCreationPage()
                            .fillTestCaseCreationPage(testCase);
    }

}
