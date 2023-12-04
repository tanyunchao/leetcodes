import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int[] prefix = new int[nums.length];
        
        // calculate prefix
        for (int i = 0; i < nums.length - 1; i++) {
            pre = pre * nums[i];
            prefix[i] = pre;
        }

        // calculate postfix on original array
        for (int i = prefix.length - 1; i > 0; i--) {
            post = post * nums[i];
            nums[i] = post;
        }

        int[] temp = new int[nums.length];
        for (int i = 0; i < prefix.length; i++) {
            int start = i - 1;
            int end = i + 1;

            int preValue = start >= 0 ? prefix[start] : 1;
            int postValue = end < prefix.length ? nums[end] : 1;
            temp[i] = preValue * postValue;
        }

        return temp;
    }
}
