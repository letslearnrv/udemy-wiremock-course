package Stubs;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class FetchUseCases {

    public FetchUseCases InvalidUserIDStub() {
        stubFor(get(urlEqualTo("/api/users/1"))
                .willReturn(aResponse()
                        .withBodyFile("Invaliduserid.json")
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                ));
        return this;
    }

    public FetchUseCases UnavailableStub() {
        stubFor(get(urlEqualTo("/api/users/2"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                ));
        return this;
    }

    public FetchUseCases InvalidEmailStub() {
        stubFor(get(urlEqualTo("/api/users/3"))
                .willReturn(aResponse()
                        .withBodyFile("Invalidemail.json")
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                ));
        return this;
    }

    public FetchUseCases IdMismatchStub() {
        stubFor(get(urlEqualTo("/api/users/4"))
                .willReturn(aResponse()
                        .withBodyFile("Idmismatch.json")
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                ));
        return this;
    }



}
