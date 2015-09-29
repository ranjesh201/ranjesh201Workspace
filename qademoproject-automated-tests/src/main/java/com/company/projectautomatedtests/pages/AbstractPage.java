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



    /*
   Waits for a specific element to be visible for up to 10 seconds
    */
    public void waitForElementToBeVisible(String cssSelector) throws Throwable{
        // Fail fast if the element doesn't exist
        if (!webBot.exists(null, By.cssSelector(cssSelector))) {
            fail("Could not determine if element is visible as it does not exist: " + cssSelector);
        }

        logger.info("Waiting for element to appear "+cssSelector);
        for(int i = 0; i <= 40 ; i++) {
            // find it each time to prevent selenium reference going stale
            WebElement e = webBot.findElement(By.cssSelector(cssSelector));
            if (e.isDisplayed()) {
                logger.info("Element is visible");
                return;
            } else {
                Thread.sleep(250);
            }
            System.out.print(".");
        }
        fail("Element did not become visible: "+cssSelector);
    }

}
