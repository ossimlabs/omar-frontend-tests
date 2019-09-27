@pki
Feature: O2_PKI

    Scenario: Start Selenium
      Given I am starting the omar pki ui selenium server

    Scenario: Start browser
      Given I am creating the omar pki browser

    Scenario: Missing PKI
      Given that I try to enter the omar pki home page using Firefox
      When I attempt to log in without a pki
      Then it does not let me into omar

    Scenario: Stop Selenium
      Given I am stopping the selenium server