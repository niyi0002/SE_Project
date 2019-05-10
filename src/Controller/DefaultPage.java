package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.ChangeScene;

import java.io.IOException;

public class DefaultPage {
    @FXML
    private Button signIn;
    @FXML
    private Button signUp;
    @FXML
    private Button aboutUs;

    ChangeScene cs = new ChangeScene();

    @FXML
    private void handleSignIn (ActionEvent event) throws IOException {

        cs.sceneHandler("../View/AdminOrUser.fxml",event);

    }

    @FXML
    private void handleSignUp(ActionEvent event) throws IOException {

        cs.sceneHandler("../View/SignUp.fxml",event);

    }

    @FXML
    private void handleAboutUs(ActionEvent event) throws IOException {

        cs.sceneHandler("../View/AboutUs.fxml",event);

    }

}
