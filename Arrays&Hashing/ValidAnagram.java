import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s  = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // put all characters of s into a hashmap
        // iterate through t and remove characters from hashmap
        // if hashmap is empty, return true
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            letters[c - 'a']--;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
