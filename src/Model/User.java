package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User {
    private StringProperty idinformation = new SimpleStringProperty(this, "idinformation");
    private StringProperty firstname = new SimpleStringProperty(this, "firstname");
    private StringProperty lastname = new SimpleStringProperty(this, "lastname");
    private StringProperty email = new SimpleStringProperty(this, "email");
    private StringProperty username = new SimpleStringProperty(this, "username");
    private StringProperty password = new SimpleStringProperty(this,"password");
    private StringProperty address = new SimpleStringProperty(this, "address");
    private StringProperty phoneNbr = new SimpleStringProperty(this,"phoneNbr");
    private StringProperty role = new SimpleStringProperty(this,"role");

    public User(StringProperty idinformation ,StringProperty firstname ,StringProperty lastname , StringProperty email
            , StringProperty password , StringProperty username, StringProperty address , StringProperty phoneNbr ,StringProperty role){
        this.idinformation = idinformation;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password ;
        this.address = address ;
        this.phoneNbr = phoneNbr ;
        this.role = role ;

    }

    public User() {

    }

    public void setIdinformation(String idinformation) {
        this.idinformation.set(idinformation);
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr.set(phoneNbr);
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public String getIdinformation() {
        return idinformation.get();
    }

    public String getFirstname() {
        return firstname.get();
    }

    public String getLastname() {
        return lastname.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getPhoneNbr() {
        return phoneNbr.get();
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty idinformationProperty() {
        return idinformation;
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty phoneNbrProperty() {
        return phoneNbr;
    }

    public StringProperty roleProperty() {
        return role;
    }
}
