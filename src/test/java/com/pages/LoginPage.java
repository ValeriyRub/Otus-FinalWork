package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.utils.BasePageFactory;
import io.qameta.allure.Step;

import static com.config.ConfigurationManager.config;

public class LoginPage extends BasePage {

    @Step ("Navigate to login page")
    public LoginPage open() {
        page.navigate(config().baseUrl());
        page.waitForSelector("input.form-control[required][type='text']");
        return this;
    }

    @Step("Type login into 'Login' textbox")
    public  LoginPage typeLogin(final  String login){
        page.fill("input.form-control[required][type='text']", login);
        return this;
    }

    @Step ("Type password into 'Password' textbox")
    public LoginPage typePassword(final String password){
        page.fill("input.form-control[required][type='password']", password);
        return this;
    }

    @Step ("Error message")
    public Locator ErrorMessage(){
        return page.locator(".fade.alert.alert-danger.show");
    }


    @Step("Click on 'Login' button")
    public MyWishPage submitLogin(){
        page.locator("[type='submit']").click();
        return BasePageFactory.createInstance(page, MyWishPage.class);
    }


    @Step("Login attempt to Swag Labs")
    public MyWishPage loginAs(final String login, final String password) {
        open();
        typeLogin(login);
        typePassword(password);
        return submitLogin();
    }
}
