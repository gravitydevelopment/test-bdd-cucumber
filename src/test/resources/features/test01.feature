Feature: Verify Google.com
  To access google.com and verify elements

  Scenario: Access google.com
    Given Open browser
    When Access website "http://www.google.com"
    Then Verify google.com banner
    And Do google search with text "hello google"
    And Close browser


