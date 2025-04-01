package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import pages.LoginPage;

@Data
@AllArgsConstructor
public class LoginSteps extends BaseSteps {

    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Login by user: {email}")
    public void login(String email, String password, String url) {
        loginPage
                .openLoginPage(url)
                .login(email, password)
                .isOpened();
    }
}
