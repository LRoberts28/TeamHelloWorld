package HrApp;

import java.awt.EventQueue;
import java.util.Locale;

public class HrMain {
    public static void main(String[] args) 
    {
        SetUp();

        LoginPage loginPage = new LoginPage();

    }
    public static void SetUp()
    {
        //Establishing all the people in TempArrays
        TempArrays.addUser(new Person("Jake Puckett", 21, "JPuckett2@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Jack Ray", 20, "JRay1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Michael Jackson", 45, "MJackson1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Jason Puckett", 52, "JPuckett1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Charlize Klay", 19, "CKlay1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Stuart Thea", 55, "SThea1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Mason Myers", 31, "MMyers1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Sam Cromwell", 47, "SCromwell1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Tyler Reed", 21, "TReed1@msu.net", Helper.stringToCharArray("password")));
        TempArrays.addUser(new Person("Madison Rowe", 21, "MRowe1@msu.net", Helper.stringToCharArray("password")));
    }
}