package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.BookingIdsResponse;
import co.com.screenplay.project.questions.ResponseBodyContains;
import co.com.screenplay.project.tasks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class BookingStepDefinitions {

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

    @Then("the booking IDs list should not be empty")
    public void theBookingIDsListShouldNotBeEmpty() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(BookingIdsResponse.isEmpty(false))
        );
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("Status code is correct",
                        response -> response.statusCode(statusCode))
        );
    }

    //************************************//

    @When("I send a POST request to create a booking with valid data")
    public void postValidBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(PostBooking.withValidData());
    }

    @When("I send a POST request to create a booking with missing data")
    public void postBookingMissingData() {
        OnStage.theActorInTheSpotlight().attemptsTo(PostBooking.withMissingData());
    }

    @When("I send a POST request to create a booking with invalid data types")
    public void postBookingInvalidDataTypes() {
        OnStage.theActorInTheSpotlight().attemptsTo(PostBooking.withInvalidDataTypes());
    }

    @Then("the response should contain {string} type numeric")
    public void validateResponseContains(String key) {
        OnStage.theActorInTheSpotlight().should(seeThat(ResponseBodyContains.key(key)));
    }

    @Given("a user with a valid token")
    public void aUserWithAValidToken() {
        OnStage.theActorInTheSpotlight().attemptsTo(Authenticate.asAdmin());
    }

    @When("I send a PUT request to update a booking with valid data")
    public void putValidBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateBooking.withValidData());
    }

    @When("I send a PUT request with invalid authentication")
    public void putInvalidAuth() {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateBooking.withInvalidAuth());
    }

    @When("I send a PATCH request in XML format to update booking firstname")
    public void patchFirstnameXml() {
        OnStage.theActorInTheSpotlight().attemptsTo(PartialUpdateBooking.withValidFormatXml());
    }

    @When("I send a PATCH request in JSON format to update booking firstname")
    public void patchFirstnameJson() {
        OnStage.theActorInTheSpotlight().attemptsTo(PartialUpdateBooking.withValidFormatJson());
    }

    @When("I send a DELETE request for a booking in JSON format")
    public void deleteValidBookingJsonFormat() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteBooking.withValidFormatJson());
    }

    @When("I send a DELETE request for a booking in XML format")
    public void deleteValidBookingXmlFormat() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteBooking.withValidFormatXml());
    }
}
