package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;
    private By options = By.xpath("//ul[@class='myaccount-link-list']/li");
    //By Locators


    //2.Construtor
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }


    //3.Page Actions
    public int getAccountOptionsCount(){
        return driver.findElements(options).size();

    }

    public  String getTitles() {
        return driver.getTitle();
    }
    public List<String> getAccountsLists(){
        List<String> list = new ArrayList<>();
       List<WebElement> option =driver.findElements(options);
       for(WebElement opt:option){
           String k=opt.getText();
           list.add(k.toUpperCase());
       }
       return list;

    }




}
