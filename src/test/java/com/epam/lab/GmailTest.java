package com.epam.lab;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailTest {
    private GmailBO gmailBO;
    private static String URL = "https://mail.google.com/mail/mu/mp/849/#tl/priority/%5Esmartlabel_personal";

    @BeforeTest
    public void before() {
        gmailBO = new GmailBO();
    }

    @Parameters({"loginEmail", "password", "sendToEmail", "subject", "body"})
    @Test
    public void gmailTest(String loginEmail, String password, String sendTo, String subject, String body) {
        gmailBO.open();
        gmailBO.login(loginEmail, password);
        gmailBO.sendEmail(sendTo, subject, body);
        Assert.assertEquals(URL, gmailBO.getCurrentUrl());
        gmailBO.deleteSendedEmail();
        Assert.assertTrue(gmailBO.verifyNoMessages());
    }

    @AfterTest
    public void tearDown() {
        DriverSettings.close();
    }
}
