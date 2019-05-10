package Database;

import Model.Donation;
import Model.Event;
import Model.History;
import Model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    Stage dialogStage = new Stage();
    Scene scene;

    public static Connection dbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root");
            return con;
        } catch (Exception ex) {
            System.out.println("the connection fails " + ex);
            return null;
        }
    }

    public void signUpVolunteer( Volunteer volunteer) {
        String sql = ""+"INSERT INTO information(idinformation,username,password,firstname,lastname,email,address,phoneNbr,birthday,role) VALUES(?,?,?,?,?,?,?,?,?,?)";


        try (Connection conn = this.dbConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, volunteer.getIdinformation());
            pstmt.setString(2, volunteer.getUsername());
            pstmt.setString(3, volunteer.getPassword());
            pstmt.setString(4, volunteer.getFirstname());
            pstmt.setString(5, volunteer.getLastname());
            pstmt.setString(6, volunteer.getEmail());
            pstmt.setString(7, volunteer.getAddress());
            pstmt.setString(8, volunteer.getPhoneNbr());
            pstmt.setString(9, volunteer.getBirthday());
            pstmt.setString(10, volunteer.getRole());
            pstmt.executeUpdate();
            System.out.println("Volunteer saved into database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUsername(String username) throws SQLException {
        String id = null;

        String query = "select username from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                id = resultSet.getString(1);
            }
        }
        return id;
    }
    public String getFirstName(String username) throws SQLException {
        String firstName = null;

        String query = "select firstname from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                firstName = resultSet.getString(1);
            }
        }
        return firstName;
    }

    public String getLastName(String username) throws SQLException {
        String lastName = null;

        String query = "select lastname from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                lastName = resultSet.getString(1);
            }
        }
        return lastName ;
    }

    public String getEmail(String username) throws SQLException {
        String email = null;

        String query = "select email from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                email = resultSet.getString(1);
            }
        }
        return email ;
    }
    public String getAddress(String username) throws SQLException {
        String address = null;

        String query = "select address from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                address = resultSet.getString(1);
            }
        }
        return address ;
    }
    public String getPhoneNbr(String username) throws SQLException {
        String phoneNbr = null;

        String query = "select phoneNbr from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                phoneNbr = resultSet.getString(1);
            }
        }
        return phoneNbr ;
    }
    public String getBirthday(String username) throws SQLException {
        String birthday = null;

        String query = "select birthday from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                birthday = resultSet.getString(1);
            }
        }
        return birthday ;
    }
    public String getId(String username) throws SQLException {
        String id = null;

        String query = "select idinformation from information where username = '" +username+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                id = resultSet.getString(1);
            }
        }
        return id ;
    }

    public ObservableList<Event> eventInformation(){
        ObservableList<Event>eventList= FXCollections.observableArrayList();
        String query = "select * from event ";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Event event = new Event();
                event.setEventID(resultSet.getInt(1));
                event.setEventName(resultSet.getString(2));
                event.setEventDate(resultSet.getDate(3));
                event.setEventTime(resultSet.getString(4));
                event.setEventInfo(resultSet.getString(5));
                event.setEventOrganizer(resultSet.getString(6));
                event.setCountry(resultSet.getString(7));
                event.setCity(resultSet.getString(8));
                eventList.add(event);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

    public void registerToAnEvent(String userid , int eventid , Event event , Volunteer volunteer){

        String sql = ""+"INSERT INTO information_has_events(eventID,idinformation,history) VALUES(?,?,?)";


        try (Connection conn = this.dbConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, event.getEventID());
            pstmt.setString(2, volunteer.getIdinformation());
            pstmt.setString(3,event.getEventDate());

            pstmt.executeUpdate();
            System.out.println("Volunteer has registered to an event!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String getEventDate(int eventid) throws SQLException {
        String date = null;

        String query = "select eventDate from event where eventid = '" +eventid+"'";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                date = resultSet.getString(1);
            }
        }
        return date ;
    }

    public void insertDonation(String volunteerID , Donation donation , Volunteer volunteer)  {

        String query = ""+"INSERT INTO donation(donationAmount,donationHistory,idinformation) VALUES(?,?,?) ";

        try (Connection conn = this.dbConnect();
             PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setString   (1, donation.getDonation());
            preparedStmt.setString   (2, donation.getDonationDate());
            preparedStmt.setString   (3, volunteer.getIdinformation());

            preparedStmt.executeUpdate();
            System.out.println("Inserted donation!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLastName(String user, Volunteer volunteer)  {

        String sql = "update information set lastname = ?  where username = ?  ";

        try (Connection con = this.dbConnect();
             PreparedStatement preparedStmt = con.prepareStatement(sql)) {

            preparedStmt.setString   (1, volunteer.getLastname());
            preparedStmt.setString(2,user);

            preparedStmt.executeUpdate();
            System.out.println("Lastname updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateAddress(String user, Volunteer volunteer)  {

        String sql = "update information set address = ?  where username = ?  ";

        try (Connection con = this.dbConnect();
             PreparedStatement preparedStmt = con.prepareStatement(sql)) {

            preparedStmt.setString   (1, volunteer.getAddress());
            preparedStmt.setString(2,user);

            preparedStmt.executeUpdate();
            System.out.println(user+"Address updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // execute the java preparedstatement


    }
    public void updatePhoneNbr(String user, Volunteer volunteer)  {

        String sql = "update information set phoneNbr = ?  where username = ?  ";

        try (Connection con = this.dbConnect();
             PreparedStatement preparedStmt = con.prepareStatement(sql)) {

            preparedStmt.setString   (1, volunteer.getPhoneNbr());
            preparedStmt.setString(2,user);

            preparedStmt.executeUpdate();
            System.out.println("Phone number updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // execute the java preparedstatement


    }
    public void updateEmail(String username , Volunteer volunteer)  {

        String query = "update information set email = ? where username = ?";

        try (Connection conn = this.dbConnect();
             PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setString   (1, volunteer.getEmail());
            preparedStmt.setString(2, username);

            preparedStmt.executeUpdate();
            System.out.println("Email updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateFirstName(String username, Volunteer volunteer) throws SQLException {

        String query = "update information set firstname = ? where username = ?";

        try (Connection conn = this.dbConnect();
             PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setString   (1, volunteer.getFirstname());
            preparedStmt.setString(2, username);

            preparedStmt.executeUpdate();
            System.out.println("Firstname updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public ObservableList<History> historyInfo(String userID){

        LocalDate date = LocalDate.now();
        ObservableList<History>eventHistory= FXCollections.observableArrayList();
        String query = "select eventID , history from information_has_events where idinformation = '" +userID+"' and history < '"+date+"'" ;

        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                History history = new History();
                history.setEventID(resultSet.getInt(1));
                history.setHistory(resultSet.getDate(2));

                eventHistory.add(history);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventHistory;
    }
    public ObservableList<Donation> donationInfo(String userID){

        LocalDate date = LocalDate.now();
        ObservableList<Donation>donationHistory= FXCollections.observableArrayList();
        String query = "select donationAmount , donationHistory from donation where idinformation = '" +userID+"'";

        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Donation donation = new Donation();
                donation.setDonation(resultSet.getString(1));
                donation.setDonationDate(resultSet.getDate(2));


                donationHistory.add(donation);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donationHistory;
    }
    public void addEvent( Event event) {
        String sql = ""+"INSERT INTO event(eventID,eventName,eventDate,eventTime,eventInfo,eventOrganizer,country,city) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = this.dbConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, event.getEventID());
            pstmt.setString(2, event.getEventName());
            pstmt.setString(3,event.getEventDate());
            pstmt.setString(4, event.getEventTime());
            pstmt.setString(5,event.getEventInfo());
            pstmt.setString(6,event.getEventOrganizer());
            pstmt.setString(7,event.getCountry());
            pstmt.setString(8,event.getCity());
            pstmt.executeUpdate();
            System.out.println("Event saved into database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ObservableList<Volunteer> volunteerInfo(){
        ObservableList<Volunteer>eventList= FXCollections.observableArrayList();
        String query = "select firstname,lastname,idinformation,username,role,email,birthday,address,phoneNbr from information  ";
        try (Connection connection = this.dbConnect();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Volunteer volunteer = new Volunteer();
                volunteer.setFirstname(resultSet.getString(1));
                volunteer.setLastname(resultSet.getString(2));
                volunteer.setIdinformation(resultSet.getString(3));
                volunteer.setUsername(resultSet.getString(4));
                volunteer.setRole(resultSet.getString(5));
                volunteer.setEmail(resultSet.getString(6));
                volunteer.setBirthday(Date.valueOf(resultSet.getString(7)));
                volunteer.setAddress(resultSet.getString(8));
                volunteer.setPhoneNbr(resultSet.getString(9));
                eventList.add(volunteer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }
}
