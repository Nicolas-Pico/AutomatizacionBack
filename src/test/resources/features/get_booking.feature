Feature: Get booking

  @getBooking
  Scenario Outline: Get booking
    Given i create and enter the token <Fila>
      | Ruta Excel                        | Pestana    |
      | src/test/resources/data/data.xlsx | getBooking |
    When i enter the data in the service body
    When i consult the created books
    Then the correct query creation of the books is validated

    Examples:
      | Fila |
      | 1    |
      | 2    |