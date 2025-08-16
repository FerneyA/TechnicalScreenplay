package co.com.screenplay.project.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookingById implements Task {

    private final String contentType;

    public GetBookingById(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Integer bookingId = actor.recall("bookingId");
        actor.attemptsTo(
                Get.resource("/booking/" + bookingId)
                        .with(request -> request
                                .header("Accept", contentType)
                                .relaxedHTTPSValidation()
                        )
        );
        SerenityRest.lastResponse().prettyPrint();
    }

    public static GetBookingById withFormat(String contentType) {
        return instrumented(GetBookingById.class, contentType);
    }
}
