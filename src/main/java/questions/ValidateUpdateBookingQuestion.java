package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUpdateBookingQuestion implements Question<Boolean> {

    private final String FirstName;

    public ValidateUpdateBookingQuestion(String firstName) {
        FirstName = firstName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String firstName = SerenityRest.lastResponse().jsonPath().getString("firstname");
        System.out.println("ESTE EL NOMBRE 2: " + firstName);
        return firstName.equals(FirstName);
    }

    public static ValidateUpdateBookingQuestion atService(String firstName) {
        return new ValidateUpdateBookingQuestion(firstName);
    }
}