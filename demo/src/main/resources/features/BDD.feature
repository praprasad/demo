Feature: Verify the Book details from Local host

  Scenario: Check response code and Book in the response body
    When the user calls endpoint "/BookDetails"
    Then response status code is 200
    And returned string should be "Harry Potter"
    
 Scenario: Check response code and Author in the response body
    When the user calls endpoint "/BookDetails"
    Then response status code is 200
    And returned string should be "Prabhakar"
    
 Scenario: Check response code for negative Scenario
    When the user calls endpoint "/Book"
    Then response status code is 404
    