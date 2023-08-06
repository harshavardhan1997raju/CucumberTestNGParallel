package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //1.By Locators
    private WebDriver driver;
    //By Locators
    private By email = By.xpath("//input[@id='email']");
    private By pwd = By.xpath("//input[@id='passwd']");
    private By submitBtn = By.xpath(" //button[@id='SubmitLogin']");

    private By forgotPWDLink=By.xpath("//a[@title='Recover your forgotten password']");

  //2.Construtor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //3.Page Actions
    public String getLoginPageTitle(){
        return driver.getTitle();

    }

    public boolean forgotPwdExist(){
        return driver.findElement(forgotPWDLink).isDisplayed();

    }

    public void enterUserName(String username){
         driver.findElement(email).sendKeys(username);

    }
    public void enterPwd(String pwds){
        driver.findElement(pwd).sendKeys(pwds);

    }

    public void clickSubmit(){
        driver.findElement(submitBtn).click();

    }

    public AccountsPage doLogin(String usName, String pwds){
        driver.findElement(email).sendKeys(usName);
        driver.findElement(pwd).sendKeys(pwds);
        driver.findElement(submitBtn).click();
        return new AccountsPage(driver);
    }


}
