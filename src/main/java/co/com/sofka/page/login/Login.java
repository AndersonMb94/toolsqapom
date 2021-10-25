package co.com.sofka.page.login;

import co.com.sofka.model.practiceform.LoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Login extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(Login.class);
    private LoginModel loginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    private final By userName = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By submit = By.id("btnLogin");
    private final By welcome = By.id("welcome");

    //For Assertions test case.
    private final By assertionwelcome = By.id("welcome");


    public Login(WebDriver driver, LoginModel loginModel) {
        super(driver);
        this.loginModel = loginModel;
    }

    public Login (WebDriver driver, LoginModel loginModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);

        if(loginModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.loginModel = loginModel;

    }

    //Page functions.
    public void startLogin() throws IOException {
        clear(userName);
        typeInto(userName, loginModel.getUserName());

        clear(password);
        typeInto(password, loginModel.getPassword());

        doSubmit(submit);
    }

    public String isRegistrationDone() {
         return getText(assertionwelcome).trim();
    }

}
