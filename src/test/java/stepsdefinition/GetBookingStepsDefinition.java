package stepsdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ValidateGetBookingQuestion;
import tasks.GetBookingTask;
import static stepsdefinition.CreateBookingStepsDefinition.data;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetBookingStepsDefinition {

    @When("i consult the created books")
    public void i_consult_the_created_books() {
        withCurrentActor(GetBookingTask.atService());
    }

    @Then("the correct query creation of the books is validated")
    public void the_correct_query_creation_of_the_books_is_validated() {
        theActorInTheSpotlight().should(seeThatResponse("Validar que sea exitosa", response -> response
                .statusCode(Integer.parseInt(data.get("Status")))));
        theActorInTheSpotlight().should(seeThat(ValidateGetBookingQuestion.atService(data.get("Firstname"))));
    }
}