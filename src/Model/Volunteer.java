package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.User;

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
        return  " ID : "+getIdinformation()+ "\n Firstname : " +getFirstname()+ "\n Lastname : "+getLastname()+ "\n Username : " +getUsername()+ "\n Email : " +getEmail()+ "\n Birthday : " +getBirthday()+
                "\n Address : " +getAddress()+ "\n Phone Number : " +getPhoneNbr();
    }
}
