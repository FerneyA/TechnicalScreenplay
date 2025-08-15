package co.com.screenplay.project.tasks;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookingIds implements Task {

    private final String filter;

    public GetBookingIds(String filter) {
        this.filter = filter;
    }

    public static GetBookingIds withFilter(String filter) {
        return instrumented(GetBookingIds.class, filter);
    }

    @Step("{0} retrieves booking IDs with filter: #filter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/booking" + (filter != null && !filter.isEmpty() ? "?" + filter : ""))
                        .with(RequestSpecification::relaxedHTTPSValidation)
        );
    }
}
