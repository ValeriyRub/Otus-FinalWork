package com.tests;

import com.models.RegistrationInfo;
import com.models.WishInfo;
import com.pages.MyWishPage;
import com.pages.RegisterPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterTest extends BaseTest{


    public void registrationUser() {
        RegisterPage registerPage = createInstance(RegisterPage.class);

        RegistrationInfo registrationInfo = RegistrationInfo.builder()
                .name("Testrubtsov23")
                .email("Testrubtsov23@test.test")
                .password("Testrubtsov23")
                .build();

        registerPage.open().fillUserInfo(registrationInfo).regisrationButton();

    }

}
