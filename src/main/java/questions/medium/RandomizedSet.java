package questions.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) locs.put( val, new HashSet<Integer>() );

        locs.get(val).add(nums.size());

        nums.add(val);
        return !contain ;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1 ) {
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.get(lastone).remove(nums.size() - 1);
            locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);
        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
