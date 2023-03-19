package PageObjects;

import Util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Selenium Behavior Driven-Development Example
//Author: Lucas Magnani Vikar Theodoro
public class LoginPage {

    private final WebDriver driver;
    WebDriverWait wait;

    /* PageFactory & Extra Configs*/
    public LoginPage() {
        /*Edge Configs - No Need To Download Drivers*/
        /*Change the methods to other drivers if needed*/
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Utils.getMaxWaitTime());
        PageFactory.initElements(driver, this);
    }

  /* WebElements - Locators */
    @FindBy(name = "text-1")
    WebElement inputNameOrEmail;

    @FindBy(name = "password-1")
    WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"forminator-module-17221\"]/div[5]/div/div/button")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='checkbox-1']/div/label/span")
    WebElement rememberMeButton;

    @FindBy(xpath = "/html/body/main/div/div[1]/div/div/section/div[2]/div/div[2]/div/div/div[2]/div/div")
    WebElement rememberMeMessage;

    @FindBy(xpath = "/html/body/div[1]/div/header/div/div/div[3]/div/div/section/div/div/div/div/div/div/div/div[1]/div/span/b/a")
    WebElement profileIcon;

    @FindBy(xpath = "/html/body/div[1]/div/header/div/div/div[3]/div/div/section/div/div/div/div/div/div/div/div[1]/div/div/b/a[4]")
    WebElement logoutButton;

    @FindBy(xpath = "/html/body/div/p[2]/a")
    WebElement logoutConfirmationButton;

    @FindBy(xpath = "/html/body/main/div/div[1]/div/div/section/div[2]/div/div[2]/div/div/div[2]/div/div/form/div[1]/label")
    WebElement incorrectLogin;

    @FindBy(xpath = "/html/body/main/div/div[1]/div/div/section/div[2]/div/div[2]/div/div/div[2]/div/div/form/div[2]/div/div/span")
    WebElement noNameInserted;

    @FindBy(css = ".forminator-error-message")
    WebElement noPasswordInserted;

    /* Background Methods */
    public void userOpenLoginScreen(){
        driver.get("https://osagilistas.com/login/");
    }
    public void userCanSeeLoginFields(){
        wait.until(ExpectedConditions.visibilityOf(inputNameOrEmail));
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    /* User Interactions Methods */
    public void insertUsername(String username){
        inputNameOrEmail.sendKeys(username);
    }

    public void insertPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public void clickOnRememberMe(){
        rememberMeButton.click();
    }
    public void checkRememberMeMessage(){
        wait.until(ExpectedConditions.visibilityOf(rememberMeMessage));
        String expected = "Você já está logado.";
        Assert.assertEquals(expected, rememberMeMessage.getText());
    }
    public void clickOnLogOut(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
    public void clickOnLogoutConfirmationButton(){
        logoutConfirmationButton.click();
    }
    public void checkHomePage(){
        Assert.assertEquals("https://osagilistas.com/", driver.getCurrentUrl());
    }
    public void checkConfirmationPage(){
        Assert.assertEquals("https://osagilistas.com/wp-login.php?action=logout", driver.getCurrentUrl());
    }
    public void checkUserPage() {
        Assert.assertEquals("https://osagilistas.com/meu-perfil/", driver.getCurrentUrl());
    }
    public void checkIncorrectLogin(){
        wait.until(ExpectedConditions.visibilityOf(incorrectLogin));
        String expected = "ERROR: The username or password you entered is incorrect. Lost your password?";
        Assert.assertEquals(expected, incorrectLogin.getText());
    }
    public void checkNoNameInsertedOnLogin(){
        wait.until(ExpectedConditions.visibilityOf(noNameInserted));
        String expected = "Este campo é obrigatório. Por favor, preencha com um texto";
        Assert.assertEquals(expected, noNameInserted.getText());
    }
    public void checkNoPasswordInsertedOnLogin(){
        wait.until(ExpectedConditions.visibilityOf(noPasswordInserted));
        String expected = "sua senha é necessária";
        Assert.assertEquals(expected, noPasswordInserted.getText());
    }
    public void mouseHoverOnProfile(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(profileIcon));
        actions.moveToElement(profileIcon).perform();
    }
    public void closeBrowser(){
        driver.quit();
    }
}