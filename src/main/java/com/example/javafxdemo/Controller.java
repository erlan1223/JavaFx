package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private TextArea questionArea;

    @FXML
    private CheckBox answer1, answer2, answer3, answer4;

    @FXML
    private Button nextButton, submitButton;

    private final List<String> questions = Arrays.asList(
            "Какие из следующих стран находятся в Азии?",
            "Какие из этих людей были космонавтами Казахстана?",
            "Какие из следующих животных обитают в Южной Америке?",
            "Как называется столица Австралии?",
            "Какое количество планет в Солнечной системе?"
    );

    private final List<String[]> answerOptions = Arrays.asList(
            new String[]{"Суринаи", "Того", "Тайланд", "Камбоджа"},
            new String[]{"Аубакиров", "Шоканов", "Мусабаев", "Райымбеков"},
            new String[]{"Кенгуру", "Броненосец", "Капибара", "Коала"},
            new String[]{"Виктория", "Сидней", "Канберра","Мельбурн"},
            new String[]{"8", "9", "10","11"}
    );

    private final List<Set<String>> correctAnswers = Arrays.asList(
            new HashSet<>(Arrays.asList("Тайланд", "Камбоджа")),
            new HashSet<>(Arrays.asList("Аубакиров", "Мусабаев")),
            new HashSet<>(Arrays.asList("Броненосец", "Капибара")),
            new HashSet<>(List.of("Канберра")),
            new HashSet<>(List.of("8"))
    );

    private int currentQuestionIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadQuestion(currentQuestionIndex);
        nextButton.setOnAction(this::nextQuestion);
        submitButton.setOnAction(this::tryToAnswer);
    }

    private void loadQuestion(int index) {
        questionArea.setText(questions.get(index));
        String[] answers = answerOptions.get(index);
        answer1.setText(answers[0]);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
        answer4.setText(answers[3]);
        answer1.setSelected(false);
        answer2.setSelected(false);
        answer3.setSelected(false);
        answer4.setSelected(false);
    }

    @FXML
    private void tryToAnswer(ActionEvent event) {
        Set<String> selectedAnswers = new HashSet<>();
        if (answer1.isSelected()) selectedAnswers.add(answer1.getText());
        if (answer2.isSelected()) selectedAnswers.add(answer2.getText());
        if (answer3.isSelected()) selectedAnswers.add(answer3.getText());
        if (answer4.isSelected()) selectedAnswers.add(answer4.getText());

        if (selectedAnswers.equals(correctAnswers.get(currentQuestionIndex))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Правильно!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Неправильно!");
            alert.showAndWait();
        }
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            loadQuestion(currentQuestionIndex);
        } else {
            currentQuestionIndex = 0;
            loadQuestion(currentQuestionIndex);
        }
    }
}

