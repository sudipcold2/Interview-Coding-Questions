package questions.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString {

    public static void reverseString(char s[]){
        for(int i=0; i < s.length/2; i++){    //Do it half the number of String length
            char tmp = s[i];
            s[i] = s[s.length-1-i];     //Front swap with other End side
            s[s.length-1-i] = tmp;      //End swap with other Front side
        }
    }

    public static void main(String[] args) {
        char[] test = "sudip".toCharArray();
        reverseString(test);
        System.out.println(test);

        final String reversed = new StringBuilder("sudip").reverse().toString();
        System.out.println(reversed);
    }
}
