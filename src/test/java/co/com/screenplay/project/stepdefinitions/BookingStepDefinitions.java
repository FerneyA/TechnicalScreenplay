package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.models.Booking;
import co.com.screenplay.project.models.BookingDates;
import co.com.screenplay.project.questions.LastResponseContent;
import co.com.screenplay.project.questions.ResponseBodyContains;
import co.com.screenplay.project.tasks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingStepDefinitions {

    @Given("that there is a booking in the system")
    public void thatThereIsABookingInTheSystem() {
        theActorInTheSpotlight().attemptsTo(GetFirstBookingId.fromService());
    }

    @When("I send a POST request to create a booking with valid data in JSON format")
    public void postValidBooking() {
        theActorInTheSpotlight().attemptsTo(PostBooking.withValidDataAndJsonFormat());
    }

    @When("I send a POST request to create a booking with valid data in XML format")
    public void postBookingMissingData() {
        theActorInTheSpotlight().attemptsTo(PostBooking.withValidDataAndXmlFormat());
    }

    @Then("the response should contain {string} type numeric")
    public void validateResponseContains(String key) {
        theActorInTheSpotlight().should(seeThat(ResponseBodyContains.key(key)));
    }

    @Given("a user with a valid token")
    public void aUserWithAValidToken() {
        theActorInTheSpotlight().attemptsTo(Authenticate.asAdmin());
    }

    @When("I send a PUT request to update a booking with valid data")
    public void putValidBooking() {
        theActorInTheSpotlight().attemptsTo(UpdateBooking.withValidData());
    }

    @When("I send a PUT request with invalid authentication")
    public void putInvalidAuth() {
        theActorInTheSpotlight().attemptsTo(UpdateBooking.withInvalidAuth());
    }

    @When("I send a PATCH request in XML format to update booking firstname")
    public void patchFirstnameXml() {
        theActorInTheSpotlight().attemptsTo(PartialUpdateBooking.withValidFormatXml());
    }

    @When("I send a PATCH request in JSON format to update booking firstname")
    public void patchFirstnameJson() {
        theActorInTheSpotlight().attemptsTo(PartialUpdateBooking.withValidFormatJson());
    }

    @When("I send a DELETE request for a booking in JSON format")
    public void deleteValidBookingJsonFormat() {
        theActorInTheSpotlight().attemptsTo(DeleteBooking.withValidFormatJson());
    }

    @When("I send a DELETE request for a booking in XML format")
    public void deleteValidBookingXmlFormat() {
        theActorInTheSpotlight().attemptsTo(DeleteBooking.withValidFormatXml());
    }

    //*********************************//

    @When("actor creates a booking with firstname {string} and lastname {string}")
    public void actorCreatesABookingWithFirstnameAndLastname(String firstname, String lastname) {
        Booking booking = new Booking(firstname, lastname, 111, true,
                new BookingDates("2018-01-01", "2019-01-01"), "Breakfast");

        theActorInTheSpotlight().attemptsTo(
                CreateBooking.withData(booking)
        );
    }

    @Then("actor should see the booking created with firstname {string}")
    public void actorShouldSeeTheBookingCreatedWithFirstname(String expectedFirstname) {
        theActorInTheSpotlight().should(
                seeThat("The booking firstname",
                        LastResponseContent.field("booking.firstname"),
                        equalTo(expectedFirstname))
        );
    }
}
