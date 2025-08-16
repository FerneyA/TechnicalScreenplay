package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.rest.interactions.Put.to;

public class UpdateBooking {

    public static Performable withValidData() {
        return Task.where("{0} sends PUT with valid booking data",
                (Actor actor) -> {
                    String token = actor.recall("token");
                    Integer bookingId = actor.recall("bookingId");
                    actor.attemptsTo(
                            to("/booking/" + bookingId).with(request -> request
                                    .header("Content-Type", "application/json")
                                    .header("Accept", "application/json")
                                    .header("Cookie", "token=" + token)
                                    .body("{\"firstname\":\"JohnUpdated\",\"lastname\":\"DoeUpdated\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-01-01\",\"checkout\":\"2025-01-10\"},\"additionalneeds\":\"Breakfast\"}")
                            )
                    );
                }
        );
    }

    public static Performable withInvalidAuth() {
        return Task.where("{0} sends PUT with invalid auth token",
                (Actor actor) -> {
                    Integer bookingId = actor.recall("bookingId");
                    actor.attemptsTo(
                            to("/booking/" + bookingId).with(request -> request
                                    .header("Content-Type", "application/json")
                                    .header("Accept", "application/json")
                                    .header("Cookie", "token=1234")
                                    .body("{\"firstname\":\"JohnUpdated\",\"lastname\":\"DoeUpdated\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-01-01\",\"checkout\":\"2025-01-10\"},\"additionalneeds\":\"Breakfast\"}")
                            )
                    );
                }
        );
    }
}