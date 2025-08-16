package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.BookingIdsResponse;
import co.com.screenplay.project.questions.ResponseContent;
import co.com.screenplay.project.questions.ResponseStatus;
import co.com.screenplay.project.tasks.GetBookingById;
import co.com.screenplay.project.tasks.GetBookingIds;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetBookingByIdStepDefinitions {

    @Given("the actor queries the bookingId in {string} format")
    public void theActorQueriesTheBookingIdInFormat(String contentType) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetBookingById.withFormat(contentType)
        );
    }

    @Given("the actor wants to retrieve booking IDs with {string}")
    public void theActorWantsToRetrieveBookingIDs(String filter) {
        OnStage.theActorInTheSpotlight().remember("filter", filter);
    }

    @When("the actor sends the request to get booking IDs")
    public void theActorSendsTheRequestToGetBookingIDs() {
        String filter = OnStage.theActorInTheSpotlight().recall("filter");
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetBookingIds.withFilter(filter)
        );
    }

    @Then("the actor must view the booking information at JSON")
    public void theActorMustViewTheBookingInformationAtJson() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El código de respuesta", ResponseStatus.code(), equalTo(200)),
                seeThat("El contenido", ResponseContent.body(), containsString("\"firstname\":"))
        );
    }

    @Then("the actor must view the booking information at XML")
    public void theActorMustViewTheBookingInformationAtXml() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El código de respuesta", ResponseStatus.code(), equalTo(200)),
                seeThat("El contenido", ResponseContent.body(), containsString("<firstname>")),
                seeThat("El contenido", ResponseContent.body(), containsString("</firstname>"))
        );
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("Status code is correct",
                        response -> response.statusCode(statusCode))
        );
    }

    @Then("the booking IDs list should not be empty")
    public void theBookingIDsListShouldNotBeEmpty() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(BookingIdsResponse.isEmpty(false))
        );
    }
}
