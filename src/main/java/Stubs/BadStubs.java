package Stubs;
import com.github.tomakehurst.wiremock.http.Fault;
import utils.jsonUtil;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class BadStubs {
    utils.jsonUtil jsonUtil= new jsonUtil();
    public BadStubs badstubsmappings()
    {
        stubFor(get(urlEqualTo("/fault/1")).willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE)));
        stubFor(get(urlEqualTo("/fault/2")).willReturn(aResponse().withFault(Fault.MALFORMED_RESPONSE_CHUNK)));
        stubFor(get(urlEqualTo("/fault/3")).willReturn(aResponse().withFault(Fault.RANDOM_DATA_THEN_CLOSE)));
        stubFor(get(urlEqualTo("/fault/4")).willReturn(aResponse().withFault(Fault.CONNECTION_RESET_BY_PEER)));
        return this;
    }

    public BadStubs customFaultStub()
    {


        jsonUtil.setJSON("faultstubreq");

        stubFor(post(urlEqualTo("/api/register")).atPriority(3)
                .withRequestBody(equalToJson(jsonUtil.getJSON().toString())).willReturn(aResponse()
                .withBodyFile("regsuccessresponse")
                        .withHeader("Content-Type","application/json")));

        stubFor(post(urlEqualTo("/api/register")).willReturn(aResponse()
                .withBodyFile("faultresponse").withStatus(400)
                .withHeader("Content-Type","application/json")));

        return this;
    }


}
