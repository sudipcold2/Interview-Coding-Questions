package questions.hard;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 */
public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for(int j = 1; j < n + 1; j++){
            if(pc[j - 1] == '*')
                dp[0][j] = dp[0][j - 1];
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(pc[j - 1] == sc[i - 1] || pc[j - 1] == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc[j - 1] == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

}
