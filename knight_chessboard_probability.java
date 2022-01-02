/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. 
The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below.
Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.
    Example 1:

    Input: n = 3, k = 2, row = 0, column = 0
    Output: 0.06250
    Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
    From each of those positions, there are also two moves that will keep the knight on the board.
    The total probability the knight stays on the board is 0.0625.
    
    Example 2:

    Input: n = 1, k = 0, row = 0, column = 0
    Output: 1.00000

*/

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        
        double[][] source = new double[n][n];
        
        source[row][column] = 1.0;
        
        int[] xMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yMoves = { 1,  2, 2, 1,-1,-2, -2, -1};
    
        
        for(int x = 0; x < k; x++) {
            double[][] destination = new double[n][n];
            
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[i].length; j++) {

                    if(source[i][j] == 0.0 ) continue;
                    
                    for(int z = 0; z < xMoves.length; z++){
                        int moveX = xMoves[z] + i;
                        int moveY = yMoves[z] + j;

                        if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) {
                            continue;
                        } else {
                            destination[moveX][moveY] += source[i][j]*0.125;
                        }
                    }

                }
            }
            
            source = destination;
            
        }
        
        double value = 0.0;
        for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[i].length; j++) {
                    System.out.println("found : " + source[i][j]);
                    value += source[i][j];
                }
        }
        
        
        return value;
        
    }
}

/*

Performance:

time complexity: O(nk), n is total no. of cells of the board & k is no. of iterations. 
In every iteration, the time spent on declaring a new destination matrix with O(n) time complexity. Also, iterate all cell on the source matrix need O(n) time

space complexity: O(n), as it is not doing in place, the size of the destination matrix is O(n), n is total no. of cells of the board

*/