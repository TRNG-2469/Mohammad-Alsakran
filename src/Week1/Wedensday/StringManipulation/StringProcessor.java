package Week1.Wedensday.StringManipulation;

import java.util.*;

public class StringProcessor {

    public static String reverse(String input) {
        if (input == null) { return ""; }
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }


    public static int countVowels(String input){
        if (input == null) {
            return 0;
        }
        input = input.toLowerCase();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String input) {
        if (input == null) { return false; }
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(input.charAt(left))) { left++; continue; }
            if (!Character.isLetterOrDigit(input.charAt(right))) { right--; continue; }
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) { return false; }
            left++;
            right--;
        }
        return true;
    }


    public static String AIreverse(String input) {
        if (input == null) {
            return "";
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static int AiCountVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : input.toLowerCase().toCharArray()) {
            if (vowels.contains(ch)) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
        }
        int total = 0;
        for (int v : counts.values()) {
            total += v;
        }
        return total;
    }

    public static boolean AIisPalindrome(String input) {
        if (input == null) {
            return false;
        }
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            char l = input.charAt(left);
            if (!Character.isLetterOrDigit(l)) { left++; continue; }
            char r = input.charAt(right);
            if (!Character.isLetterOrDigit(r)) { right--; continue; }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) { return false; }
            left++;
            right--;
        }
        return true;
    }

}
