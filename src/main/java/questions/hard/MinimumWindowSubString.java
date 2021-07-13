package questions.hard;

/**
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 *
 *
 */
public class MinimumWindowSubString {

    /**
     * General Template
     */
    //    int findSubstring(string s){
    //        vector<int> map(128,0);
    //        int counter; // check whether the substring is valid
    //        int begin=0, end=0; //two pointers, one point to tail and one  head
    //        int d; //the length of substring
    //
    //        for() { /* initialize the hash map here */ }
    //
    //        while(end<s.size()){
    //
    //            if(map[s[end++]]-- ?){  /* modify counter here */ }
    //
    //            while(/* counter condition */){
    //
    //                /* update d here if finding minimum*/
    //
    //                //increase begin to make it invalid/valid again
    //
    //                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
    //            }
    //
    //            /* update d here if finding maximum*/
    //        }
    //        return d;
    //    }


    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0)
                counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubString obj = new MinimumWindowSubString();
        final String s = obj.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }


}


