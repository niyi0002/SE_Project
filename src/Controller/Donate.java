package Controller;


import Database.DatabaseConnection;
import Model.Donation;
import Model.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.ChangeScene;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Donate {

    @FXML
    private TextField amount;

    @FXML
    private Label titleLabel;

    @FXML
    private Button donate;

    @FXML
    private Label infoLabel;

    @FXML
    private Button goBack;

    ChangeScene cs = new ChangeScene();


    @FXML
    void handleDonate(ActionEvent event) throws SQLException {

        LocalDate date = LocalDate.now();
        Donation donation = new Donation();
        Volunteer volunteer = new Volunteer();
        DatabaseConnection db = new DatabaseConnection();
        String user = DefaultPage.getCurrentUser();
        String volunteerID = db.getId(user);
        volunteer.setIdinformation(volunteerID);

        donation.setDonation(amount.getText());
        donation.setDonationDate(Date.valueOf(date));
        db.insertDonation( donation, volunteer);
        alertBox();


    }

    @FXML
    void handleGoBack(ActionEvent event) throws IOException {
        cs.sceneHandler("../View/VolunteerMenu.fxml",event);
    }
    private void alertBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Donation Successful");
        alert.setContentText("Thank you for your participation");

        alert.showAndWait();
    }

}
