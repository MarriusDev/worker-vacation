package com.example.VacationWorker;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

public class Controller {

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextField balanceTF;

    @FXML
    private Button button;

    @FXML
    private Label labelBalance;

    @FXML
    protected void onButtonClick() {
        VacationManager obj = new VacationManager();
        try {
            double remainingBalance = obj.calculateRemainingVacation(startDate.getValue(), endDate.getValue(),
                    Double.parseDouble(balanceTF.getText()));
            if (remainingBalance < 0) {
                labelBalance.setText("Zůstatek: " + String.format("%.2f", remainingBalance));
                labelBalance.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
            } else {
                labelBalance.setText("Zůstatek: " + String.format("%.2f", remainingBalance));
                labelBalance.setStyle("-fx-text-fill: green; -fx-font-size: 20px;");
            }
        } catch (Exception e) {
            labelBalance.setText("Špatně vyplněno.");
            labelBalance.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
        }
    }

    @FXML
    public void initialize() {
        // Inicializace tlačítka s animací
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);

        button.setOnMouseReleased(event -> {
            scaleTransition.setFromX(0.9);
            scaleTransition.setFromY(0.9);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
            onButtonClick();
        });
    }
}
