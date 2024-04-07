package Stubs;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class QueryMatchStubs {
    public QueryMatchStubs urlQuerymatchstub()
    {

      /*  stubFor(get(urlEqualTo("/url/querymatch?page=3&id=12"))
                .willReturn(aResponse().withBody(""))); */
        Map<String, StringValuePattern> queryParam = new HashMap<String,StringValuePattern>();
        queryParam.put("page",equalTo("3"));
        queryParam.put("id",equalTo("12"));

        stubFor(get(urlPathEqualTo("/url/querymatch"))
                .withQueryParams(queryParam)
                .willReturn(aResponse().withBody("using Query Match Method")));
        return  this;
    }

    public QueryMatchStubs MultiQuerymatchstub()
    {


                stubFor(get(urlPathEqualTo("/url/querymatch"))
                .withQueryParam("id",including("1","4"))
                .willReturn(aResponse().withBody("using Query Match Method")));
        return  this;
    }

    public QueryMatchStubs JsonSchemastub()
    {


        stubFor(post(urlPathEqualTo("/url/json/check"))
                .withRequestBody(matchingJsonSchema("{\n" +
                        "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                        "  \"title\": \"Generated schema for Root\",\n" +
                        "  \"type\": \"object\",\n" +
                        "  \"properties\": {\n" +
                        "    \"id\": {\n" +
                        "      \"type\": \"number\"\n" +
                        "    },\n" +
                        "    \"email\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"first_name\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"last_name\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"avatar\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"required\": [\n" +
                        "    \"id\",\n" +
                        "    \"email\",\n" +
                        "    \"first_name\",\n" +
                        "    \"last_name\",\n" +
                        "    \"avatar\"\n" +
                        "  ]\n" +
                        "}"))
                .willReturn(aResponse().withBody("Request matched jsons schema")));
        return  this;
    }


}
