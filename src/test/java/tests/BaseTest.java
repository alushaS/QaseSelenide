package tests;

import com.codeborne.selenide.Configuration;
import elements.Button;
import object.Project;
import object.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import steps.TestCaseSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    protected LoginSteps loginSteps;
    protected ProjectsListPage projectsListPage;
    protected ProjectPage projectPage;
    protected NewProjectModalPage newProjectModalPage;
    protected Project project;
    protected Button button;
    protected NewSuiteModalPage newSuiteModalPage;
    protected Suite suite;
    protected SuiteSteps suiteSteps;
    protected ProjectSteps projectSteps;
    protected TestCaseCreationPage testCaseCreationPage;
    protected TestCaseSteps testCaseSteps;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");

    
    public void initPages(){
        loginSteps = new LoginSteps();
        projectsListPage = new ProjectsListPage();
        projectPage = new ProjectPage();
        newProjectModalPage = new NewProjectModalPage();
        project = new Project();
        button = new Button();
        newSuiteModalPage = new NewSuiteModalPage();
        suite = new Suite();
        suiteSteps = new SuiteSteps();
        projectSteps = new ProjectSteps();
        testCaseCreationPage = new TestCaseCreationPage();
        testCaseSteps = new TestCaseSteps();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

//    @AfterMethod
//    public void endTest() {
//        getWebDriver().quit();
//    }
}
