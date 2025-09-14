package com.pages;

import com.components.HeadMenu;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public final class UsersPage extends BasePage {

    private HeadMenu headMenu;

    @Override
    public void initComponents(){
        headMenu = new HeadMenu(page);
    }

    @Step ("User wish")
    public UsersPage watchUserWishs(){
       page.locator("//div[contains(@class, 'card-body') and .//div[@class='card-title h5' and text()='Testrubtsov']]//a[contains(@class, 'btn') and contains(text(), 'Посмотреть списки желаний')]").click();
    return this;
    }
    @Step("Get title Gift by text")
    public Locator getTitleWish() {
        return page.locator("//h2[contains(@class, 'mb-4') and text()='Списки желаний пользователя']");
    }

}
