package com.example.firstui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameInput;

    @FXML
    private Label salesText;

    @FXML
    protected void onHelloButtonClick() {
        String name = nameInput.getText();

        welcomeText.setText(
                "Welcome %s to JavaFX Application!".formatted(name)
        );
        nameInput.clear();
    }

    @FXML
    protected void onSalesButtonClick() {
        // call Sales Front REST API

        HttpRequest salesRequest = null;
        try {
            salesRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:5000/store"))
                    .GET()
                    .build();

            HttpResponse<String> salesResponse = HttpClient.newBuilder()
                    .build()
                    .send(salesRequest, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();

            Store store = mapper.readValue(salesResponse.body(), Store.class);

            salesText.setText(
                    "Currently there are %s sales"
                            .formatted(store.getNumberOfSales())
            );
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        // get JSON data

        // convert JSON to Java Object

        // Display Sales text
    }

    @FXML
    protected void onKeyPressed(KeyEvent event) {
        System.out.println(event.getCode());
    }
}