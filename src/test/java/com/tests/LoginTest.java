package com.tests;

import com.pages.MyWishPage;
import org.junit.jupiter.api.Test;


import static com.config.ConfigurationManager.config;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testInCorrectCredentials(){
        loginPage.loginAs("WrongUser", "WrongPass");
        assertThat(loginPage.ErrorMessage()).hasText("Неверное имя пользователя или пароль");
    }

    @Test
    public void testCorrectLoginCredentials(){
        MyWishPage myWishPage = loginPage.loginAs(config().userLogin(), config().userPassword());
        assertThat(page).hasURL("https://wishlist.otus.kartushin.su/wishlists");
    }

    @Test
    public void testCorrectLogout(){
        MyWishPage myWishPage = loginPage.loginAs(config().userLogin(), config().userPassword());
        myWishPage.clickOnExit();
        assertThat(page).hasURL("https://wishlist.otus.kartushin.su/login");
    }
}

