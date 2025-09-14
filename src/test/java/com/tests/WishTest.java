package com.tests;

import com.annotations.LoggedInBaseTest;
import com.models.GiftInfo;
import com.models.WishInfo;
import com.pages.MyWishPage;
import com.sqlcommand.Command;
import org.junit.jupiter.api.Test;
import com.sqlcommand.Command;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WishTest extends LoggedInBaseTest {

    @Test
    public void testAddWish() {
        //MyWishPage myWishPage = loginPage.loginAs("Testrubtsov", "Testrubtsov");

        myWishPage.createWishList();
    assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test")
                .info("Test2")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test")).hasText("Test");

        boolean existsInDB = Command.checkWishlistTitleExists("Test");
        assertTrue(existsInDB);
    }

    @Test
    public void testDeleteWish() {
        MyWishPage myWishPage = loginPage.loginAs("Testrubtsov", "Testrubtsov");

        myWishPage.createWishList();
        assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test1")
                .info("Test2")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test1")).hasText("Test1");
        myWishPage.deleteWishList("Test1");
        assertThat(myWishPage.getTitleWish("Test1")).isHidden();
    }

    @Test
    public void testDeletGift() {
        MyWishPage myWishPage = loginPage.loginAs("Testrubtsov", "Testrubtsov");

        myWishPage.createWishList();
        assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test3")
                .info("Test3")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test3")).hasText("Test3");

        myWishPage.seeWishList("Test3");
        assertThat(myWishPage.getTitle()).hasText("Test3");
        myWishPage.addNewGift();
        GiftInfo giftInfo = GiftInfo.builder()
                .name("Привет")
                .info("Это тестовый вариант")
                .urlMarket("https://exampl.com/")
                .price(100)
                .urlImage("https://exampl.com/")
                .build();
        myWishPage.fillGiftInfo(giftInfo).acceptAddNewGift();
        assertThat(myWishPage.getTitleGift("Привет")).hasText("Привет");
        myWishPage.deleteWList().clickOnHead();
        assertThat(myWishPage.getTitleWish("Test3")).isHidden();
    }

    @Test
    public void testAddTwoGift() {
        MyWishPage myWishPage = loginPage.loginAs("Testrubtsov", "Testrubtsov");

        myWishPage.createWishList();
        assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test4")
                .info("Test4")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test4")).hasText("Test4");

        myWishPage.seeWishList("Test4");
        assertThat(myWishPage.getTitle()).hasText("Test4");
        myWishPage.addNewGift();
        GiftInfo giftInfo = GiftInfo.builder()
                .name("Привет1")
                .info("Это тестовый вариант")
                .urlMarket("https://exampl.com/")
                .price(200)
                .urlImage("https://exampl.com/")
                .build();
        myWishPage.fillGiftInfo(giftInfo).acceptAddNewGift();
        assertThat(myWishPage.getTitleGift("Привет1")).hasText("Привет1");

        myWishPage.addNewGift();
        GiftInfo giftInfo1 = GiftInfo.builder()
                .name("Привет2")
                .info("Это тестовый вариант2")
                .urlMarket("https://exampl.com/")
                .price(100)
                .urlImage("https://exampl.com/")
                .build();
        myWishPage.fillGiftInfo(giftInfo1).acceptAddNewGift();
        assertThat(myWishPage.getTitleGift("Привет2")).hasText("Привет2");
    }

    @Test
    public void testGiftReserv() {
        MyWishPage myWishPage = loginPage.loginAs("Testrubtsov", "Testrubtsov");

        myWishPage.createWishList();
        assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test5")
                .info("Test5")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test5")).hasText("Test5");

        myWishPage.seeWishList("Test5");
        assertThat(myWishPage.getTitle()).hasText("Test5");
        myWishPage.addNewGift();
        GiftInfo giftInfo = GiftInfo.builder()
                .name("Привет4")
                .info("Это тестовый вариант")
                .urlMarket("https://exampl.com/")
                .price(100)
                .urlImage("https://exampl.com/")
                .build();
        myWishPage.fillGiftInfo(giftInfo).acceptAddNewGift();
        assertThat(myWishPage.getTitleGift("Привет4")).hasText("Привет4");
        myWishPage.giftReserv("Привет4");
        assertThat(myWishPage.giftReservStatus("Привет4")).hasText("Подарок зарезервирован");
    }
}
