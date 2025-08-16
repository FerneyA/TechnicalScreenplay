package co.com.screenplay.project.tasks;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Map;

public class GetFirstBookingId {

    public static Performable fromService() {
        return Task.where("{0} gets the first bookingId",
                actor -> {
                    Response response = SerenityRest.given()
                            .baseUri("https://restful-booker.herokuapp.com")
                            .basePath("/booking")
                            .get()
                            .then()
                            .extract()
                            .response();
                    List<Map<String, Integer>> bookings = response.jsonPath().getList("$");
                    Integer firstBookingId = bookings.get(0).get("bookingid");
                    actor.remember("bookingId", firstBookingId);
                }
        );
    }
}

