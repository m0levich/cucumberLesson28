package com.github.m0levich.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MarkPage extends MarkAndModelPage {

    private static int countModelAuto = 0;

    public static int getCountModelAuto() {
        return countModelAuto;
    }

    public static void saveCount(String model){
        countModelAuto = 0;
        String selector = String.format("//a[.='%s']/following-sibling::div[@class='ListingPopularMMM-module__itemCount']", model);
        countModelAuto = Integer.parseInt($(By.xpath(selector)).text());
    }

    public static void goToPageModel(String model){
        String selector = String.format("//a[.='%s']", model);
        $(By.xpath(selector)).click();
    }
}
