package com.github.m0levich.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MarkPage extends MarkAndModelPage {

    public static int countModelAuto = 0;

    public static void saveCount(String model){
        String selector = String.format("//a[.='%s']/following-sibling::div[@class='ListingPopularMMM-module__itemCount']", model);
        countModelAuto = Integer.parseInt($(By.xpath(selector)).text());
    }

    public static void goToPageModel(String model){
        String selector = String.format("//a[.='%s']", model);
        $(By.xpath(selector)).click();
    }
}
