package questions.medium;

import java.util.Arrays;

/**
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * You may assume the input array always has a valid answer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,1,1,6,4]
 * Output: [1,6,1,5,1,4]
 * Explanation: [1,4,1,5,1,6] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,3,2,2,3,1]
 * Output: [2,3,1,3,1,2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * It is guaranteed that there will be an answer for the given input nums.
 *
 *
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
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
