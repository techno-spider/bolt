Feature: Add to Cart

  Scenario: Add product to cart
    Given user is logged in
    When user adds product to cart
    Then cart count should be "1"