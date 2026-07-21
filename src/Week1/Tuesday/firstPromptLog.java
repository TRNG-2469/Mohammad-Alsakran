package Week1.Tuesday;

public class firstPromptLog {

    /**
     * Checks if a string is a palindrome by removing non-alphanumeric characters
     * and ignoring case.
     * 
     * @param input the string to check
     * @return true if the input (after filtering) is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        
        int left = 0;
        int right = input.length() - 1;
        
        while (left < right) {
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);
            
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}








