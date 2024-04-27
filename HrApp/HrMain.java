package HrApp;

public class HrMain {
    public static void main(String[] args) 
    {
        SetUp();

        LoginPage loginPage = new LoginPage(); //sets up login page 

    }
    public static void SetUp()
    {
        //Establishing all the employees in TempArrays
        TempArrays.addUser(new Employee("Jake Puckett", (short)21, "JPuckett2@msu.net", Helper.stringToCharArray("password"), "121, Generic Street, Town, KY", "120-102-3421", "Code Tester", 20));
        TempArrays.addUser(new Employee("Jack Ray", (short)20, "JRay1@msu.net", Helper.stringToCharArray("password"), "122, Generic Street, Town, KY", "120-102-1234", "Code Tester", 3));
        TempArrays.addUser(new Employee("Michael Jackson", (short)45, "MJackson1@msu.net", Helper.stringToCharArray("password"), "123, Generic Street, Town, KY", "120-102-2345", "Code Tester", 20));
        TempArrays.addUser(new Employee("Jason Puckett", (short)52, "JPuckett1@msu.net", Helper.stringToCharArray("password"), "124, Generic Street, Town, KY", "120-102-3456", "Code Tester", 35));
        TempArrays.addUser(new Employee("Charlize Klay", (short)19, "CKlay1@msu.net", Helper.stringToCharArray("password"), "125, Generic Street, Town, KY", "120-102-5678", "Code Tester", 20));
        TempArrays.addUser(new Employee("Stuart Thea", (short)55, "SThea1@msu.net", Helper.stringToCharArray("password"), "126, Generic Street, Town, KY", "120-102-5687", "Code Tester", 12));
        TempArrays.addUser(new Employee("Mason Myers", (short)31, "MMyers1@msu.net", Helper.stringToCharArray("password"), "127, Generic Street, Town, KY", "120-102-4335", "Code Tester", 19));
        TempArrays.addUser(new Employee("Sam Cromwell", (short)47, "SCromwell1@msu.net", Helper.stringToCharArray("password"), "128, Generic Street, Town, KY", "120-102-2764", "Code Tester", 12));
        TempArrays.addUser(new Employee("Tyler Reed", (short)21, "TReed1@msu.net", Helper.stringToCharArray("password"), "129, Generic Street, Town, KY", "120-102-4528", "Code Tester", 55));
        TempArrays.addUser(new Employee("Madison Rowe", (short)21, "MRowe1@msu.net", Helper.stringToCharArray("password"), "130, Generic Street, Town, KY", "120-102-9752", "Code Tester", 1));

        //Establishing all managers in TempArrays
        TempArrays.addUser(new Manager(new Employee("Alex Rhea", (short)21, "ARhea1@msu.net", Helper.stringToCharArray("password"), "131, Generic Street, Town, KY", "120-102-3144", "Code Tester", 7000)));
    }
}