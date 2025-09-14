package com.components;

import com.microsoft.playwright.Page;

public final class HeadMenu extends BaseComponent {

    public HeadMenu(final Page page) {
        super(page);
    }

    public void clickOnText() {
        page.click(".navbar-brand");
    }

    public void clickOnMyList() {
        page.click("[href='/wishlists']");
    }

    public void clickOnUsers() {
        page.click("[href='/users']");
    }

    public void clickOnExit() {
        page.click("[role='button']");
    }
}

