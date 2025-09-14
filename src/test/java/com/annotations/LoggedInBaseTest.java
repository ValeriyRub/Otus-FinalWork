package com.annotations;

import com.pages.MyWishPage;
import com.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import static com.config.ConfigurationManager.config;

public abstract class LoggedInBaseTest extends BaseTest {

    protected MyWishPage myWishPage;

    @BeforeEach
    public void login() {
        String username = config().userLogin();
        String password = config().userPassword();
        myWishPage = loginPage.loginAs(username, password);
    }
}
