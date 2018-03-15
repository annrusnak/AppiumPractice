package com.epam.lab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


 class GmailHomePage extends DefaultPage {
    @FindBy(xpath = ".//*[@class='M j T b hc Zm  Ke']")
    private WebElement composeLetterButton;

    @FindBy(xpath = "//*[@id='composeto']")
    private WebElement recipientInputField;

    @FindBy(xpath = ".//input[@class='tn']")
    private WebElement subjectInputField;

    @FindBy(xpath = ".//*[@class='qn']")
    private WebElement emailBodyTextField;

    @FindBy(xpath = ".//*[@class='M j T b hc en Ee']")
    private WebElement sendEmailButton;

    @FindBy(xpath = ".//*[@class='V j zd']")
    private WebElement openMenuButton;

    @FindBy(xpath = ".//*[@id='mn_']/div[2]/div/div[1]/div[8]")
    private WebElement openSendedMailsButton;

    @FindBy(xpath = ".//*[@class='V j cb cm']")
    private WebElement checkBox;

    @FindBy(xpath = ".//*[@class='V j Vd']")
    private WebElement deleteButton;

    @FindBy(xpath = ".//*[@class='yt']")
    private WebElement isDeletedMessageIsShown;

    @FindBy(xpath = "//div[@class='km']")
    private WebElement noNewMessagesItem;

     void waitTillPageIsLoading() {
        DriverSettings.waitToBeClickable(composeLetterButton);
    }

     void clickComposeButton() {
        composeLetterButton.click();
    }

     void enterRecipientEmail(String email) {
        recipientInputField.sendKeys(email);
    }

     void enterSubject(String subject) {
        subjectInputField.sendKeys(subject);
    }

     void enterEmailBodyText(String body) {
        emailBodyTextField.sendKeys(body);
    }

     void clickSendEmailButton() {
        sendEmailButton.click();
    }

     String getCurrentUrl() {
        return DriverSettings.getDriver().getCurrentUrl();
    }

     void openMenu() {
        DriverSettings.waitToBeClickable(openMenuButton);
        openMenuButton.click();
    }

     void openSendedMails() {
        DriverSettings.waitToBeClickable(openSendedMailsButton);
        openSendedMailsButton.click();
    }

     void selectEmail() {
        DriverSettings.waitToBeClickable(checkBox);
        checkBox.click();
    }

     void deleteEmail() {
        DriverSettings.waitToBeClickable(deleteButton);
        deleteButton.click();
    }

     Boolean noMessagesInSendedFolder() {
        return noNewMessagesItem.isDisplayed();
    }

}
