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
        projectSteps.createNewProjectSteps(project);
        projectSteps.openProjectListStep();
        Assert.assertEquals(projectsListPage.getExistProjectName(project.getName()), project.getName());
    }

    @Test
    public void removeProjectTest() {
        Project project = new Project();
        project.setName("Project1");
        project.setProjectCode("PR1");
        project.setDescription("Description of the project");
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectSteps.removeProject();
        Assert.assertEquals(NO_PROJECTS_XPATH.getText(), "Looks like you don’t have any projects yet.");
    }
}
