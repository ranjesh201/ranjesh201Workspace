package com.company.projectautomatedtests.pages.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@Component
public class WebDriverFactory {
    static Logger log = LoggerFactory.getLogger(WebDriverFactory.class);

    private WebDriver driver;


    public synchronized WebDriver getDriver(){
        return getDriver(null);
    }
    public synchronized void resetDriver(){
        driver=null;
    }

    public synchronized WebDriver getDriver(String url){
        if(driver == null){
            driver=createFireFoxDriver();

            if(url != null){
                driver.get(url);
            }
        }
        return driver;
    }

    private ChromeDriver createChromeDriver(){
        log.debug("Creating Chrome Driver...");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private FirefoxDriver createFireFoxDriver(){
        log.debug("Creating FireFox Driver...");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @PreDestroy
    public void quit(){
        if(driver !=null){
            driver.quit();
        }
    }

    public boolean isOpen() {
        return driver != null;
    }
}
