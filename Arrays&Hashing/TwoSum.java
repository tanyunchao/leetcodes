import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        ArrayList<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(i, nums[i]));
        }
        Collections.sort(pairs);

        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int sum = pairs.get(i).value + pairs.get(j).value;
            if (sum == target) {
                result[0] = pairs.get(i).index;
                result[1] = pairs.get(j).index;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    } 
}

class Pair implements Comparable<Pair> {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}