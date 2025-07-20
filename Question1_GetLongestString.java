import java.util.*;

public class Question1_GetLongestString {
    // beginning of the getLongestString
    public static String getLongestString(String[] strings, String characters) {
        // first lets handle the inputs or empty inputs
        try {
            if (characters == null || strings == null) {
                throw new IllegalArgumentException("null inputs not accepted");
            } else if (characters.isEmpty() || strings.length == 0) {
                return "";
            }
            // lets use set of characters to lookup
            Set<Character> validCharacters = new HashSet<>();
            for (int i = 0; i < characters.length(); i++) {
                validCharacters.add(characters.charAt(i));
            }

            // now lets go to longestvalid string
            String longestValidString = "";
            int maxLength = 0;

            for (int i = 0; i < strings.length; i++) {
                if (strings[i] == null) {
                    continue;
                }
                String currentString = strings[i];
                boolean isValid = true;

                // lets check if all charascters are valid
                for (int x = 0; x < currentString.length(); x++) {
                    if (!validCharacters.contains(currentString.charAt(x))) {
                        isValid = false;
                        break;
                    }
                }
                // code below is for checking no repetative characters
                if (isValid) {
                    for (int j = 1; j < currentString.length(); j++) {
                        if (currentString.charAt(j) == currentString.charAt(j - 1)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                // now lets update longest string
                if (isValid && currentString.length() > maxLength) {
                    maxLength = currentString.length();
                    longestValidString = currentString;
                }
            }
            return longestValidString;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return " ";

        }
    }

    // now the code below is for main method where the program execution starts
    public static void main(String[] args) {
        String characters = "ABCD";
        String[] strings = { "AABCD", "ABCDZADC", "ABCDBCA", "ABCDABDCA" };
        String result = getLongestString(strings, characters);
        System.out.println(" The longest valid string is " + result);

    }

}
