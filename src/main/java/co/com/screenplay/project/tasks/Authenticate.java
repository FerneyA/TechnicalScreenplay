package co.com.screenplay.project.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class Authenticate implements Task {

    private static final String USERNAME = System.getenv("BOOKING_USERNAME");
    private static final String PASSWORD = System.getenv("BOOKING_PASSWORD");

    public static Authenticate asAdmin() {
        return Tasks.instrumented(Authenticate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/auth").with(request -> request
                        .header("Content-Type", "application/json")
                        .body(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", USERNAME, PASSWORD))
                )
        );
        String token = SerenityRest.lastResponse().jsonPath().getString("token");
        actor.remember("token", token);
    }
}
