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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VolunteerLogin {

    @FXML
    private Button back;

    @FXML
    private Button handleLogin;

    @FXML
    private TextField handleUsername;

    @FXML
    private PasswordField handlePassword;

    @FXML
    private Label labelStatus;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Stage dialogStage = new Stage();
    Scene scene ;
    private static String currentUser ;

    public VolunteerLogin() {
        connection = (Connection) DatabaseConnection.dbConnect();

    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("../View/DefaultPage.fxml")));
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    void handleLoginButton(ActionEvent event) {

        Volunteer volunteer = new Volunteer();
        String userName = handleUsername.getText();
        String password1 = handlePassword.getText();
        volunteer.setUsername(userName);
        volunteer.setPassword(password1);
        String roles = "volunteer";

        String sql = "SELECT * FROM information WHERE username = ? and password = ? and role = ? ";

        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, volunteer.getUsername());
            preparedStatement.setString(2, volunteer.getPassword());
            preparedStatement.setString(3,roles);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                alertBox();
            } else {
                System.out.println(volunteer.getUsername()+" logged in.");
                setCurrentUser(userName);
                Node node = (Node) event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("../View/VolunteerMenu.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void alertBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Error");
        alert.setHeaderText("Error Message: ");
        alert.setContentText("Username or password doesn't match !");

        alert.showAndWait();
    }
    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentMethodUser) {
        currentUser = currentMethodUser;
    }
}
