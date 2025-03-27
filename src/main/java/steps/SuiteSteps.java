package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import object.Project;
import object.Suite;
import pages.ProjectPage;

@Data
@AllArgsConstructor
public class SuiteSteps extends BaseSteps{

    Suite suite;

    public SuiteSteps() {
        this.suite = new Suite();
    }

    @Step("Open suite creation popup step")
    public void openSuiteCreationPopup(ProjectPage projectPage, Project project){
        projectPage
                .isOpened()
                .openSuitePopup(project);
    }

    @Step("Delete suite step")
    public void deleteSuiteStep(ProjectPage projectPage, Project project) {
        projectPage.isOpened()
                   .deleteSuite(project);
    }
}
