package pages;

import com.codeborne.selenide.SelenideElement;
import object.TestCase;

import static com.codeborne.selenide.Selenide.$x;

public class TestCaseCreationPage extends BasePage{

    public static final SelenideElement CREATE_TEST_CASE_BUTTON = $x("//*[contains(text(), 'New test')]");
    public static final SelenideElement TEST_CASE_TITLE = $x("//*[@id='title']");
    public static final SelenideElement SAVE_TEST_CASE_BUTTON = $x("//*[@id='save-case']");
    public static final SelenideElement TEST_CASE_DESCRIPTION = $x("//*[contains(text(), 'For example: We')]/ancestor::div[@class='ProseMirror toastui-editor-contents']");
    public static final SelenideElement TEST_CASE_PRECONDITION = $x("//*[@id='application-content']/div/div[2]/form/div[1]/div[6]/div[1]/div/div/div/div/div[2]/div/div[2]/div/div");
    public static final SelenideElement TEST_CASE_POSTCONDITION = $x("//*[@id='application-content']/div/div[2]/form/div[1]/div[6]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div");
    public static final String CREATED_TEST_CASE = "//div[contains(text(), '%s')]";


    public TestCaseCreationPage(){
    }

    public TestCaseCreationPage openTestCaseCreationPage() {
        CREATE_TEST_CASE_BUTTON.click();
        return new TestCaseCreationPage();
    }

    public void fillTestCaseCreationPage(TestCase testCase) {
        TEST_CASE_TITLE.setValue(testCase.getTitle());
        TEST_CASE_DESCRIPTION.setValue(testCase.getDescription());
        TEST_CASE_PRECONDITION.setValue(testCase.getPrecondition());
        TEST_CASE_POSTCONDITION.setValue(testCase.getPostcondition());
        SAVE_TEST_CASE_BUTTON.click();
    }

    public String getExistTestCaseName(String testCase) {
        return $x(String.format(CREATED_TEST_CASE, testCase)).getText();
    }
}