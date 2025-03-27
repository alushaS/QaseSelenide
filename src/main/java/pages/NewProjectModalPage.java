package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import object.Project;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalPage extends BasePage{

    public NewProjectModalPage() {
    }

    public SelenideElement createProjectButton =  $x("//*[@type='submit']");

    public void createNewProject(Project project) {
        new Input("project-name").writeToProjectCreationPopup(project.getName());
        new Input("project-code").writeToProjectCreationPopup(project.getProjectCode());
        new Input("description-area").writeToProjectCreationPopup(project.getDescription());
        new Button().click(createProjectButton);
    }
}
