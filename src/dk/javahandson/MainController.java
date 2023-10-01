package dk.javahandson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    public ListView listView;
    @FXML
    private TextField txtInputName;
    @FXML
    private Label lbl;

    @FXML
    private void clickBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Another window");
        stage.setScene(new Scene(root));
        stage.show();

        //Get QuestionWindow Controller
        QuestionWindowController q = loader.getController();
        q.setParentController(this);
        q.setTextName(txtInputName.getText());
    }
}

