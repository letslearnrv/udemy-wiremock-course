package Stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UrlMatchingStubs {

    public UrlMatchingStubs anyurlstub()
    {
        stubFor(any(anyUrl()).atPriority(10).willReturn(aResponse().withBody("Default Match ")));
        return this;
    }

    public UrlMatchingStubs pathonlystub()
    {
        stubFor(get(urlPathEqualTo("/api/users/2")).atPriority(2)
                .withHeader("Test",equalTo("application")).withCookie("Test_Cookie",containing("Cookie"))
                              .willReturn(aResponse()
                        .withBodyFile("pathonlyresponse.json")
                        .withHeader("content-type","application/json")
                ));
        return this;
    }

    public  UrlMatchingStubs pathquerymatchstub()
    {
        stubFor(get(urlEqualTo("/api/users?page=2")).atPriority(2)
                .willReturn(aResponse().withBodyFile("pathqueryresponse.json") .withHeader("content-type","application/json")));
        return  this;
    }

    public  UrlMatchingStubs pathregexstub()
    {
        stubFor(get(urlPathMatching("/api/users/([1-9])"))
                .willReturn(aResponse().withBodyFile("pathregexstubresponse.json")
                        .withHeader("content-type","application/json")));
        return this;
    }

    public UrlMatchingStubs pathandqueryregexstub()
    {
        stubFor(get(urlMatching("/api/users\\?page=([1-8])"))
                .willReturn(aResponse().withBodyFile("pathandqueryregexstubresponse.json")
                        .withHeader("content-type","application/json")));
        return this;
    }



}
