package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCreationBookingQuestion implements Question<Boolean> {

    private final String firstName;

    public ValidateCreationBookingQuestion(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String responseFirstName = SerenityRest.lastResponse().jsonPath().getString("booking.firstname");
        System.out.println("ESTE EL NOMBRE: " + responseFirstName);
        return responseFirstName.equals(firstName);
    }

    public static ValidateCreationBookingQuestion atService(String firstName) {
        return new ValidateCreationBookingQuestion(firstName);
    }
}