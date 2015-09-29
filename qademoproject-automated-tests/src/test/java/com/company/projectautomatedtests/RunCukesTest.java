package com.company.projectautomatedtests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-reports", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        tags = {"~@wip"},
        glue = {"com.company.projectautomatedtests.step_definitions"},
        monochrome = true,
        dryRun = false,
        snippets = SnippetType.CAMELCASE
)
public class RunCukesTest {
}
