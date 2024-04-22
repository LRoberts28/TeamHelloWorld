package HrApp;

public class Helper {
    public static Person validateLogin(String username, char[] password)
    {
        for(Person user : TempArrays.getAllUsers())
        {
            if(user.getEmail().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }
}
