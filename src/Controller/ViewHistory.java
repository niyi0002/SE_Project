package Controller;


import Database.DatabaseConnection;
import Model.Donation;
import Model.History;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ChangeScene;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewHistory implements Initializable {
    @FXML
    private TableView<History> history;

    @FXML
    private TableColumn<History, Integer> attenedEvents;

    @FXML
    private TableColumn<History, Date> date;

    @FXML
    private TableView<Donation> donationTable;

    @FXML
    private TableColumn<Donation, Date> donatedDate;

    @FXML
    private TableColumn<Donation, Integer> donateAmount;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    ChangeScene cs = new ChangeScene();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection db = new DatabaseConnection();
        String user = VolunteerLogin.getCurrentUser();
        String personID = null;
        try {
            personID = db.getId(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ObservableList<History> eventObservableList = db.historyInfo(personID);
        ObservableList<Donation> eventObservableList2 = db.donationInfo(personID);

        this.attenedEvents.setCellValueFactory(new PropertyValueFactory("eventID"));
        this.date.setCellValueFactory(new PropertyValueFactory("history"));
        this.donateAmount.setCellValueFactory(new PropertyValueFactory("donation"));
        this.donatedDate.setCellValueFactory(new PropertyValueFactory("donationDate"));


        this.history.setItems(eventObservableList);
        this.donationTable.setItems(eventObservableList2);

    }

    @FXML
    private void handleGoBack(ActionEvent event) throws IOException {

        cs.sceneHandler("../View/Profile.fxml",event);

    }
}

