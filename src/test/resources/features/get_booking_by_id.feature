Feature: Obtener información de una reserva

  Scenario: Get reservation in format JSON
    Given the actor queries the booking with id '268' in 'application/json' format
    Then the actor must view the booking information at JSON

  Scenario: Get reservation in format XML
    Given the actor queries the booking with id '268' in 'application/xml' format
    Then the actor must view the booking information at XML