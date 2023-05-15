package com.example.partie2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Random;

public class Exercice2Conteneur extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();

        // Image

        final Image rond = new Image(getClass().getResource("Rond.png").toString());
        final Image croix = new Image(getClass().getResource("Croix.png").toString());
        final Image vide = new Image(getClass().getResource("Vide.png").toString());

        // GridPane
        GridPane jeu = new GridPane();
        // Création de la liste de listes de labels

        Random random = new Random();

        for (int i = 1; i < 4; ++i) {
            for (int j = 1; j < 4; ++j){
                int nombre = random.nextInt(3);
                if(nombre == 0){
                    jeu.add(new ImageView(croix),i,j);
                } else if (nombre == 1) {
                    jeu.add(new ImageView(rond),i,j);
                } else if (nombre == 2) {
                    jeu.add(new ImageView(vide),i,j);
                }
            }
        }
vbox.getChildren().add(jeu);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 150 );
        primaryStage.setHeight( 180 );
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);

// t
        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}