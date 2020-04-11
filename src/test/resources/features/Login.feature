Feature: Login
  As user, I want ot be able login with username and password
    # agile story


  # Test Method = Test Case = Scenario
  # Test + DataProvider = Scenario Outline + Example table
  Scenario: Login as sales manager and verify that title is Dashboard
    Given user is on the landing page
    When user logs is as a sale manager
    Then user should verify that title is a Dashboard


