package Stubs;
import utils.jsonUtil;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class RequestBodyMatchStubs {
    utils.jsonUtil jsonUtil=new jsonUtil();
    public RequestBodyMatchStubs bodyMatchStubs()
    {
        stubFor(post(urlPathEqualTo("/body/match"))
                .withRequestBody(equalToJson("{\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"MainId\": 1111,\n" +
                        "      \"firstName\": \"Sherlock\",\n" +
                        "      \"lastName\": \"Homes\",\n" +
                        "      \"categories\": [\n" +
                        "        {\n" +
                        "          \"CategoryID\": 1,\n" +
                        "          \"CategoryName\": \"Example\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"MainId\": 122,\n" +
                        "      \"firstName\": \"James\",\n" +
                        "      \"lastName\": \"Watson\",\n" +
                        "      \"categories\": [\n" +
                        "        {\n" +
                        "          \"CategoryID\": 2,\n" +
                        "          \"CategoryName\": \"Example2\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"messages\": [],\n" +
                        "  \"success\": true\n" +
                        "}"))
                .willReturn(aResponse().withBody("Request BodyMatch Success")));

        return this;
    }

    public RequestBodyMatchStubs bodyMatchStubsusingFile()
    {
        jsonUtil.setJSON("InputRequest.json");
        stubFor(post(urlPathEqualTo("/body/match/file"))
                .withRequestBody(equalToJson(jsonUtil.getJSON().toString(),true,true))

                .willReturn(aResponse().withBody("Request Body Match with file success")));
        return this;
    }

    public  RequestBodyMatchStubs jsonpathmatchstub()
    {
        stubFor(post(urlPathEqualTo("/req/json/path"))
                .withRequestBody(matchingJsonPath("$.data[0][?(@.MainId == '1111')]"))
                .willReturn(aResponse().withBody("Json Path Match Success")));
        return this;
    }

}
