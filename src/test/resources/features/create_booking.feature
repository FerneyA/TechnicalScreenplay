Feature: POST booking API
  As QA Automation Engineer
  Want to validate the POST operation in the booking API
  To ensure that the service works correctly with valid and invalid data.

  Scenario: Create booking successfully with JSON format
    When I send a POST request to create a booking with valid data in JSON format
    Then the response status code should be 200
    And the response should contain "bookingid" type numeric

  Scenario: Create booking successfully with XML format
    When I send a POST request to create a booking with valid data in XML format
    Then the response status code should be 200