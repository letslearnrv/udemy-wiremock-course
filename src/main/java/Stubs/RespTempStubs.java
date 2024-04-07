package Stubs;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RespTempStubs {

    public RespTempStubs listuserStub() {
        stubFor(get(urlEqualTo("/api/users?page=2"))
                .willReturn(aResponse()
                        .withBodyFile("listuserStubResponse.json")
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                ));
        return this;
    }

    public RespTempStubs transfmParamStub1() {
        stubFor(get(urlPathEqualTo("/api/use"))
                .willReturn(aResponse()
                        .withBodyFile("transfmParamStub1response.json")
                        .withHeader("Content-Type", "application/json")
                        .withHeader("hostname", "{{request.host}}")
                        .withTransformerParameter("email", "transfmParamStub1@gmail.com")));
        return this;
    }



    public RespTempStubs transfmParamStub2()
    {
        stubFor(get(urlPathEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withBodyFile("transfmParamStub1response.json")
                        .withHeader("Content-Type","application/json")
                        .withHeader("hostname","{{request.host}}")
                        .withTransformerParameter("email","transfmParamStub2@gmail.com")));
        return this;
    }

    public RespTempStubs pathTempstub()
    {
        stubFor(get(urlPathTemplate("/api/users/{userid}"))
                .willReturn(aResponse().withBodyFile("pathtem.json")
                        .withHeader("Content-Type","application/json"))
        );
        return this;
    }





}
