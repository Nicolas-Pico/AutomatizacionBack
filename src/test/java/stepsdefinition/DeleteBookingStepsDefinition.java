package stepsdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.ValidateDeleteBookingQuestion;
import tasks.DeleteBookingTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static stepsdefinition.CreateBookingStepsDefinition.data;

public class DeleteBookingStepsDefinition {

    @When("i delete the data of the created books")
    public void i_delete_the_data_of_the_created_books() {
        withCurrentActor(DeleteBookingTask.atService());
    }

    @Then("the correct disposal of the books is validated")
    public void the_correct_disposal_of_the_books_is_validated() {
        theActorInTheSpotlight().should(seeThatResponse("Validar que sea exitosa", response -> response
                .statusCode(Integer.parseInt(data.get("Status")))));
        theActorInTheSpotlight().should(seeThat(ValidateDeleteBookingQuestion.atService(data.get("Dato"))));
    }
}