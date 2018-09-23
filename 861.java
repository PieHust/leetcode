//We have a two dimensional matrix A where each value is 0 or 1.
//
//A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
//
//After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
//
//Return the highest possible score.
//
// 
//
//Example 1:
//
//Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//Output: 39
//Explanation:
//Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
// 
//
//Note:
//
//1 <= A.length <= 20
//1 <= A[0].length <= 20
//A[i][j] is 0 or 1.
class Solution {
    public int matrixScore(int[][] A) {
        int sum = 0;
        sum += (1 << (A[0].length - 1)) * A.length;

        for (int k = 0; k < A.length; k++) {
            if (A[k][0] == 0) {
                for (int m = 0; m < A[0].length; m++) {
                    A[k][m] = 1 - A[k][m];
                }
            }
        }

        for (int i = 1; i < A[0].length; i++) {
            int tmp = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 0) tmp++;
            }
            
            sum += (1 << (A[0].length - 1 - i)) * Math.max(tmp, A.length - tmp);
        }
        return sum;
    }
}
