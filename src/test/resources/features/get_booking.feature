Feature: Obtain information about a booking
  As QA Automation Engineer
  Want to validate the GET operation in the booking API
  To ensure that the service brings the correct information associated with a booking.

  Scenario: Get booking in format JSON
    Given that there is a booking in the system
    And the actor queries the bookingId in 'application/json' format
    Then the actor must view the booking information at JSON

  Scenario: Get booking in format XML
    Given that there is a booking in the system
    Given the actor queries the bookingId in 'application/xml' format
    Then the actor must view the booking information at XML