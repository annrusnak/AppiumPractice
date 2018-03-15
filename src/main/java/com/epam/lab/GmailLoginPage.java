package com.epam.lab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.DriverSettings.waitToBeClickable;


 class GmailLoginPage extends DefaultPage {


    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement enterEmailNextButton;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='passwordNext']//descendant::span")
    private WebElement enterPasswordNextButton;

    @FindBy(xpath = ".//*[@id='gbqfq']")
    private WebElement searchField;

    void enterEmail(String email) {
        enterEmailField.sendKeys(email);
    }

    void clickNextButton() {
        enterEmailNextButton.click();
    }

    void enterPassword(String password) {
        waitToBeClickable(passwordField);
        passwordField.sendKeys(password);
    }

    void clickLoginButton() {
        enterPasswordNextButton.click();

    }

}
