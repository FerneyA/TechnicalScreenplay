package co.com.screenplay.project.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseContent {

    public static Question<String> body() {
        return actor -> SerenityRest.lastResponse().asString();
    }
}
