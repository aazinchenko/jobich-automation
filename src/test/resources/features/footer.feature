Feature: Footer links on the home page
  As a visitor
  I want the footer links to be visible
  So that I can reach legal info, contacts and social channels

  Background:
    Given I open the Jobich home page
  Scenario Outline: Footer link is visible
    Then the footer "<link>" link is visible

    Examples:
      | link           |
      | Privacy Policy |
      | Terms of Use   |
      | LinkedIn       |
      | Imprint        |
      | Email          |
      | Feedback       |