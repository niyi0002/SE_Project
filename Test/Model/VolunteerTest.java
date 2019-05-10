package Model;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class VolunteerTest {
    private Volunteer volunteer = new Volunteer();


    private String expectedResult;
    private String actualResult;
    @Test
    public void getBirthday() {
        volunteer.setBirthday(Date.valueOf("1997-02-12"));
        expectedResult = "1997-02-12";
        actualResult = volunteer.getBirthday();
        Assert.assertEquals(expectedResult , actualResult);
    }

    @Test
    public void setBirthday() {
        volunteer.setBirthday(Date.valueOf("1994-09-04"));
        actualResult = volunteer.getBirthday();
        expectedResult = "1994-09-07";
        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void getFirstname() {
        volunteer.setFirstname("Petar");
        expectedResult = "Ayse";
        actualResult = volunteer.getFirstname();
        Assert.assertEquals(expectedResult , actualResult);
    }

    @Test
    public void setFirstname() {
        volunteer.setFirstname("Ayse");
        actualResult = volunteer.getFirstname();
        expectedResult = "Nilay";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getUsername() {
        volunteer.setUsername("nilu");
        expectedResult = "aysa";
        actualResult = volunteer.getUsername();
        Assert.assertEquals(expectedResult , actualResult);
    }

    @Test
    public void setUsername() {
        volunteer.setUsername("niyi0002");
        actualResult = volunteer.getUsername();
        expectedResult = "niyi";
        Assert.assertEquals(expectedResult, actualResult);

    }
}