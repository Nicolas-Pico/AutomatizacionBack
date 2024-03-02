package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateGetBookingQuestion implements Question<Boolean> {

    private final String vFirstName;

    public ValidateGetBookingQuestion(String vFirstName) {
        this.vFirstName = vFirstName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String firstNameR = SerenityRest.lastResponse().jsonPath().getString("firstname");
        System.out.println("ESTE EL NOMBRE R: " + firstNameR);
        return firstNameR.equals(vFirstName);
    }

    public static ValidateGetBookingQuestion atService(String vFirstName) {
        return new ValidateGetBookingQuestion(vFirstName);
    }
}