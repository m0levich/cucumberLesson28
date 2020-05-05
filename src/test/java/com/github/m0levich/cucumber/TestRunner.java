package com.github.m0levich.cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.m0levich.config.ConfigReader;
import com.github.m0levich.config.PropertiesConfigReader;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "com.github.m0levich.cucumber.stepdefinitions",
        tags = "(@all or @lesson28) and @example2and3")

public class TestRunner extends AbstractTestNGCucumberTests {

    private ConfigReader configReader = new PropertiesConfigReader();

    @Before
    public void initDriver() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.startMaximized = true;
        Configuration.browser = configReader.getValue("browser");
    }
}
