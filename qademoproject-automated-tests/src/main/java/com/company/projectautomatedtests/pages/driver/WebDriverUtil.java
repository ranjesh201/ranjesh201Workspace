package com.company.projectautomatedtests.pages.driver;

import com.company.projectautomatedtests.pages.IPage;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.fail;


@Component
//@Scope("prototype")
@Scope("cucumber-glue")
public final class WebDriverUtil {
    protected static final Logger logger = LoggerFactory.getLogger(WebDriverUtil.class);
    private static final int DRIVER_WAIT = 60;
    IPage currentPage;

    /**
     * Factory to provide the required webdriver implementation (Chrome, Firefox)
     */
    @Autowired
    private WebDriverFactory webDriverFactory;


    @Value("${baseUrl}")
    private String baseUrl;



    public String getBaseUrl() {
        return baseUrl;
    }


    public WebDriver getDriver() {

        return webDriverFactory.getDriver();
    }


    public void quit() {
        if (webDriverFactory.isOpen()) {
            webDriverFactory.quit();
        }
    }

    public String getTitle() {
        return getDriver().getTitle();
    }


    public void goToPage(IPage page) {
        this.currentPage = page;
        String url = page.getPath();
        if(url.trim().isEmpty()){
            logger.debug("Loading only Base URL: " + url);
            getDriver().get(getBaseUrl());
        } else {
            logger.debug("Loading BaseURL + page path: " + getBaseUrl()+url);
            getDriver().get(getBaseUrl() + url);
        }

    }






    public WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public WebElement waitForExpectedElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DRIVER_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForExpectedElements(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DRIVER_WAIT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExpectedElement(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> waitForExpectedElements(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean exists(WebElement element, By selector){
        List<WebElement> found = null;
        if (element != null)
            found = element.findElements(selector);
        else
            found = getDriver().findElements(selector);
        if (found == null || found.size() == 0)
            return false;
        return true;
    }
}
