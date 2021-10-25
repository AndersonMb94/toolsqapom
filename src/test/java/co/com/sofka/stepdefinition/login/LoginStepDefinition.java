package co.com.sofka.stepdefinition.login;

import co.com.sofka.model.practiceform.LoginModel;
import co.com.sofka.page.login.Login;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class LoginStepDefinition extends WebUI implements En {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);
    private LoginModel loginModel;
    private Login login;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Las credenciales ingresadas no coinciden con el titular de la cuenta.";

    @Given("el usuario esta en el recurso adecuado y con el usuario y la contraseña")
    public void elUsuarioEstaEnElRecursoAdecuadoYConElUsuarioYLaContrasena() {
        try{
            generalSetUpOrange();
            dataConfiguration();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("cuando el usuario presiona el boton login")
    public void cuandoElUsuarioPresionaElBotonLogin() {
        try {
            login = new Login(driver, loginModel);
            login.startLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }

    @Then("el sistema permitira loguear al usuario de manera exitosa dirigiendolo hacia el home de la pagina")
    public void elSistemaPermitiraLoguearAlUsuarioDeManeraExitosaDirigiendoloHaciaElHomeDeLaPagina() {
        try {
            Assertions.assertEquals(
                    expected(),
                    login.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
        quitDriver();
    }


    //Funciones comunes:
    private void dataConfiguration(){
        loginModel = new LoginModel();
        loginModel.setUserName("Admin");
        loginModel.setPassword("admin123");
    }

    private String expected(){
        String expectedResult = "Welcome Paul";
        return expectedResult.trim();

    }

}
