@video_vrails
Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  # Scenario: Start selenium
  #   Given I am starting the yup ui selenium server

  Scenario: Start browsers
    Given I am creating the chrome browser
    Given that I am starting at the video-vrails homepage using chrome

  Scenario: Click button
    Given I have clicked the menu button while the menu is NOT displayed
    Then The menu should be displayed
