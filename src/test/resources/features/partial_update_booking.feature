Feature: PATCH booking API
  As QA Automation Engineer
  Want to validate the PATCH operation in the booking API
  To ensure that the service works correctly with valid and invalid data.

  Scenario: Partially update booking successfully in XML format
    Given that there is a booking in the system
    When I send a PATCH request in XML format to update booking firstname
    Then the response status code should be 200

  Scenario: Partially update booking successfully in JSON format
    Given that there is a booking in the system
    And a user with a valid token
    When I send a PATCH request in JSON format to update booking firstname
    Then the response status code should be 200