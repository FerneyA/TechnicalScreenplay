package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseBodyContains {
    public static Question<Boolean> key(String key) {
        return actor -> {
            Object value = lastResponse().jsonPath().get(key);
            return value instanceof Number;
        };
    }
}

