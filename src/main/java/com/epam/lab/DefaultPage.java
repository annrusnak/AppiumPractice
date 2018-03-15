package com.epam.lab;

import org.openqa.selenium.support.PageFactory;

class DefaultPage {

    DefaultPage( ) {
        PageFactory.initElements(DriverSettings.getDriver(), this);

    }

}