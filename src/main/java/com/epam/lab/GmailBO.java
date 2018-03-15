package com.epam.lab;

 class GmailBO {
    private GmailLoginPage gmailLoginPage;
    private GmailHomePage gmailHomePage;
    private static String URL="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    GmailBO() {
        gmailLoginPage = new GmailLoginPage();
        gmailHomePage = new GmailHomePage();
    }

     void open() {
        DriverSettings.getDriver().get(URL);
    }

     void login(String email, String pass) {
        gmailLoginPage.enterEmail(email);
        gmailLoginPage.clickNextButton();
        gmailLoginPage.enterPassword(pass);
        gmailLoginPage.clickLoginButton();
        gmailHomePage.waitTillPageIsLoading();
    }

     void sendEmail(String email, String subject, String body) {
        gmailHomePage.clickComposeButton();
        gmailHomePage.enterRecipientEmail(email);
        gmailHomePage.enterSubject(subject);
        gmailHomePage.enterEmailBodyText(body);
        gmailHomePage.clickSendEmailButton();
    }

     String getCurrentUrl() {
        return gmailHomePage.getCurrentUrl();
    }

     void deleteSendedEmail() {
        gmailHomePage.openMenu();
        gmailHomePage.openSendedMails();
        gmailHomePage.selectEmail();
        gmailHomePage.deleteEmail();

    }

    Boolean verifyNoMessages() {
        return gmailHomePage.noMessagesInSendedFolder();
    }
}
