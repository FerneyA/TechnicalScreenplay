package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.rest.interactions.Patch.to;

public class PartialUpdateBooking {

    public static Performable withValidFormatJson() {
        return Task.where("{0} sends PUT with valid booking data",
                (Actor actor) -> {
                    String token = actor.recall("token");
                    actor.attemptsTo(
                            Put.to("/booking/3582").with(request -> request
                                    .header("Content-Type", "application/json")
                                    .header("Accept", "application/json")
                                    .header("Cookie", "token=" + token)
                                    .body("{\"firstname\":\"JohnPatch\",\"lastname\":\"DoePatch\"}")
                            )
                    );
                }
        );
    }

    public static Performable withValidFormatXml() {
        return Task.where("{0} sends PATCH with valid booking data",
                to("/booking/3582").with(request -> request
                        .header("Content-Type", "text/xml")
                        .header("Accept", "application/xml")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body("<booking><firstname>James</firstname><lastname>Brown</lastname></booking>")
                )
        );
    }
}
