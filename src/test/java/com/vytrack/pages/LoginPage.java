package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    @FindBy(id = "prependedInput")
    private WebElement username;
//    public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"));

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    // this constructor is not needed if LoginPage is extending BasePage class
//    public LoginPage() {
//        //to connect our webdriver, page class and page factory
//        //PageFactory - used to use @FindBy annotations
//        //PageFactory - helps to find elements easier
//        PageFactory.initElements(Driver.getDriver(), this);
//    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        BrowserUtilities.waitForPageToLoad(2);
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * this method stands for login based on user type
     * for example : if parameter is equals to driver , user log in as a driver
     * If role parameter is not correct, method throws exception
     * @param role - driver, sales manager or store manager
     */
    public void login(String role){
        String username = "";
        if (role.equalsIgnoreCase("driver")){
            username="user15";
        }else if (role.equalsIgnoreCase("sales manager")){
            username="salesmanager110";
        }else if (role.equalsIgnoreCase("store manager")){
            username="storemanager85";
        }else {
            throw  new RuntimeException("Invalid role!");
        }
        System.out.println("Login as "+role);
        login(username,"UserUser123");
    }
}
