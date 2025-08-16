Feature: Get Booking IDs
  As QA Automation Engineer
  Want to validate the GET operation with filters in the booking API
  To ensure that the service returns the information corresponding to the filters.

  Scenario Outline: Get list of booking IDs
    Given the actor wants to retrieve booking IDs with "<filter>"
    When the actor sends the request to get booking IDs
    Then the response status code should be 200
    And the booking IDs list should not be empty

    Examples:
      | filter                                 |
      |                                        |
      | firstname=Josh&lastname=Allen          |
      | checkin=2018-01-01&checkout=2019-01-01 |