Feature: API Login

  Scenario: Verify successful login API

    When user sends login API request with "eve.holt@reqres.in" and "cityslicka"

    Then API response status should be 200