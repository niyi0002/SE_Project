package Controller;

import Database.DatabaseConnection;
import Model.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditProfile implements Initializable {

    @FXML
    private TextField emailF;

    @FXML
    private TextField lastNameF;

    @FXML
    private TextField firstNameF;

    @FXML
    private Button edit;

    @FXML
    private Button back;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    ChangeScene cs = new ChangeScene();

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/Profile.fxml",event);
    }

    @FXML
    void handleEdit(ActionEvent event) throws SQLException {

        DatabaseConnection db = new DatabaseConnection();
        Volunteer volunteer = new Volunteer();
        String user =  Controller.VolunteerLogin.getCurrentUser();
        System.out.println(user);

        if (!emailF.getText().equals("")) {
            volunteer.setEmail(emailF.getText());
            db.updateEmail(user, volunteer);
        }
        if (!lastNameF.getText().equals("")){
            volunteer.setLastname(lastNameF.getText());
            db.updateLastName(user,volunteer);
        }
        if (!firstNameF.getText().equals("")){
            volunteer.setFirstname(firstNameF.getText());
            db.updateFirstName(user,volunteer);
        }
        if (!address.getText().equals("")){
            volunteer.setAddress(address.getText());
            db.updateAddress(user,volunteer);
        }
        if (!phone.getText().equals("")){
            volunteer.setPhoneNbr(phone.getText());
            db.updatePhoneNbr(user,volunteer);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DatabaseConnection db = new DatabaseConnection();
        String user =  Controller.VolunteerLogin.getCurrentUser();

        try {
            Image image = new Image(new FileInputStream("src/icons/download.jpg"));
            imageView.setImage(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            firstNameF.setText(db.getFirstName(user));

            lastNameF.setText(db.getLastName(user));

            emailF.setText(db.getEmail(user));

            address.setText(db.getAddress(user));

            phone.setText(db.getPhoneNbr(user));
        }
        catch (SQLException s){

        }

    }

}
