Feature: Booking API CRUD Tests
  Como QA Automation Engineer
  Quiero validar las operaciones POST, PUT, PATCH y DELETE en la API de Booking
  Para asegurar que el servicio funciona correctamente con datos válidos e inválidos

  # POST
#  Scenario: Create booking successfully
#    When I send a POST request to create a booking with valid data
#    Then the response status code should be 200
#    And the response should contain "bookingid" type numeric
#
#  Scenario: Create booking with missing required fields
#    When I send a POST request to create a booking with missing data
#    Then the response status code should be 400
#
#  Scenario: Create booking with invalid data types
#    When I send a POST request to create a booking with invalid data types
#    Then the response status code should be 400

#  # PUT
#  Scenario: Update booking successfully
#    Given a user with a valid token
#    When I send a PUT request to update a booking with valid data
#    Then the response status code should be 200
#
#  Scenario: Update booking with invalid token
#    When I send a PUT request with invalid authentication
#    Then the response status code should be 403

  # PATCH
  Scenario: Partially update booking successfully in XML format
    When I send a PATCH request in XML format to update booking firstname
    Then the response status code should be 200

  Scenario: Partially update booking successfully in JSON format
    Given a user with a valid token
    When I send a PATCH request in JSON format to update booking firstname
    Then the response status code should be 200


  # DELETE
  Scenario: Delete booking successfully in JSON format
    Given a user with a valid token
    When I send a DELETE request for a booking in JSON format
    Then the response status code should be 201

  Scenario: Delete booking successfully in XML format
    When I send a DELETE request for a booking in XML format
    Then the response status code should be 201
