package Controller;

import Database.DatabaseConnection;
import Model.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SignUp {

    @FXML
    private DatePicker birthday;
    @FXML
    private Label idLabel ;
    @FXML
    private Label labelFirstName ;
    @FXML
    private Label labelLastName ;
    @FXML
    private Label labelUsername ;
    @FXML
    private Label labelEmail ;
    @FXML
    private Label labelPassword ;
    @FXML
    private Label birthdayText ;
    @FXML
    private Label skill;
    @FXML
    private TextField skill1;
    @FXML
    private TextField firstName ;
    @FXML
    private TextField lastName ;
    @FXML
    private TextField email ;
    @FXML
    private TextField username ;
    @FXML
    private TextField id ;
    @FXML
    private PasswordField password ;
    @FXML
    private Button register ;
    @FXML
    private Button cancel ;
    @FXML
    private Label phoneLabel;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNbr;
    @FXML
    private Label addressLabel;
    Stage dialogStage = new Stage();
    Scene scene;

    @FXML
    private void handleRegister(ActionEvent event) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(birthday.getValue());
        // insert three new rows
        Volunteer volunteer = new Volunteer();
        volunteer.setIdinformation(id.getText());
        volunteer.setUsername(username.getText());
        volunteer.setPassword(password.getText());
        volunteer.setFirstname(firstName.getText());
        volunteer.setLastname(lastName.getText());
        volunteer.setEmail(email.getText());
        volunteer.setAddress(address.getText());
        volunteer.setPhoneNbr(phoneNbr.getText());
        volunteer.setSkill(skill1.getText());
        volunteer.setBirthday(gettedDatePickerDate);
        volunteer.setRole("volunteer");
        db.signUpVolunteer(volunteer);

    }
    @FXML
    private void handleCancel(ActionEvent event){
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
