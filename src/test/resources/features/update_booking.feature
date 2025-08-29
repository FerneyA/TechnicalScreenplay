Feature: PUT booking API
  As QA Automation Engineer
  Want to validate the PUT operation in the booking API
  To ensure that the service works correctly with valid and invalid data.

  @Regression
  Scenario: Update booking successfully
    Given that there is a booking in the system
    And a user with a valid token
    When I send a PUT request to update a booking with valid data
    Then the response status code should be 200

  Scenario: Update booking with invalid token
    Given that there is a booking in the system
    When I send a PUT request with invalid authentication
    Then the response status code should be 403
