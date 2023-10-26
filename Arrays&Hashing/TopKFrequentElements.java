import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(arr1, 2)));

        int[] arr2 = new int[] {-1, -1};
        System.out.println(Arrays.toString(topKFrequent(arr2, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        // max heap pq
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        int current = nums[0];
        int frequency = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == current) {
                frequency++;
            } else {
                pq.add(new Pair(current, frequency));
                current = nums[i];
                frequency = 1;
            }

            if(i == nums.length - 1) {
                pq.add(new Pair(current, frequency));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pq.poll().number);
        }

        Integer[] answer = result.toArray(new Integer[0]);
        int[] intAnswer = Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
        return intAnswer;
    }

}

class Pair {
    int number;
    int frequency;

    public Pair(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}
