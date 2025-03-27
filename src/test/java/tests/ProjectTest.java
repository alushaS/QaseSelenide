package tests;

import object.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ProjectsListPage.*;

public class ProjectTest extends BaseTest {

    @Test
    public void createProjectTest() {
        Project project = new Project();
        project.setName("Project1");
        project.setProjectCode("PR1");
        project.setDescription("Description of the project");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        button.click(CREATE_NEW_PROJECT);
        newProjectModalPage.createNewProject(project);
        projectsListPage.openProjectListPage();
        Assert.assertEquals(projectsListPage.getExistProjectName(project.getName()), project.getName());
    }

    @Test
    public void removeProjectTest() {
        Project project = new Project();
        project.setName("Project1");
        project.setProjectCode("PR1");
        project.setDescription("Description of the project");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        button.click(PROJECT_CONTEXT_MENU_BUTTON);
        button.click(PROJECT_REMOVE_BUTTON);
        button.click(DELETE_PROJECT_BUTTON);
        Assert.assertEquals(NO_PROJECTS_XPATH.getText(), "Looks like you don’t have any projects yet.");
    }
}
