package TwoPointers;

public class ValidPalidrome {
    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String arr = s.toLowerCase();
        int start = 0;
        int end = arr.length() - 1;
        while (start < end) {
            if(!Character.isLetterOrDigit(arr.charAt(start))) {
                start++;
                continue;
            } 
            if(!Character.isLetterOrDigit(arr.charAt(end))) {
                end--;
                continue;
            } 

            if (arr.charAt(start) != arr.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
