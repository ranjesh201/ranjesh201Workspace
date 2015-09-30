package com.company.projectautomatedtests.step_definitions;

import com.company.projectautomatedtests.pages.driver.WebDriverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public abstract class BaseStep {


    @Autowired
    protected WebDriverUtil webBot;
}
