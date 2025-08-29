package co.com.screenplay.project.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class LastResponseContent {

    public static Question<String> field(String path) {
        return actor -> SerenityRest.lastResponse()
                .jsonPath()
                .getString(path);
    }
}
