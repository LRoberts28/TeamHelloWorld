package HrApp;

public class Helper {
    public static Person validateLogin(String username, char[] password) {
        for (Person user : TempArrays.getAllUsers()) {
            if (user.getEmail().equals(username)
                    && charArrayToString(user.getPassword()).equals(charArrayToString(password))) {
                return user;
            }
        }
        return null;
    }

    public static char[] stringToCharArray(String str) {
        // Create a char array with the same length as the string
        char[] charArray = new char[str.length()];

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Assign each character to the corresponding index in the char array
            charArray[i] = str.charAt(i);
        }

        // Return the char array
        return charArray;
    }

    public static String charArrayToString(char[] charArray) {
        // Create a StringBuilder to efficiently build the string
        StringBuilder stringBuilder = new StringBuilder();

        // Append each character from the char array to the StringBuilder
        for (char c : charArray) {
            stringBuilder.append(c);
        }

        // Convert the StringBuilder to a string and return it
        return stringBuilder.toString();
    }

}
