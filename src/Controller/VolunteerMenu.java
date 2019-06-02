package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.ChangeScene;

import java.io.IOException;

public class VolunteerMenu {

    @FXML
    private Label displayMessagae;

    @FXML
    private Button signout;

    @FXML
    private Button event;

    @FXML
    private Button profile;

    @FXML
    private Button schedule;

    @FXML
    private Button donate;


    ChangeScene cs = new ChangeScene() ;

    @FXML
    void handleDonate(ActionEvent event) throws IOException {
       cs.sceneHandler("../View/Donate.fxml",event);
    }

    @FXML
    void handleEvent(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/Events.fxml",event);
    }

    @FXML
    void handleProfile(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/Profile.fxml",event);
    }

    @FXML
    void handleSchedule(ActionEvent event) throws IOException {
       cs.sceneHandler("../View/Schedules.fxml",event);
    }

    @FXML
    void handlegoBack(ActionEvent event) throws IOException {
     cs.sceneHandler("../View/DefaultPage.fxml",event);
    }

    public void handleViewHistory(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/ViewHistory.fxml",event);
    }
}
