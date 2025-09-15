package com.pages;

import com.microsoft.playwright.Locator;
import com.components.HeadMenu;
import com.models.GiftInfo;
import com.models.WishInfo;
import com.utils.BasePageFactory;
import io.qameta.allure.Step;


public final class MyWishPage extends BasePage {

    private HeadMenu headMenu;

    @Override
    public void initComponents(){
        headMenu = new HeadMenu(page);
    }

    @Step("Has title")
    public Locator getTitle() {
        return page.locator("h2");
    }

    @Step("Has title Wish")
    public Locator getTitleWish() {
        return page.locator("//div[contains(@class, 'card-title')]");
    }

    @Step("Create new Wishlist")
    public MyWishPage createWishList(){
        page.locator("//button[text()='Создать новый список']").click();
        return this;
    }

    @Step ("Fill wish information")
    public MyWishPage fillWishInfo(WishInfo wishInfo){
        page.fill("[type='text']", wishInfo.getName());
        page.fill("textarea.form-control", wishInfo.getInfo());
        return this;
    }

    @Step("Click on 'Exit' button from head menu")
    public MyWishPage clickOnExit(){
        headMenu.clickOnExit();
        return BasePageFactory.createInstance(page, LoginPage.class).submitLogin();
    }

    @Step("Click on 'Users' button from head menu")
    public MyWishPage clickOnUsers(){
        headMenu.clickOnUsers();
        return this;
    }

    @Step("Click on 'Head' button from head menu")
    public MyWishPage clickOnHead(){
        headMenu.clickOnText();
        return this;
    }

    @Step("Has title add wish")
    public Locator getTitleAddWish() {
        return page.locator(".modal-title.h4");
    }

    @Step("Has title add wish with no all attribute")
    public Locator getTitleNoAllAttribute() {
        return page.locator("//div[@class='mt-5 container']");
    }

    @Step("Get title Wish by text: {titleText}")
    public Locator getTitleWish(String titleText) {
        return page.locator("//div[contains(@class, 'card-title') and text()='" + titleText + "']");
    }

    @Step("Get title Gift by text")
    public Locator getTitleGift(String giftTitleText) {
        return page.locator("//div[contains(@class, 'card-title h5') and text()= '" + giftTitleText + "']");
    }

    @Step("New gift reserv status")
    public Locator giftReservStatus(String giftReservStatus){
       return page.locator("//div[contains(@class, 'card-title') and text()='" + giftReservStatus + "']/following-sibling::div//small[text()='Подарок зарезервирован']");
    }

    @Step("Accept new Wishlist")
    public MyWishPage acceptWishList(){
        page.locator("//button[text()='Создать']").click();
        return this;
    }

    @Step("Delete Wishlist")
    public MyWishPage deleteWishList(String deleteWish){
        page.locator("//div[text()='" + deleteWish +"']/ancestor::div[@class='card-body']//button[text()='Удалить']").click();
        return this;
    }

    @Step("Delete Wishlist")
    public MyWishPage deleteWList(){
        page.locator("//button[text()='Удалить список']").click();
        return this;
    }

    @Step("See Wishlist")
    public MyWishPage seeWishList(String wishlistName) {
        page.locator(String.format("//div[text()='%s']/ancestor::div[@class='card-body']//button[text()='Просмотр']", wishlistName)).click();
        return this;
    }

    @Step("Add new gift")
    public MyWishPage addNewGift(){
        page.locator("//button[text()='Добавить подарок']").click();
        return this;
    }

    @Step("New gift reserv")
    public MyWishPage giftReserv(String giftReserv){
        page.locator("//div[contains(@class, 'card-title') and text()='" + giftReserv + "']/following-sibling::div//button[text()='Зарезервировать']").click();
        return this;
    }

    @Step("Accept add new gift")
    public MyWishPage acceptAddNewGift(){
        page.locator("//button[text()='Добавить']").click();
        return this;
    }

    @Step ("Fill gift information")
    public MyWishPage fillGiftInfo(GiftInfo giftInfo){
        page.fill("//input[@type='text']", giftInfo.getName());
        page.fill("//textarea[@class='form-control' and @required]", giftInfo.getInfo());
        page.fill("//input[@placeholder='https://example.com/product']", giftInfo.getUrlMarket());
        page.fill("//input[@type='number']", String.valueOf(giftInfo.getPrice()));
        page.fill("//input[@placeholder='https://example.com/image.jpg']", giftInfo.getUrlImage());
        return this;
    }

    @Step ("Fill gift information2")
    public MyWishPage fillGiftInfo2(GiftInfo giftInfo){
        page.fill("//input[@type='text']", giftInfo.getName());
        page.fill("//textarea[@class='form-control' and @required]", giftInfo.getInfo());
        return this;
    }
}
