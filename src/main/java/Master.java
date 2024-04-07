import Stubs.*;
import  com.github.tomakehurst.wiremock.WireMockServer;


import  static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;



public class Master {

    public static void main(String[] args) {


        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().
                globalTemplating(true)
                .port(57167).usingFilesUnderDirectory("src/main/resources")
                .notifier(new ConsoleNotifier(true))
              );
        wireMockServer.start();

        int port = wireMockServer.port();
        System.out.println(port);
        configureFor("localhost",57167);
        new FetchUseCases().IdMismatchStub().InvalidEmailStub().InvalidUserIDStub().UnavailableStub();


    }

}
