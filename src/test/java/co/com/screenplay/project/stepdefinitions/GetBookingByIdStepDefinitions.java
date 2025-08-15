package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ResponseContent;
import co.com.screenplay.project.questions.ResponseStatus;
import co.com.screenplay.project.tasks.GetBookingById;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetBookingByIdStepDefinitions {

    @Given("the actor queries the booking with id {string} in {string} format")
    public void theActorQueriesTheBookingWithIdInFormat(String bookingId, String contentType) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetBookingById.withIdAndFormat(bookingId, contentType)
        );
    }

    @Then("the actor must view the booking information at JSON")
    public void theActorMustViewTheBookingInformationAtJson() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El código de respuesta", ResponseStatus.code(), equalTo(200)),
                seeThat("El contenido", ResponseContent.body(), containsString("\"firstname\":\"Josh\""))
        );
    }

    @Then("the actor must view the booking information at XML")
    public void theActorMustViewTheBookingInformationAtXml() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El código de respuesta", ResponseStatus.code(), equalTo(200)),
                seeThat("El contenido", ResponseContent.body(), containsString("<firstname>Josh</firstname>"))
        );
    }
}
