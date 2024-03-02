Feature: Update booking

  @updateBooking
  Scenario Outline: Update booking
    Given i create and enter the token <Fila>
      | Ruta Excel                        | Pestana       |
      | src/test/resources/data/data.xlsx | updateBooking |
    When i enter the data in the service body
    When i update the data of the created books
    Then the correct updating of the book data is validated

    Examples:
      | Fila |
      | 1    |
      | 2    |