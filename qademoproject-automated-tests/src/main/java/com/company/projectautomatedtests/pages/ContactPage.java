package com.company.projectautomatedtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
public class ContactPage extends AbstractPage{
    private static final String PAGE_NAME = "Contact";
    private static final String PATH = "contact.aspx";

    public ContactPage() {
        super(PAGE_NAME, PATH);
    }

    public WebElement nameTextfield(){
        return webBot.findElement(By.id("ctl00_MainContent_NameBox"));
    }

    public WebElement emailTextfield(){
        return webBot.findElement(By.id("ctl00_MainContent_EmailBox"));
    }

    public WebElement messageTextfield(){
        return webBot.findElement(By.id("ctl00_MainContent_MessageBox"));
    }

    public WebElement sendButton(){
        return webBot.findElement(By.id("ctl00_MainContent_SendButton"));
    }
}
