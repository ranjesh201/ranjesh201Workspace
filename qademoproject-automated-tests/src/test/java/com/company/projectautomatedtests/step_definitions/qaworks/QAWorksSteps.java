package com.company.projectautomatedtests.step_definitions.qaworks;

import com.company.projectautomatedtests.pages.HomePage;
import com.company.projectautomatedtests.step_definitions.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class QAWorksSteps extends BaseStep{

    @Autowired
    private HomePage homePage;

    @Given("^I am on the QAWorks Site$")
    public void I_am_on_the_QAWorks_Site() throws Throwable {
        homePage.go();
    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void I_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable datTable) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
