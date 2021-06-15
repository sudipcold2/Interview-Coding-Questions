package questions.medium;

/**
 *
 *
 * Numbers:     2    3    4     5
 * Lefts:       1    2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5     1
 */
public class ProductOfArrayExceptItSelf {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];

        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            res[j] = res[j] * right;
            right = right * nums[j];
        }

        return res;
    }
}
