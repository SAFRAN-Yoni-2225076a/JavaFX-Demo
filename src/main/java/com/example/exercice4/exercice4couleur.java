package com.example.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class exercice4couleur extends Application {

    private int cVert = 0;
    private int cRouge = 0;
    private int cBleu = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane couleur = new BorderPane();

        // Top Label
        Label label = new Label("Compteur de couleurs");
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPrefWidth(10000);
        label.setAlignment(Pos.CENTER);

        HBox labelBox = new HBox(label);
        labelBox.setAlignment(Pos.CENTER);
        couleur.setTop(labelBox);

        // Pane centre

        Pane pane = new Pane();
        couleur.setCenter(pane);

        // Buttons Bottom

        Button vert = new Button("Vert");
        vert.setOnAction(event -> {
            cVert++;
            pane.setStyle("-fx-background-color: #00cd00");
            label.setText("Vert choisi " + cVert + " fois");
        });

        Button rouge = new Button("Rouge");
        rouge.setOnAction(event -> {
            cRouge++;
            pane.setStyle("-fx-background-color: red");
            label.setText("Rouge choisi " + cRouge + " fois");
        });

        Button bleu = new Button("Bleu");
        bleu.setOnAction(event -> {
            cBleu++;
            pane.setStyle("-fx-background-color: #3b3bf3");
            label.setText("Bleu choisi " + cBleu + " fois");
        });

        HBox buttons = new HBox(vert, rouge, bleu);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10));
        couleur.setBottom(buttons);

        labelBox.setPadding(new Insets(10));


        Scene scene = new Scene(couleur, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}