package stepsdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ValidateGetBookingQuestion;
import questions.ValidateUpdateBookingQuestion;
import tasks.UpdateBookingTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static stepsdefinition.CreateBookingStepsDefinition.data;

public class UpdateBookingStepsDefinition {

    @When("i update the data of the created books")
    public void i_update_the_data_of_the_created_books() {
        withCurrentActor(UpdateBookingTask.atService(data.get("Firstname"), data.get("Lastname"),
                data.get("Totalprice"), data.get("Depositpaid"), data.get("Checkin"), data.get("Checkout"),
                data.get("Additionalneeds")));
    }

    @Then("the correct updating of the book data is validated")
    public void the_correct_updating_of_the_book_data_is_validated() {
        theActorInTheSpotlight().should(seeThatResponse("Validar que sea exitosa", response -> response
                .statusCode(Integer.parseInt(data.get("Status")))));
        theActorInTheSpotlight().should(seeThat(ValidateUpdateBookingQuestion.atService(data.get("Firstname"))));
    }
}