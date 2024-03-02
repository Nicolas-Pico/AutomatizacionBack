package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateDeleteBookingQuestion implements Question<Boolean> {

    private final String dato;

    public ValidateDeleteBookingQuestion(String dato) {
        this.dato = dato;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().print().equals(dato);
    }

    public static ValidateDeleteBookingQuestion atService(String dato) {
        return new ValidateDeleteBookingQuestion(dato);
    }
}