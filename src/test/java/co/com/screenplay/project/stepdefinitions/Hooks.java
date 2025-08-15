package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.utils.ApiConstants;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hooks {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Tester")
                .whoCan(CallAnApi.at(ApiConstants.BASE_URL));
    }
}
