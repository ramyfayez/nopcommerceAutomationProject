@smoke
Feature: F07_followUs | users could open followUs links
#1
  Scenario: user opens facebook link
    Given user opens "facebook" link
    When user can display new tab
    And user can switch between two tabs
    Then "https://www.facebook.com/nopCommerce" is opened in new tab
#2
  Scenario: user opens twitter link
    Given user opens "twitter" link
    When user can display new tab
    And user can switch between two tabs
    Then "https://twitter.com/nopCommerce" is opened in new tab
#3
#  #actual result is https://demo.nopcommerce.com/news/rss/1
#  #however expected result should be https://demo.nopcommerce.com/new-online-store-is-open
  Scenario: user opens rss link
    Given user opens "rss" link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab
#4
  Scenario: user opens youtube link
    Given user opens "youtube" link
    When user can display new tab
    And user can switch between two tabs
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab
