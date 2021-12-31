//Removing Comments

/*

Given a C++ program, remove comments from it. The program source is an array of strings source where source[i] is the ith line of the source code. This represents the result of splitting the original source code string by the newline character '\n'.

In C++, there are two types of comments, line comments, and block comments.

The string "//" denotes a line comment, which represents that it and the rest of the characters to the right of it in the same line should be ignored.
The string "/*" denotes a block comment, which represents that all characters until the next (non-overlapping) occurrence of "" should be ignored. (Here, occurrences happen in reading order: line by line from left to right.) To be clear, the string " does not yet end the block comment, as the ending would be overlapping the beginning.
The first effective comment takes precedence over others.

For example, if the string "//" occurs in a block comment, it is ignored.
Similarly, if the string "/*" occurs in a line or block comment, it is also ignored.
If a certain line of code is empty after removing comments, you must not output that line: each string in the answer list will be non-empty.

There will be no control characters, single quote, or double quote characters.

For example, source = "string s = "/* Not a comment. *\/";" will not be a test case.
Also, nothing else such as defines or macros will interfere with the comments.

It is guaranteed that every open block comment will eventually be closed, so "/*" outside of a line or block comment always starts a new comment.

Finally, implicit newline characters can be deleted by block comments. Please see the examples below for details.

After removing the comments from the source code, return the source code in the same format.

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

