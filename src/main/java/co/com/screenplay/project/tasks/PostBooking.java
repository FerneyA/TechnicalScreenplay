package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.rest.interactions.Post.to;

public class PostBooking {

    public static Performable withValidData() {
        return Task.where("{0} sends POST with valid booking data",
                to("/booking").with(request -> request
                        .header("Content-Type", "application/json")
                        .body("{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-01-01\",\"checkout\":\"2025-01-10\"},\"additionalneeds\":\"Breakfast\"}")
                ));
    }

    public static Performable withMissingData() {
        return Task.where("{0} sends POST with missing data",
                to("/booking").with(request -> request
                        .header("Content-Type", "application/json")
                        .body("{\"firstname\":\"John\"}")
                ));
    }

    public static Performable withInvalidDataTypes() {
        return Task.where("{0} sends POST with invalid data types",
                to("/booking").with(request -> request
                        .header("Content-Type", "application/json")
                        .body("{\"firstname\":12345,\"lastname\":false}")
                ));
    }
}
