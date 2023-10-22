import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        //for each string, hash based on the characters using arr
        for (String string : strs) {
            int[] arr = new int[26];
            for (char c : string.toCharArray()) {
                arr[c - 'a']++;
            }
            int hash = getHash(arr) + string.length();
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(string);
        }

        List<List<String>> result = new ArrayList<List<String>>(map.values());

        return result;
    }

    public static int getHash(int[] arr) {
        int multiplier = 1;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i] * multiplier;
            multiplier *= 10;
        }

        return total;
    }
}


