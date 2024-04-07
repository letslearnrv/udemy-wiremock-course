package Stubs;
import  static com.github.tomakehurst.wiremock.client.WireMock.*;
public class TransformerExtensionStubs {
//these stubs can eb used to enable trnasformer locally or globally by defualt those are global
    //can be made local

  public void stubs()
    {
        stubFor(get(urlPathEqualTo("/date/trans/add"))
                .willReturn(aResponse()
                        .withBody("CreateDateHeaderDefinitionTransformer")
                        .withHeader("Content-Type","application/json")
                        .withTransformerParameter("dateFormat","dd-MM-yyyy")));

        stubFor(get(urlPathEqualTo("/date/trans/create"))
                .willReturn(aResponse()
                        .withBody("CreateDateHeaderDefinitionTransformer")
                        .withHeader("Content-Type","application/json")
                        .withTransformerParameter("dateFormat","dd-MM-yyyy")));
    }
}
