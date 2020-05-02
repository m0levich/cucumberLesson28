package com.github.m0levich.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{

    public static int countMarkAuto = 0;

    public static void saveCount(String mark){
        String selector = String.format("//div[@class='IndexMarks__col']/descendant::div[.='%s']/following-sibling::div[@class='IndexMarks__item-count']", mark);
        countMarkAuto = Integer.parseInt($(By.xpath(selector)).text());
    }

    public static void goToPageMark(String mark){
        closeCookie();
        String selector = String.format("//div[@class='IndexMarks__col']/descendant::div[.='%s']", mark);
        $(By.xpath(selector)).click();
    }

    public static void closeCookie() {
        SelenideElement buttonForCloseModal = $(By.xpath("//span[.='Понятно, спасибо']"));
        if (buttonForCloseModal.isDisplayed()) {
            buttonForCloseModal.doubleClick();
        }
    }
}

