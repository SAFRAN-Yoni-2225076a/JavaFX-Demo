package com.example.exercice5Pacman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    static ArrayList<Obstacle> obstacles = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        // Ajoutez des obstacles
        Obstacle obstacle1 = new Obstacle(100, 25, 50, 285);
        Obstacle obstacle2 = new Obstacle(300, 100, 200, 25);
        Obstacle borderTop = new Obstacle(-10,-10,640,1);
        Obstacle borderBot = new Obstacle(-10,480,650,1);
        Obstacle borderRight = new Obstacle(640,-10,1,490);
        Obstacle borderLeft = new Obstacle(-9,-9,1,480);

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(borderTop);
        obstacles.add(borderBot);
        obstacles.add(borderRight);
        obstacles.add(borderLeft);

        jeu.getChildren().addAll(obstacles);


        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, jeu);



        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Pane jeu) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                end(jeu);
            }
        });
    }

    private void end(Pane jeu) {
        // Arrete les mouvements des personnages
        scene.setOnKeyPressed(null);

        // Message fin de partie
        Text gameOverText = new Text("Vous êtes mort \n\nFin de la partie");
        gameOverText.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gameOverText.setFill(Color.RED);
        gameOverText.setX(scene.getWidth() / 2 - gameOverText.getLayoutBounds().getWidth() / 2);
        gameOverText.setY(scene.getHeight() / 2);

        jeu.getChildren().add(gameOverText);
    }


}
