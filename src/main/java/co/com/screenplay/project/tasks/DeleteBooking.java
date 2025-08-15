package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.rest.interactions.Delete.from;

public class DeleteBooking {

    public static Performable withValidFormatJson() {
        return Task.where("{0} sends DELETE with valid booking data",
                (Actor actor) -> {
                    String token = actor.recall("token");
                    actor.attemptsTo(
                            Delete.from("/booking/262").with(request -> request
                                    .header("Content-Type", "application/json")
                                    .header("Accept", "application/json")
                                    .header("Cookie", "token=" + token)
                            )
                    );
                }
        );
    }

    public static Performable withValidFormatXml() {
        return Task.where("{0} sends DELETE with valid booking data",
                from("/booking/702").with(request -> request
                        .header("Content-Type", "text/xml")
                        .header("Accept", "application/xml")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                )
        );
    }
}
