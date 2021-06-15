package questions.medium;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        HashSet<Character> set = new HashSet<>();
        int maxWindow = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
            for(int j = i+1; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                }
            }

            if(set.size() > maxWindow){
                maxWindow = set.size();
            }

            set.clear();
        }

        return maxWindow;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
