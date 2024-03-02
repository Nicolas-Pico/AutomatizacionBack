package tasks;

import bodies.BookingdatesDto;
import bodies.CreateBookingDto;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.*;
import static tasks.TokenTask.*;
import static utils.Environment.*;

public class CreateBookingTask implements Task {

    private final String firstname;
    private final String lastname;
    private final String totalprice;
    private final String depositpaid;
    private final String checkin;
    private final String checkout;
    private final String additionalneeds;
    public static String responseBookingId;

    public CreateBookingTask(String firstname, String lastname, String totalprice, String depositpaid, String checkin,
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

        actor.whoCan(CallAnApi.at(httpCreateBooking));
        actor.attemptsTo(Post.to("")
                .with(request -> request
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(createBookingDto)));

        responseBookingId = String.valueOf(SerenityRest.lastResponse().jsonPath().getString("bookingid"));
        System.out.println("ESTE ES EL ID: " + responseBookingId);
    }

    public static CreateBookingTask atService(String firstname, String lastname, String totalprice, String depositpaid,
                                              String checkin, String checkout, String additionalneeds) {
        return instrumented(CreateBookingTask.class, firstname, lastname, totalprice, depositpaid, checkin, checkout,
                additionalneeds);
    }
}