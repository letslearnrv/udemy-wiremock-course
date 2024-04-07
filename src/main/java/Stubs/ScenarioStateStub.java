package Stubs;
import com.github.tomakehurst.wiremock.stubbing.Scenario;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class ScenarioStateStub {

    public ScenarioStateStub userStateStub()
    {
        // Get User - When no user exists - Default to Scenario.STARTED
        stubFor(get(urlEqualTo("/user/state")).inScenario("Create User")
                .willReturn(aResponse().withBodyFile("NoUserExists.json")));

        // Create User
stubFor(post(urlEqualTo("/user/state")).inScenario("Create User").whenScenarioStateIs(Scenario.STARTED)
        .willReturn(aResponse().withBodyFile("CreateUser.json")).willSetStateTo("User Created"));

stubFor(get(urlEqualTo("/user/state")).inScenario("Create User").whenScenarioStateIs("User Created")
        .willReturn(aResponse().withBodyFile("GetUser.json")));
        return  this;
    }
}
