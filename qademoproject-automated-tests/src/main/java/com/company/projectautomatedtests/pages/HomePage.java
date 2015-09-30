package com.company.projectautomatedtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class HomePage extends AbstractPage{
    private static final String PAGE_NAME = "QA Works ";
    private static final String PATH = "";

    public HomePage() {
        super(PAGE_NAME, PATH);
    }

    public WebElement contactLink(){
        return webBot.findElement(By.linkText("Contact"));
    }
}
