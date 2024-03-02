package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static tasks.CreateBookingTask.*;
import static utils.Environment.*;

public class DeleteBookingTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(httpGetBooking + responseBookingId));
        actor.attemptsTo(Delete.from("")
                .with(requestSpecification -> requestSpecification
                        .header("Content-Type","application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")));
    }

    public static DeleteBookingTask atService() {
        return Tasks.instrumented(DeleteBookingTask.class);
    }
}