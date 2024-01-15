public class StringOps {
    ////////////////////////////////////////////////////////////
    ////// ///////
    ////// Reminder: ///////
    ////// allowed methods ///////
    ////// ///////
    ////// 1.charAt(int index) ///////
    ////// 2.length() ///////
    ////// 3.substring(int start) ///////
    ////// 4.substring(int start,int ends) ///////
    ////// 5.indexOf(String str) ///////
    ////// ///////
    ////// The rest are not allowed ! ///////
    ////// if you want to use a different ///////
    ////// method, and you can implement ///////
    ////// it using material from the course ///////
    ////// you need to implement a version of ///////
    ////// the function by yourself. ///////
    ////// ///////
    ////// see example for substring ///////
    ////// in Recitation 3 question 5 ///////
    ////// ///////
    ////////////////////////////////////////////////////////////
    public static char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };
    public static int NUM_VOWELS = VOWELS.length;

    public static void main(String[] args) {
        System.out.println(camelCase("  tWo     wordS"));
    }

    public static String capVowelsLowRest(String string) {
        // Write your code here:
        char c;
        String new_string = "";
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (isVowel(c)) {
                c -= 32;
            } else {
                if (c >= 65 && c <= 90) {
                    c += 32;
                }
            }
            new_string += c;
        }
        return new_string;
    }

    public static boolean isVowel(char c) {
        for (int i = 0; i < NUM_VOWELS; i++) {
            if (c == VOWELS[i]) {
                return true;
            }
        }
        return false;
    }

    public static String camelCase(String string) {
        // Write your code here:
        String new_string = "";
        boolean after_space = false;
        char rel_char;
        string = removeSpaces(string);
        if (string.charAt(0) <= 'Z') {
            new_string += (char) (string.charAt(0) + 32);
        } else {
            new_string += string.charAt(0);
        }
        for (int i = 1; i < string.length(); i++) {
            rel_char = string.charAt(i);
            if (!(rel_char == ' ')) {
                if (!after_space && rel_char <= 'Z') {
                    rel_char += (char) 32;
                }
                if (after_space && rel_char >= 'a') {
                    rel_char -= (char) 32;
                    after_space = false;
                }
                new_string += rel_char;
            } else {
                after_space = true;
            }
        }
        return new_string;
    }

    public static String removeSpaces(String string) {
        int i = 0;
        while (string.charAt(i) == ' ') {
            i++;
        }
        return string.substring(i);
    }

    public static int[] allIndexOf(String string, char chr) {
        // Write your code here:
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                counter++;
            }
        }
        int[] index_of = new int[counter];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                index_of[index] = i;
                index++;
            }
        }
        return index_of;
    }
}
