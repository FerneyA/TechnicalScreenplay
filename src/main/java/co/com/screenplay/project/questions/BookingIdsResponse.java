package co.com.screenplay.project.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookingIdsResponse implements Question<Boolean> {

    private final boolean shouldBeEmpty;

    public BookingIdsResponse(boolean shouldBeEmpty) {
        this.shouldBeEmpty = shouldBeEmpty;
    }

    public static BookingIdsResponse isEmpty(boolean shouldBeEmpty) {
        return new BookingIdsResponse(shouldBeEmpty);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String json = SerenityRest.lastResponse().asString();
        Serenity.recordReportData()
                .withTitle("Response Body")
                .andContents(json);
        List<Map<String, Object>> ids = JsonPath.from(json).getList("$");

        if (shouldBeEmpty) {
            assertThat(ids, is(empty()));
        } else {
            assertThat(ids, is(not(empty())));
            ids.forEach(item -> {
                assertThat(item.keySet(), contains("bookingid"));
                assertThat(item.get("bookingid"), instanceOf(Number.class));
            });
        }
        return true;
    }
}
