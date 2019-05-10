package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class Volunteer extends User {

    private StringProperty birthday = new SimpleStringProperty(this, "birthday");

    public Volunteer( StringProperty birthday){

        this.birthday = birthday ;
    }
    public Volunteer(IntegerProperty idinformation, StringProperty firstname, StringProperty lastname, StringProperty email, StringProperty password, StringProperty username , StringProperty birthday , StringProperty role) {

    }
    public Volunteer (){super();}
    public String getBirthday() {
        return birthday.get();
    }
    public void setBirthday(Date birthday) {
        this.birthday.set(String.valueOf(birthday));
    }
    public StringProperty birthdayProperty() {
        return birthday;
    }

    @Override
    public String toString() {
        return  " Volunteer ID "+getIdinformation()+ " Volunteer's name : " +getFirstname()+ " Volunteer's Lastname : "+getLastname()+ " username: " +getUsername()+ " email: " +getEmail()+ " birthday: " +getBirthday()+
                " address: " +getAddress()+ " phone number: " +getPhoneNbr();
    }
}
