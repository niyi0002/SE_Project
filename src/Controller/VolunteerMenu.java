package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class VolunteerMenu {

    @FXML
    private Label displayMessagae;

    @FXML
    private Button goBack;

    @FXML
    private Button event;

    @FXML
    private Button profile;

    @FXML
    private Button schedule;

    @FXML
    private Button donate;

    Stage dialogStage = new Stage();
    Scene scene ;

    @FXML
    void handleDonate(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/Donate.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    void handleEvent(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/Events.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    void handleProfile(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/Profile.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    void handleSchedule(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/Schedule.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    void handlegoBack(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/DefaultPage.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
