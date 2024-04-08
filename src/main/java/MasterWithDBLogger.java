import Stubs.FetchUseCases;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import logging.DatabaseLoggingNotifier;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;


public class MasterWithDBLogger {

    public static void main(String[] args) {

        DatabaseLoggingNotifier notifier= new DatabaseLoggingNotifier(
                "jdbc:mysql://localhost:3306/wiremock_logs?useSSL=false",
                "root",
                "Lets!learn"
        );
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().
                globalTemplating(true)
                .port(57167).usingFilesUnderDirectory("src/main/resources")
                .notifier(notifier)
              );
        wireMockServer.addMockServiceRequestListener(notifier :: logRequestResponse);
        wireMockServer.start();

        int port = wireMockServer.port();
        System.out.println(port);
        configureFor("localhost",57167);
        new FetchUseCases().IdMismatchStub().InvalidEmailStub().InvalidUserIDStub().UnavailableStub().createStub();


    }

}
