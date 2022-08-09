@smoke
Feature: F08_Wishlist | users could add product on Wishlist
#1
  Scenario: user add product on wishlist
    Given user click on wishlist button
    Then user can get successfully message

#2
  Scenario: user open wishlist page
    Given user click on wishlist button
    Then user can get successfully message
    And user open wishlist page
    Then user can check the product Qty
