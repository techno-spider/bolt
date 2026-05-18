Feature: SauceDemo Login

  Scenario: Valid Login
    Given user is on login page
    When user logs in with "standard_user" and "secret_sauce"
    Then user should see inventory page