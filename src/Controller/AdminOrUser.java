package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminOrUser {
    @FXML
    private Button volunteer;

    @FXML
    private Button admin;

    @FXML
    private Button goBack;


    Stage dialogStage = new Stage();
    Scene scene ;
    @FXML
    private void handleAdminSignIn(ActionEvent event) {

        try {
            Node node = (Node) event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../View/AdminLogin.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleVolunteerSignIn(ActionEvent event) {

        try {
            Node node = (Node) event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../View/VolunteerLogin.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleGoBack(ActionEvent event) {

        try {
            Node node = (Node) event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../View/DefaultPage.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
