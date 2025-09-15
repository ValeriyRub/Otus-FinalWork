package com.tests;

import com.annotations.LoggedInBaseTest;
import com.pages.MyWishPage;
import com.pages.RegisterPage;
import com.pages.UsersPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UsersTest extends LoggedInBaseTest {

    @Test
    public void watchUserWishes() {

        myWishPage.clickOnUsers();

        UsersPage usersPage = createInstance(UsersPage.class);
        usersPage.watchUserWishs();

        assertThat(usersPage.getTitleWish()).hasText("Списки желаний пользователя");
    }
}