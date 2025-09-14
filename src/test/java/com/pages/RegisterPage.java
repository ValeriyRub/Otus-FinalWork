package com.pages;

import com.models.RegistrationInfo;
import com.models.WishInfo;
import io.qameta.allure.Step;

import static com.config.ConfigurationManager.config;

public class RegisterPage extends BasePage{

    @Step("Navigate to register page")
    public RegisterPage open() {
        page.navigate(config().registerUrl());
        return this;
    }

    @Step ("Fill user information")
    public RegisterPage fillUserInfo(RegistrationInfo registrationInfo){
        page.fill("[type='text']", registrationInfo.getName());
        page.fill("[type='email']", registrationInfo.getEmail());
        page.fill("[type='password']", registrationInfo.getPassword());
        return this;
    }

    @Step ("Registration button")
    public RegisterPage regisrationButton(){
        page.locator("//button[text()='Зарегистрироваться']").click();
        return this;
    }

    @Step ("Registration page")
    public RegisterPage regisrationPage(){
        page.locator("[href='/register']").click();
        return this;
    }

}
