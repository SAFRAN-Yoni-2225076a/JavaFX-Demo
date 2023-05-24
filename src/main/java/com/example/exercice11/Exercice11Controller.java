package com.example.exercice11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Exercice11Controller {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextField dateF;

    @FXML
    private TextField populationF;

    private ObservableList<XYChart.Data<String, Number>> val;

    @FXML
    public void initialize() {
        val = FXCollections.observableArrayList();
        barChart.setTitle("Evolution of the number of Whales");
        barChart.getData().add(new XYChart.Series<>(val));
    }

    @FXML
    private void addVal(ActionEvent event) {
        String date = dateF.getText().trim();
        String population = populationF.getText().trim();

        if (date.isEmpty() || population.isEmpty()) {
            pbMessage("Manque d'information", "Remplissez les champs.");
            return;
        }

        try {
            Number value = Double.parseDouble(population);
            val.add(new XYChart.Data<>(date, value));
        } catch (NumberFormatException ex) {
            pbMessage("Erreur d'information", "Valeur numérique uniquement.");
        }

        dateF.clear();
        populationF.clear();
    }

    private void pbMessage(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}