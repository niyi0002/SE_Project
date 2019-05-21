package Controller;

import Database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Profile implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label emailL;

    @FXML
    private Label phoneNbrL;

    @FXML
    private Button editProfile;

    @FXML
    private Button history;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Button goBack;

    @FXML
    private ImageView imageView;

    @FXML
    private Label username;

    @FXML
    private Label birthday;

    @FXML
    private Label usernameL;

    @FXML
    private Label firstNameL;

    @FXML
    private Label lastNameL;

    @FXML
    private Label addressL;

    @FXML
    private Label birthdayL;

    ChangeScene cs = new ChangeScene();
    DatabaseConnection databaseConnection = new DatabaseConnection();
    String user = DefaultPage.getCurrentUser();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Image image = new Image(new FileInputStream("src/icons/download.jpg"));
            imageView.setImage(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            firstNameL.setText(databaseConnection.getFirstName(user));

            lastNameL.setText(databaseConnection.getLastName(user));

            emailL.setText(databaseConnection.getEmail(user));

            addressL.setText(databaseConnection.getAddress(user));

            phoneNbrL.setText(databaseConnection.getPhoneNbr(user));

            usernameL.setText(databaseConnection.getUsername(user));

            birthdayL.setText(databaseConnection.getBirthday(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleEditProfile(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/EditProfile.fxml",event);
    }

    @FXML
    void handleGoBack(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/VolunteerMenu.fxml",event);
    }

    @FXML
    void handleViewHistory(ActionEvent event) throws IOException {

        cs.sceneHandler("../View/ViewHistory.fxml",event);
    }
}
