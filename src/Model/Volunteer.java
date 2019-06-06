package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.User;

import java.sql.Date;

public class Volunteer extends User {

    private StringProperty birthday = new SimpleStringProperty(this, "birthday");
    private StringProperty skill = new SimpleStringProperty(this,"skill");
    private StringProperty balance = new SimpleStringProperty(this, "balance");

    public Volunteer( StringProperty birthday,StringProperty skill,StringProperty balance){

        this.birthday = birthday ;
        this.skill = skill;
        this.balance= balance;
    }
    public Volunteer(IntegerProperty idinformation, StringProperty firstname, StringProperty lastname, StringProperty email, StringProperty password, StringProperty username , StringProperty birthday , StringProperty role) {

    }
    public Volunteer (){super();}
    public String getBirthday() {
        return birthday.get();
    }
    public String getSkill(){return skill.get();}
    public void setBirthday(Date birthday) {
        this.birthday.set(String.valueOf(birthday));
    }

    public void setSkill(String skill) {
        this.skill.set(skill);
    }

    public StringProperty birthdayProperty() {
        return birthday;
    }

    public StringProperty skillProperty() {
        return skill;
    }

    public String getBalance() {
        return balance.get();
    }

    public StringProperty balanceProperty() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance.set(balance);
    }
    @Override
    public String toString() {
        return  " ID : "+getIdinformation()+ "\n Firstname : " +getFirstname()+ "\n Lastname : "+getLastname()+ "\n Username : " +getUsername()+ "\n Email : " +getEmail()+ "\n Birthday : " +getBirthday()+
                "\n Address : " +getAddress()+ "\n Phone Number : " +getPhoneNbr()+ "\n Skills : " +getSkill()+ "\n Balance: " + getBalance();
    }
}
