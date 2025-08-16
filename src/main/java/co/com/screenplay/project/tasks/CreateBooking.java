package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBooking implements Task {
    private final String body;

    public CreateBooking(String body) {
        this.body = body;
    }

    public static CreateBooking withData(String body) {
        return instrumented(CreateBooking.class, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/booking")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(body))
        );
    }
}





