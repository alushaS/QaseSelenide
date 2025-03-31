package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import object.Project;
import pages.NewProjectModalPage;
import pages.ProjectsListPage;

@Data
@AllArgsConstructor
public class ProjectSteps extends BaseSteps{

    Project project;
    NewProjectModalPage newProjectModalPage;
    ProjectsListPage projectsListPage;

    public ProjectSteps() {
        this.project = new Project();
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectsListPage = new ProjectsListPage();
    }

    @Step ("Create new project step")
    public void createNewProjectSteps(Project project) {
        projectsListPage.isOpened()
                        .openProjectCreationPopup();
        newProjectModalPage.createNewProject(project);
    }

    @Step ("Open project list step")
    public void openProjectListStep() {
        projectsListPage.openProjectListPage();
    }

    @Step ("Remove project step")
    public void removeProject() {
        projectsListPage.removeProject();
    }

    @Step ("Open project {string}")
    public void openProjectStep(Project project) {
        projectsListPage.openProjectPage(project.getName());
    }
}
