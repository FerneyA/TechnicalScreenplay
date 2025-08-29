package co.com.screenplay.project.tasks;

import co.com.screenplay.project.models.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBooking implements Task {

    private final Booking booking;

    public CreateBooking(Booking booking) {
        this.booking = booking;
    }

    public static CreateBooking withData(Booking booking) {
        return instrumented(CreateBooking.class, booking);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/booking")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(booking))
        );
    }
}
