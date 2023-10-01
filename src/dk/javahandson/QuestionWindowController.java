package dk.javahandson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class QuestionWindowController {
    @FXML
    private Label txtName;
    @FXML
    private Label scoreLbl;
    private MainController controller;
    @FXML
    private int score;
    public static List participants = new ArrayList();

    public void calculateScore(ActionEvent actionEvent) {
        updateScore();
        participants.add(txtName.getText() + " : " + getScore());

        //Get list displayed
        ObservableList oParticipants = FXCollections.observableArrayList(participants);
        controller.listView.setItems(oParticipants);


        //Close the window
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

    public void setParentController(MainController controller) {
        this.controller = controller;
    }

    public void setTextName(String text) {
        txtName.setText(text);
    }

    public void addOne(ActionEvent actionEvent) {
        score++;
        updateScore();
    }

    public void minusOne(ActionEvent actionEvent) {
        score--;
        updateScore();
    }

    public void updateScore(){
        String txtScore = Integer.toString(score);
        scoreLbl.setText(txtScore);
    }

    public String getScore(){
        String txtScore = Integer.toString(score);
        return txtScore;
    }
}
