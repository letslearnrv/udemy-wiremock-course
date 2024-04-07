package Stubs;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class HelperStubs {

    public HelperStubs jsonpathHelper()
    {
        stubFor(post(urlEqualTo("/api/users"))
                .willReturn(aResponse().withBodyFile("jsonPathHelperResponse.json")));
        return  this;
    }

    public HelperStubs mathstub()
    {
        stubFor(post(urlEqualTo("/math/helper")).willReturn(aResponse()
                .withBodyFile("mathhelperresponse").withHeader("Content-Type","application/json")));
        return this;
    }

    public HelperStubs ifelseuserstub()
    {
        stubFor(get(urlPathMatching("/api/user/ifelse/.*")).willReturn(aResponse()
                .withBodyFile("ifelsehelperresponse").withHeader("Content-Type","application/json")));

        return this;
    }


}
