package com.github.m0levich.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "com.github.m0levich.cucumber.stepdefinitions",
        tags = "(@all or @lesson28) and @example1")

public class TestRunner extends AbstractTestNGCucumberTests {
}
