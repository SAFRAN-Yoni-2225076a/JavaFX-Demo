package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VBoxAndHBoxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();

        // Création du conteneur correspondant à la ligne de contrôle haut dessus du tableau
        HBox topControls = new HBox();

        MenuItem newitem, open, save, close, cut, copy, paste;
        newitem = new MenuItem("New");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        close = new MenuItem("Close");

        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");

        Menu file, edit, help;

        file = new Menu("File");
        edit = new Menu("Edit");
        help = new Menu("Help");

        file.getItems().addAll(newitem, open, save, close);
        edit.getItems().addAll(cut, copy, paste);

        MenuBar menubar = new MenuBar(file, edit, help);

        topControls.setMinSize(menubar.getMinWidth(),menubar.getMinHeight());

        HBox.setHgrow(menubar, Priority.ALWAYS);

        topControls.getChildren().addAll(menubar);
        topControls.setAlignment(Pos.TOP_LEFT);

        // Création partie centrale
        HBox midControls = new HBox();

        VBox tFieldButton = new VBox();
        GridPane tField = new GridPane();

        tField.add(new Label("Name:"), 1,1);
        tField.add(new Label("Email:"), 1,2);
        tField.add(new Label("Password:"), 1,3);
        tField.add(new TextField(), 2,1);
        tField.add(new TextField(), 2,2);
        tField.add(new TextField(), 2,3);

        tField.setAlignment(Pos.CENTER);

        Button submit, cancel;
        submit = new Button("Submit");
        cancel = new Button("Cancel");

        HBox buttonForm = new HBox(submit, cancel);
        buttonForm.setSpacing(10);
        buttonForm.setAlignment(Pos.CENTER);

        VBox.setMargin(buttonForm,new Insets(10.0d));

        tFieldButton.getChildren().addAll(tField,buttonForm);


        //tField.setAlignment(Pos.CENTER);
        tField.setVgap(10.0d);
        tField.setHgap(7.0d);

        VBox.setVgrow( midControls, Priority.ALWAYS );

        VBox boutons = new VBox();

        Text t1 = new Text("Boutons :");

        Button b1,b2,b3;
        b1 = new Button("Bouton 1");
        b2 = new Button("Bouton 2");
        b3 = new Button("Bouton 3");

        boutons.getChildren().addAll(t1, b1, b2, b3);
        boutons.setMinWidth((90));
        Separator sepMid = new Separator(Orientation.VERTICAL);

        tFieldButton.setAlignment(Pos.CENTER);
        tFieldButton.setMaxWidth(Double.MAX_VALUE-boutons.getWidth());
        tFieldButton.setPrefWidth(60000);


        midControls.getChildren().addAll(boutons,sepMid, tFieldButton);
        HBox.setMargin(boutons, new Insets(0,10.0d,0, 0));


        boutons.setAlignment(Pos.CENTER_LEFT);
        boutons.setSpacing(15.0d);

        // Création de la ligne de séparation
        Separator sep = new Separator();

        // Création du bandeau en bas de la fenêtre
        HBox bottomControls = new HBox();
        bottomControls.setAlignment(Pos.CENTER );
        Text botText = new Text("Ceci est un label de bas de page");
        bottomControls.getChildren().add( botText );

        // Ajout des contrôleurs au conteneur principal
        vbox.getChildren().addAll(
                topControls,
                midControls,
                sep,
                bottomControls
        );

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");


        // Ajout marge
        VBox.setMargin( topControls, new Insets(0d) );
        VBox.setMargin( midControls, new Insets(0.0d, 10.0d, 0.0d, 10.0d) );
        VBox.setMargin( bottomControls, new Insets(0.0d) );

        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);


        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}