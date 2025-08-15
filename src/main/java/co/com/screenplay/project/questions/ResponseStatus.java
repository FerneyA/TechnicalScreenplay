package co.com.screenplay.project.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ResponseStatus {

    public static Question<Integer> code() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }
}
