package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static tasks.CreateBookingTask.*;
import static tasks.TokenTask.*;
import static utils.Environment.*;

public class GetBookingTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(httpGetBooking + responseBookingId));
        actor.attemptsTo(Get.resource("")
                .with(requestSpecification -> requestSpecification
                        .header("Content-Type","application/json")
                        .header("Authorization", "Bearer " + token)));
    }

    public static GetBookingTask atService() {
        return Tasks.instrumented(GetBookingTask.class);
    }
}