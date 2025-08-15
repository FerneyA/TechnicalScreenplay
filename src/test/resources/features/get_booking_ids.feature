Feature: Booking - Get Booking IDs

  @get_booking_ids
  Scenario Outline: Get list of booking IDs
    Given the actor wants to retrieve booking IDs with "<filter>"
    When the actor sends the request to get booking IDs
    Then the response status code should be 200
    And the booking IDs list should not be empty

    Examples:
      | filter                        |
      |                               |
      | firstname=Josh&lastname=Allen |