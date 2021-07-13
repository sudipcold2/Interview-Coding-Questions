package questions.hard;

/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length == 0)
            return 1;

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            while( curr - 1 >= 0 && curr - 1 < nums.length && curr != nums[curr-1]){
                int next = nums[curr-1];
                nums[curr-1] = curr;
                curr = next;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)
                return i + 1;
        }

        return nums.length+1;
    }
}
