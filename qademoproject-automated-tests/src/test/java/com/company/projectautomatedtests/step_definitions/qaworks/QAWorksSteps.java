package com.company.projectautomatedtests.step_definitions.qaworks;

import com.company.projectautomatedtests.pages.ContactPage;
import com.company.projectautomatedtests.pages.HomePage;
import com.company.projectautomatedtests.step_definitions.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import static org.junit.Assert.*;


public class QAWorksSteps extends BaseStep{

    @Autowired
    private HomePage homePage;

    @Autowired
    private ContactPage contactPage;

    @Given("^I am on the QAWorks Site$")
    public void I_am_on_the_QAWorks_Site() throws Throwable {
        homePage.go();
    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void I_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable dataTable) throws Throwable {
        homePage.contactLink().click();
        contactQAWorks(dataTable);
        String test =contactPage.nameTextfield().getText();
        assertTrue("Unable to contact QAworks", contactPage.nameTextfield().getAttribute("value").isEmpty());

    }

    @Then("^I should be NOT be able to contact QAWorks with the following information$")
    public void I_should_be_NOT_be_able_to_contact_QAWorks_with_the_following_information(DataTable dataTable) throws Throwable {
        homePage.contactLink().click();
        contactQAWorks(dataTable);
        assertFalse("Able to contact QAworks with invalid email address", contactPage.emailTextfield().isDisplayed());
    }

    private void contactQAWorks(DataTable dataTable){
        String textValue;
        for (Map.Entry<String, String> entry:dataTable.asMap(String.class, String.class).entrySet()){
            WebElement target=null;
            if(entry.getKey().equals("name")) {
                target=contactPage.nameTextfield() ;
            }else if(entry.getKey().equals("email")){
                target=contactPage.emailTextfield() ;
            }else if(entry.getKey().equals("message")){
                target=contactPage.messageTextfield() ;
            }
            target.clear();

            target.sendKeys(entry.getValue());

        }
         contactPage.sendButton().click();
    }


}
