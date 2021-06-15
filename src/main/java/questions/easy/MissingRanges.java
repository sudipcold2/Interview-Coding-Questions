package questions.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for (int num : nums) {
            if (lower == Integer.MAX_VALUE)
                return res;
            if (num < next) {
                continue;
            }
            if (num == next) {
                next++;
                continue;
            }
            res.add(getRange(next, num - 1));
            if (num == Integer.MAX_VALUE)
                return res;
            next = num + 1;
        }

        if (next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }

    public String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d" , n1, n2);
    }
}
