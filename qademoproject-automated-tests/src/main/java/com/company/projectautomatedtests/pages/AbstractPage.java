package com.company.projectautomatedtests.pages;

import com.company.projectautomatedtests.pages.driver.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import static org.junit.Assert.fail;


public abstract class AbstractPage implements IPage{
    protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    protected String pageName;
    protected  String path;

    @Autowired
    protected WebDriverUtil webBot;

    public AbstractPage(String pageName, String path) {
        this.pageName = pageName;
        this.path = path;
    }

    @PostConstruct
    private void init(){

    }


    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public void go(){
           webBot.goToPage(this);
    }

    public String getBaseUrl(){
        return webBot.getBaseUrl();
    }

    public String getTitle(){
        return webBot.getTitle();
    }

    public String getPageName() {
        return pageName;
    }





}
