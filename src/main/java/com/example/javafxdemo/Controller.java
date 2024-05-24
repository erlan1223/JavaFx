package com.example.javafxdemo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea questionArea;

    @FXML
    RadioButton answer1, answer2, answer3, answer4;

    @FXML
    ToggleGroup answers;
    private String question = "Ваш любимый фрукт?";

    private String[] variants = {
            "Банан", "Киви", "Апельсин", "Мандарин"
    };

    private String correctVariant = "Апельсин";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println();
        System.out.println(1);
        System.out.println(2);
        questionArea.setText(question);
        answer1.setText(variants[0]);
        answer2.setText(variants[1]);
        answer3.setText(variants[2]);
        answer4.setText(variants[3]);
    }

    public void tryToAnswer() {
        if(((RadioButton)answers.getSelectedToggle()).getText().equals(correctVariant)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Правильно!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не правильно!");
            alert.showAndWait();
        }
    }
}