package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.rest.interactions.Post.to;

public class PostBooking {

    public static Performable withValidDataAndJsonFormat() {
        return Task.where("{0} sends POST with valid booking data and JSON format",
                to("/booking").with(request -> request
                        .header("Content-Type", "application/json")
                        .body("{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-01-01\",\"checkout\":\"2025-01-10\"},\"additionalneeds\":\"Breakfast\"}")
                ));
    }

    public static Performable withValidDataAndXmlFormat() {
        return Task.where("{0} sends POST with valid booking data and XML format",
                to("/booking").with(request -> request
                        .header("Content-Type", "text/xml")
                        .header("Accept", "application/xml")
                        .body("<booking>\n" +
                                "    <firstname>Jim</firstname>\n" +
                                "    <lastname>Brown</lastname>\n" +
                                "    <totalprice>111</totalprice>\n" +
                                "    <depositpaid>true</depositpaid>\n" +
                                "    <bookingdates>\n" +
                                "      <checkin>2018-01-01</checkin>\n" +
                                "      <checkout>2019-01-01</checkout>\n" +
                                "    </bookingdates>\n" +
                                "    <additionalneeds>Breakfast</additionalneeds>\n" +
                                "  </booking>")
                ));
    }
}
