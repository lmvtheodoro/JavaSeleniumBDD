package Steps;

import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

//Selenium Behavior Driven-Development Example
//Author: Lucas Magnani Vikar Theodoro
public class LoginSteps {

    LoginPage login = new LoginPage();

    @Given("user is at the Login Page")
    public void userIsAtTheLoginPage() {
        login.userOpenLoginScreen();
    }

    @When("user has valid credentials: {string} and {string} and is logged in")
    public void userIsAtTheUserPage(String username, String password) {
        login.userCanSeeLoginFields();
        login.insertUsername(username);
        login.insertPassword(password);
    }

    @And("user can observe login fields and login button")
    public void userIsAbleToSeeUsernameAndPasswordTextboxes() {
        login.userCanSeeLoginFields();
    }

    @When("the user inserts a {string} into the username textbox")
    public void userInsertsAnUsername(String username) {
        login.insertUsername(username);
    }

    @And("the user inserts a {string} into the password textbox")
    public void userInsertsAPassword(String password) {
        login.insertPassword(password);
    }

    @And("the user clicks on LOGIN button")
    public void userClicksOnLoginButton() {
        login.clickOnLogin();
    }

    @When("user clicks on REMEMBER ME button")
    public void userClicksOnRememberMeButton(){
        login.clickOnRememberMe();
    }
    @Then("the system remembers that user is still logged in")
    public void theSystemRemembersThatUserIsStillLoggedIn() {
        login.checkRememberMeMessage();
    }
    @Then("the user should navigate to Users Page")
    public void userShouldNavigateToUsersPage() {
        login.checkUserPage();
    }

    @Then("system displays an error message indicating incorrect credentials")
    public void systemDisplaysAnErrorMessageIndicatingIncorrectCredentials() {
        login.checkIncorrectLogin();
    }

    @Then("the system reminds the user to fill in the required Name field")
    public void theSystemRemindsTheUserToFillInTheRequiredNameField() {
        login.checkNoNameInsertedOnLogin();
    }

    @Then("the system reminds the user to fill in the required Password field")
    public void theSystemRemindsTheUserToFillInTheRequiredPasswordField() {
        login.checkNoPasswordInsertedOnLogin();
    }

    @And("the user hover on PROFILE icon")
    public void theUserHoverOnProfileIcon() {
        login.mouseHoverOnProfile();
    }

    @And("the user clicks on LOGOUT button")
    public void theUserClicksOnLOGOUTButton() {
        login.clickOnLogOut();
    }

    @Then("the user should navigate to Confirmation Page")
    public void theUserShouldNavigateToConfirmationPage() {
        login.checkConfirmationPage();
    }

    @And("click on LOGOUT CONFIRMATION button")
    public void clickOnLogoutConfirmationButton() {
        login.clickOnLogoutConfirmationButton();
    }

    @And("the user should navigate to Home Page")
    public void theUserShouldNavigateToHomePage() {
        login.checkHomePage();
    }

    @And("user clicks on FORGOT YOUR PASSWORD button")
    public void userClicksOnFORGOTYOURPASSWORDButton() {
        login.clickOnForgotPassword();
    }

    @And("user navigate to lost password page")
    public void userCanObserveLostPasswordFields() {
        login.userCanSeeLostPasswordFields();
    }

    @And("user insert valid credential: {string}")
    public void userInsertValidCredential(String user) {
        login.userInsertValidUserOnLostPasswordInput(user);
    }

    @And("user clicks on GET NEW PASSWORD")
    public void userClicksOnGetNewPasswordButton() {
        login.userClicksOnLostPasswordButton();
    }

    @Then("the system displays a recover password message")
    public void theSystemDisplaysARecoverPasswordMessage() {
        login.checkResetPasswordMessage();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //Code an action that your testing automation would take if a specific scenario has just failed.
            String scenarioThatFailed = scenario.getName();
        }
    }
    @After(order = 1)
    public void tearDown() {
        login.closeBrowser();
    }
}