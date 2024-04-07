package Stubs;
import utils.jsonUtil;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class proxyingStubs {

    public void proxystub()
    {
        stubFor(get(urlMatching("/api/users/.*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom("http://reqres.in")));

        stubFor(get(urlPathEqualTo("/api/users/34")).atPriority(1)
                .willReturn(aResponse().withStatus(404)));
    }

    public void remoteloginstub()
    {

        stubFor(post(urlPathEqualTo("/api/login/remote"))
                .withRequestBody(equalToJson("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")).willReturn(aResponse()
                        .withBodyFile("remoteloginresponse.json")));
    }

}
