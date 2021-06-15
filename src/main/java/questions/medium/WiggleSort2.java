package questions.medium;

import java.util.Arrays;

public class WiggleSort2 {

    public void wiggleSort(int[] nums) {
        int a[] = new int[nums.length];

        Arrays.sort(nums);

        int i = (nums.length-1)/2;
        int j = nums.length-1;

        for(int k=0;k<nums.length;k++) {
            if(k%2 == 0) {
                a[k] = nums[i];
                i--;
            }
            else {
                a[k] = nums[j];
                j--;
            }
        }

        for(i=0;i<nums.length;i++)
            nums[i] = a[i];
    }


}
