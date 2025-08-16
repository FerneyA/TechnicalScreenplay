Feature: DELETE booking API
  As QA Automation Engineer
  Want to validate the DELETE operation in the booking API
  To ensure that the service works correctly with valid and invalid data.

  Scenario: Delete booking successfully in JSON format
    Given that there is a booking in the system
    And a user with a valid token
    When I send a DELETE request for a booking in JSON format
    Then the response status code should be 201

  Scenario: Delete booking successfully in XML format
    Given that there is a booking in the system
    When I send a DELETE request for a booking in XML format
    Then the response status code should be 201
