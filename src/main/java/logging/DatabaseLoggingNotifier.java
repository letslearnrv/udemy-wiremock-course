package logging;

import com.github.tomakehurst.wiremock.common.Notifier;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseLoggingNotifier implements Notifier {

    private final String jdbcUrl;
    private final String username;
    private final String password;
    private final SimpleDateFormat dateFormat;

    public DatabaseLoggingNotifier(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    @Override
    public void info(String message) {
        // Ignore other types of messages
    }

    @Override
    public void error(String message) {
        // Ignore other types of messages
    }

    @Override
    public void error(String s, Throwable throwable) {

    }

    public void logRequestResponse(Request request, Response response) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String timestamp = dateFormat.format(new Date());

            String insertQuery = "INSERT INTO request_response_log (timestamp, request_url, request_method, request_body, " +
                    "response_status_code, response_body) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, timestamp);
                preparedStatement.setString(2, request.getUrl());
                preparedStatement.setString(3, request.getMethod().toString());
                preparedStatement.setString(4, request.getBodyAsString());
                preparedStatement.setInt(5, response.getStatus());
                preparedStatement.setString(6, response.getBodyAsString());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
