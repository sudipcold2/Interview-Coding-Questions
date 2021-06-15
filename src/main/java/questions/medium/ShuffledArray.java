package questions.medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffledArray {
    int[] nums;
    private Random random;

    public ShuffledArray(int[] nums) {
        this.nums= nums;
        random = new Random();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int a[] = nums.clone();
        for(int j = 1; j < nums.length; j++){
            int r = random.nextInt(j + 1);
            int t = a[j];
            a[j]=a[r];
            a[r]=t;
        }
        return a;
    }
}
