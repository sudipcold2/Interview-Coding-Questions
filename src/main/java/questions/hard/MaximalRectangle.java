package questions.hard;

import java.util.Stack;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = []
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 4:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 * Example 5:
 *
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 *
 *
 * You can maintain a row length of Integer array H recorded its height of '1's, and scan and
 * update row by row to find out the largest rectangle of each row.
 *
 * For each row, if matrix[row][i] == '1'. H[i] +=1, or reset the H[i] to zero.
 * and accroding the algorithm of [Largest Rectangle in Histogram], to update the maximum area.
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
