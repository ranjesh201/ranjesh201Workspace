Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services


  Scenario:  Valid Submission
    When I am on the QAWorks Site
    Then I should be able to contact QAWorks with the following information
      | name          | j.Bloggs|
      | email       | j.Bloggs@qaworks.com|
      | message        |please contact me I want to find out more |


  Scenario:  InValid Submission
    When I am on the QAWorks Site
    Then I should be NOT be able to contact QAWorks with the following information
      | name          | j.Bloggs|
      | email       | j.Bloggsqawork|
      | message        |please contact me I want to find out more |