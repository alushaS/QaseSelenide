package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    public String inputLocator = "//*[@name='%s']";
    public String projectInputLocator = "//*[@id='%s']";
    public String suiteInputLocator = "//div[contains(@class, 'toastui-editor') and contains(@aria-label, '%s')]";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear() {
        SelenideElement element = $x(String.format(inputLocator, label));
        element.click();
        element.clear();
        return this;
    }

    public Input writeToProjectCreationPopup(String text) {
        $x(String.format(projectInputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeToSuiteCreationPopup(String text) {
        $x(String.format(suiteInputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
