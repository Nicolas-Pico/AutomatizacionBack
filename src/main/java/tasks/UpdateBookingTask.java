package tasks;

import bodies.BookingdatesDto;
import bodies.CreateBookingDto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.*;
import static tasks.CreateBookingTask.*;
import static tasks.TokenTask.*;
import static utils.Environment.*;

public class UpdateBookingTask implements Task {

    private final String firstname;
    private final String lastname;
    private final String totalprice;
    private final String depositpaid;
    private final String checkin;
    private final String checkout;
    private final String additionalneeds;

    public UpdateBookingTask(String firstname, String lastname, String totalprice, String depositpaid, String checkin,
                             String checkout, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalneeds = additionalneeds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingdatesDto bookingdatesDto = new BookingdatesDto();
        bookingdatesDto.setCheckin(checkin);
        bookingdatesDto.setCheckout(checkout);

        CreateBookingDto createBookingDto = new CreateBookingDto();
        createBookingDto.setFirstname(firstname);
        createBookingDto.setLastname(lastname);
        createBookingDto.setTotalprice(Integer.parseInt(totalprice));
        createBookingDto.setDepositpaid(Boolean.parseBoolean(depositpaid));
        createBookingDto.setBookingdates(bookingdatesDto);
        createBookingDto.setAdditionalneeds(additionalneeds);

        actor.whoCan(CallAnApi.at(httpGetBooking + responseBookingId));
        actor.attemptsTo(Put.to("")
                .with(request -> request
                        .header("Content-Type","application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(createBookingDto)));
    }

    public static UpdateBookingTask atService(String firstname, String lastname, String totalprice, String depositpaid,
                                              String checkin, String checkout, String additionalneeds) {
        return instrumented(UpdateBookingTask.class, firstname, lastname, totalprice, depositpaid, checkin, checkout,
                additionalneeds);
    }
}