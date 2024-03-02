package stepsdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ValidateCreationBookingQuestion;
import tasks.CreateBookingTask;
import tasks.TokenTask;
import utils.DataDrivenExcel;
import utils.Excel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateBookingStepsDefinition {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        theActorCalled("User");
    }

    public static Map<String, String> data = new HashMap<>();
    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    @Given("i create and enter the token {int}")
    public void i_create_and_enter_the_token(int row, DataTable dataExcel) {
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"),
                true, row);
        data = dataDriverExcel.leerExcel(excel);
        withCurrentActor(TokenTask.atService(data.get("Username"), data.get("Password")));
    }

    @When("i enter the data in the service body")
    public void i_enter_the_data_in_the_service_body() {
        withCurrentActor(CreateBookingTask.atService(data.get("Firstname"), data.get("Lastname"),
                data.get("Totalprice"), data.get("Depositpaid"), data.get("Checkin"), data.get("Checkout"),
                data.get("Additionalneeds")));
    }

    @Then("the correct creation of the books is validated")
    public void the_correct_creation_of_the_books_is_validated() {
        theActorInTheSpotlight().should(seeThatResponse("Validar que sea exitosa", response -> response
                .statusCode(Integer.parseInt(data.get("Status")))));
        theActorInTheSpotlight().should(seeThat(ValidateCreationBookingQuestion.atService(data.get("Firstname"))));
    }
}