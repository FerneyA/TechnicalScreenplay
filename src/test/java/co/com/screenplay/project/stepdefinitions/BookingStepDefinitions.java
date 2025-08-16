package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ResponseBodyContains;
import co.com.screenplay.project.tasks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BookingStepDefinitions {

    @Given("that there is a booking in the system")
    public void thatThereIsABookingInTheSystem() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetFirstBookingId.fromService());
    }

    @When("I send a POST request to create a booking with valid data in JSON format")
    public void postValidBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(PostBooking.withValidDataAndJsonFormat());
    }

    @When("I send a POST request to create a booking with valid data in XML format")
    public void postBookingMissingData() {
        OnStage.theActorInTheSpotlight().attemptsTo(PostBooking.withValidDataAndXmlFormat());
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
