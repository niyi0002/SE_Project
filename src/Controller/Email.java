package Controller;

import Database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class Email implements Initializable {

    @FXML
    private TextField txtTo;
    @FXML
    private TextArea txtMessage;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtFrom;
    DatabaseConnection app = new DatabaseConnection();
    String user=DefaultPage.getCurrentUser();
    private static String emailTitle = "Volunteer Application";


    @FXML
    void sendMessage(ActionEvent event) {
        String reci = txtTo.getText().toString();
        String mess = txtMessage.getText().toString();

        String recipientEmailString = reci;
        String messageToBeSent = mess;

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", txtFrom.getText());
        props.put("mail.smtp.password", txtPassword.getText());
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        Message message = new Message(session) {
            @Override
            public Address[] getFrom() throws MessagingException {
                return new Address[0];
            }

            @Override
            public void setFrom() throws MessagingException {

            }

            @Override
            public void setFrom(Address address) throws MessagingException {

            }

            @Override
            public void addFrom(Address[] addresses) throws MessagingException {

            }

            @Override
            public Address[] getRecipients(RecipientType recipientType) throws MessagingException {
                return new Address[0];
            }

            @Override
            public void setRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {

            }

            @Override
            public void addRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {

            }

            @Override
            public String getSubject() throws MessagingException {
                return null;
            }

            @Override
            public void setSubject(String s) throws MessagingException {

            }

            @Override
            public Date getSentDate() throws MessagingException {
                return null;
            }

            @Override
            public void setSentDate(Date date) throws MessagingException {

            }

            @Override
            public Date getReceivedDate() throws MessagingException {
                return null;
            }

            @Override
            public Flags getFlags() throws MessagingException {
                return null;
            }

            @Override
            public void setFlags(Flags flags, boolean b) throws MessagingException {

            }

            @Override
            public Message reply(boolean b) throws MessagingException {
                return null;
            }

            @Override
            public void saveChanges() throws MessagingException {

            }

            @Override
            public int getSize() throws MessagingException {
                return 0;
            }

            @Override
            public int getLineCount() throws MessagingException {
                return 0;
            }

            @Override
            public String getContentType() throws MessagingException {
                return null;
            }

            @Override
            public boolean isMimeType(String s) throws MessagingException {
                return false;
            }

            @Override
            public String getDisposition() throws MessagingException {
                return null;
            }

            @Override
            public void setDisposition(String s) throws MessagingException {

            }

            @Override
            public String getDescription() throws MessagingException {
                return null;
            }

            @Override
            public void setDescription(String s) throws MessagingException {

            }

            @Override
            public String getFileName() throws MessagingException {
                return null;
            }

            @Override
            public void setFileName(String s) throws MessagingException {

            }

            @Override
            public InputStream getInputStream() throws IOException, MessagingException {
                return null;
            }

            @Override
            public DataHandler getDataHandler() throws MessagingException {
                return null;
            }

            @Override
            public Object getContent() throws IOException, MessagingException {
                return null;
            }

            @Override
            public void setDataHandler(DataHandler dataHandler) throws MessagingException {

            }

            @Override
            public void setContent(Object o, String s) throws MessagingException {

            }

            @Override
            public void setText(String s) throws MessagingException {

            }

            @Override
            public void setContent(Multipart multipart) throws MessagingException {

            }

            @Override
            public void writeTo(OutputStream outputStream) throws IOException, MessagingException {

            }

            @Override
            public String[] getHeader(String s) throws MessagingException {
                return new String[0];
            }

            @Override
            public void setHeader(String s, String s1) throws MessagingException {

            }

            @Override
            public void addHeader(String s, String s1) throws MessagingException {

            }

            @Override
            public void removeHeader(String s) throws MessagingException {

            }

            @Override
            public Enumeration<Header> getAllHeaders() throws MessagingException {
                return null;
            }

            @Override
            public Enumeration<Header> getMatchingHeaders(String[] strings) throws MessagingException {
                return null;
            }

            @Override
            public Enumeration<Header> getNonMatchingHeaders(String[] strings) throws MessagingException {
                return null;
            }
        };

        String[] recipientEmail = new String[]{
                recipientEmailString}; //Change the String into a String[]
        try {
            message.setFrom(new InternetAddress(txtFrom.getText()));

            InternetAddress[] toAddress = new InternetAddress[recipientEmail.length];
            // To get the array of addresses
            for (int i = 0; i < recipientEmail.length; i++) {
                toAddress[i] = new InternetAddress(recipientEmail[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(emailTitle);
            message.setText(messageToBeSent);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, txtFrom.getText(), txtPassword.getText());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
        System.out.println("email sent");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            txtFrom.setText(app.getEmail(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
