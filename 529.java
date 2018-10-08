//Let's play the minesweeper game (Wikipedia, online game)!
//
//You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
//
//Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
//
//If a mine ('M') is revealed, then the game is over - change it to 'X'.
//If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.
//Example 1:
//
//Input: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//Output: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        char cl = board[click[0]][click[1]];
        switch (cl) {
            case 'M': 
                board[click[0]][click[1]] = 'X'; return board;
            case 'E':
                int nums = hasMines(board, click);
                if (nums > 0) {
                    board[click[0]][click[1]] = (char)(nums + '0');
                    return board;
                } else {
                    board[click[0]][click[1]] = 'B';
                    int i1 = click[0] == 0 ? 0 : click[0] - 1;
                    int j1 = click[1] == 0 ? 0 : click[1] - 1;
                    int i2 = click[0] == board.length - 1 ? click[0] : click[0] + 1;
                    int j2 = click[1] == board[0].length - 1 ? click[1] : click[1] + 1;
                    for (int i = i1; i <= i2; i++) {
                        for (int j = j1; j <= j2; j++) {
                            if (i != click[0] || click[1] != j) {
                                //System.out.println("click " + i + " " + j);
                                int[] c = new int[2];
                                c[0] = i;
                                c[1] = j;
                                updateBoard(board, c);
                            }
                        }
                    }
                }
                
            default: return board;
        }
    }
    
    private int hasMines(char[][] board, int[] click) {
        int i1 = click[0] == 0 ? 0 : click[0] - 1;
       // System.out.println(i1);
        int j1 = click[1] == 0 ? 0 : click[1] - 1;
       // System.out.println(j1);
        int i2 = click[0] == board.length - 1 ? click[0] : click[0] + 1;
       // System.out.println(i2);
        int j2 = click[1] == board[0].length - 1 ? click[1] : click[1] + 1;
       // System.out.println(j2);
        int num = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
          //      System.out.println("" + i + " " + j);
                if (board[i][j] == 'M' || board[i][j] == 'X') {
                    num++;
         //           System.out.println("dfadsf" + num);
                }
            }
        //    System.out.println("dfadsf" + num);
        }   
        return num;     
    }
   
}
