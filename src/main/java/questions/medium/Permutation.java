package questions.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        backtrack(ret, new ArrayList<>(), new HashSet<>(), nums);

        return ret;

    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tmpList, Set<Integer> tmpSet, int[] nums) {
        if (tmpSet.size() == nums.length) {
            ret.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmpSet.contains(nums[i])) continue;

            tmpSet.add(nums[i]);
            tmpList.add(nums[i]);

            backtrack(ret, tmpList, tmpSet, nums);

            tmpSet.remove(tmpList.get(tmpList.size()-1));
            tmpList.remove(tmpList.size()-1);
        }
    }

}
