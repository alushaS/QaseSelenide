package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import object.Project;
import object.Suite;
import pages.NewSuiteModalPage;
import pages.ProjectPage;

@Data
@AllArgsConstructor
public class SuiteSteps extends BaseSteps{

    Suite suite;
    ProjectPage projectPage;
    NewSuiteModalPage newSuiteModalPage;

    public SuiteSteps() {
        this.suite = new Suite();
        this.newSuiteModalPage = new NewSuiteModalPage();
        this.projectPage = new ProjectPage();
    }

    @Step("Open suite creation popup step")
    public void openSuiteCreationPopup(ProjectPage projectPage, Project project){
        projectPage
                .isOpened()
                .openSuitePopupWithPlusButton(project);
    }

    @Step ("Create suite step")
    public void createSuiteStep(Suite suite, Project project) {
        projectPage.openSuitePopupWithPlusButton(project);
        newSuiteModalPage.fillSuiteCreationPopup(suite);

    }

    @Step ("Create suite with plus button step")
    public void addSuiteStep(Suite suite) {
        projectPage.addSuite()
                   .fillSuiteCreationPopup(suite);

    }

    @Step("Delete suite step")
    public void deleteSuiteStep(ProjectPage projectPage, Project project) {
        projectPage.isOpened()
                   .deleteSuite(project);
    }
}
