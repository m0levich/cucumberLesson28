package com.github.m0levich.cucumber.stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.m0levich.config.ConfigReader;
import com.github.m0levich.config.PropertiesConfigReader;
import com.github.m0levich.pages.MainPage;
import com.github.m0levich.pages.MarkPage;
import com.github.m0levich.pages.ModelPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class AutoRu {

    @Когда("перейти {string}")
    public void goToPage(String string) {
        open(string);
    }

    @Тогда("заголовок содержит {string}")
    public void namePageCheck(String string) {
        Assert.assertTrue(title().contains(string),"Wrong title");
    }

    @Тогда("^сохранить количество объявлений, отображаемых после названия автомобиля ([^\"]*)$")
    public void saveCountMark(String mark) {
        MainPage.saveCount(mark);
    }

    @Тогда("^перейти на страницу ([^\"]*) автомобилей$")
    public void goToMark(String mark) {
        MainPage.goToPageMark(mark);
    }

    @То("отображается кнопка с текстом, содержащим количество объявлений как и сохраненного ранее количества")
    public void checkCountOnTheButtonMark() {
        Assert.assertEquals(MarkPage.getSumOnButton(), MainPage.countMarkAuto,"Wrong amount in button");
    }

    @То("^сохранить количество объявлений конкретной ([^\"]*) автомобиля$")
    public void saveCountModel(String model) {
        MarkPage.saveCount(model);
    }

    @То("^переход на страницу ([^\"]*)$")
    public void goToModel(String model) {
        MarkPage.goToPageModel(model);
    }

    @Тогда("отображается кнопка с текстом, содержащим количество объявлений по определенной модели")
    public void checkCountOnTheButtonModel() {
        Assert.assertEquals(ModelPage.getSumOnButton(), MarkPage.countModelAuto,"Wrong model amount in button");
    }
}
