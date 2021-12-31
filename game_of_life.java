/*

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int currentCell = board[i][j];
                System.out.println("Current cell " + currentCell + " ------------------------------------");
                
                int numberOfLive = 0;
                
                if((j - 1) > -1) {
                    // System.out.println("Cell in behind " + board[i][(j-1)]);
                    numberOfLive += board[i][j-1];
                }
                
                if((j+1) < board[i].length ){
                    // System.out.println("Cell in front " + board[i][j+1]);
                    numberOfLive += board[i][j+1];
                }
                
                if((i - 1) >= 0) {
                    // System.out.println("Cell directly above " + board[i - 1][j]);
                    numberOfLive += board[i - 1][j];    
                    
                    if((j - 1) >= 0) {
                        // System.out.println("Cell diagonal up-left " + board[i - 1][j-1]);
                        numberOfLive += board[i - 1][j-1];
                    }
                    
                    if((j+1) < board[i].length ){
                        // System.out.println("Cell diagonal up-right " + board[i - 1][j+1]);
                        numberOfLive += board[i - 1][j+1];
                    }
                }
                
                if((i + 1) < board.length) {
                    // System.out.println("Cell directly below " + board[i + 1][j]);
                    numberOfLive += board[i + 1][j];
                    
                    if((j - 1) >= 0) {
                        // System.out.println("Cell diagonal down-left " + board[i + 1][j-1]);
                        numberOfLive += board[i + 1][j-1];
                    }
                    
                    if((j+1) < board[i].length ){
                        // System.out.println("Cell diagonal down-right " + board[i + 1][j+1]);
                        numberOfLive += board[i + 1][j+1];
                    }
                }
                
                System.out.println("Answer: " + numberOfLive);
                
                if(currentCell == 1){
                    System.out.println("Alive Cell");
                    if(numberOfLive == 2 || numberOfLive ==3) {
                        System.out.println("Current cell: " + currentCell + " on row: " + i + " on column: " + j + " should be 1");
                       newBoard[i][j] = 1;
                   } else {
                       newBoard[i][j] = 0;
                        System.out.println("Current cell: " + currentCell + " on row: " + i + " on column: " + j + " should be 0");
                   }
                }else {
                    System.out.println("Dead Cell");
                    if(numberOfLive == 3) {
                        newBoard[i][j] = 1;
                        System.out.println("Current cell: " + currentCell + " on row: " + i + " on column: " + j + " should be 1");
                    }
                }
                
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
        
    }
}
