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
        myWishPage.createWishList();
    assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test")
                .info("Test2")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test")).hasText("Test");
        System.out.println("URL: " + System.getenv("url"));
        System.out.println("Username: " + System.getenv("username"));
        System.out.println("Password: " + System.getenv("password"));
        boolean existsInDB = Command.checkWishlistTitleExists("Test");
        assertTrue(existsInDB);
    }

    @Test
    public void testDeleteWish() {
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

    @Test
    public void testAddGiftNoAllAtribut() {
        myWishPage.createWishList();
        assertThat(myWishPage.getTitleAddWish()).hasText("Создать новый список желаний");
        WishInfo wishInfo = WishInfo.builder()
                .name("Test7")
                .info("Test7")
                .build();

        myWishPage.fillWishInfo(wishInfo).acceptWishList();
        assertThat(myWishPage.getTitleWish("Test7")).hasText("Test7");

        myWishPage.seeWishList("Test7");
        assertThat(myWishPage.getTitle()).hasText("Test7");
        myWishPage.addNewGift();
        GiftInfo giftInfo = GiftInfo.builder()
                .name("Привет")
                .info("Это тестовый вариант")
                .build();
        myWishPage.fillGiftInfo2(giftInfo).acceptAddNewGift();
        assertThat(myWishPage.getTitleNoAllAttribute()).hasText("Ошибка: Не удалось добавить подарок/тест");
    }
}
