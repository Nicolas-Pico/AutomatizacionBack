Feature: Delete booking

  @deleteBooking
  Scenario Outline: Delete booking
    Given i create and enter the token <Fila>
      | Ruta Excel                        | Pestana       |
      | src/test/resources/data/data.xlsx | deleteBooking |
    When i enter the data in the service body
    When i delete the data of the created books
    Then the correct disposal of the books is validated

    Examples:
      | Fila |
      | 1    |
      | 2    |