Feature: Verify the Book details from Local host

  Scenario: Check response code and Book in the response body
    When the user calls endpoint "/BookDetails"
    Then response status code is 200
    And returned string should be "Harry Potter"
    
 Scenario: Check response code and Author in the response body
    When the user calls endpoint "/BookDetails"
    Then response status code is 200
    And returned string should be "Prabhakar"
    
 Scenario: Check response code and Price
    When the user calls endpoint "/BookDetails"
    Then response status code is 200
    And returned string should be "$1"
    
 Scenario: Check response code and Price
    When the user calls endpoint "/BookDetails"
    Then returned string should not contain "Lord of the Ring"
    