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


}
