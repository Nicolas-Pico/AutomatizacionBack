Feature: Create booking

  @createBooking
  Scenario Outline: Create booking
    Given i create and enter the token <Fila>
      | Ruta Excel                        | Pestana       |
      | src/test/resources/data/data.xlsx | createBooking |
    When i enter the data in the service body
    Then the correct creation of the books is validated

    Examples:
      | Fila |
      | 1    |
      | 2    |