package com.github.m0levich.pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public abstract class MarkAndModelPage extends BasePage {
    public static int result = 0;

    public static int getSumOnButton() {
        String textInButton = $(By.xpath("//span[@class='ButtonWithLoader__content']")).text();
        List<String> text = new ArrayList();
        for (String a : textInButton.split(" ")) {
            text.add(a);
        }

        if (text.size() > 3) {
            result = Integer.parseInt(text.get(1) + text.get(2));
        } else
            result = Integer.parseInt(text.get(1));
        return result;
    }
}
