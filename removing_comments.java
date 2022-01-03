import java.util.ArrayList;
import java.util.List;

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

class RemovingCommentsSolutions {
    public List<String> removeComments(String[] source) {
        
        List<String> newList = new ArrayList();        
        boolean inScope = true;
        
        StringBuilder str = new StringBuilder();

        for(int i =0; i < source.length; i++){
            char[] charArray = source[i].toCharArray();
            int m = charArray.length;
            int j = 0;
            
            while(j < m) {
                if(inScope && (j + 1)< m && source[i].substring(j, j+2).equals("/*")) {
                    inScope = false;
                    j += 2;
                    
                    System.out.println("Encountered /*");
                } else if(inScope && (j+1) < m && source[i].substring(j, j+2).equals("//")) {
                    addTolist(str, newList);
                    
                    System.out.println("Encountered // skipped line");
                    break;
                } else if(inScope){
                    str.append(charArray[j]);
                    
                    if(j == m-1){
                       addTolist(str, newList); 
                    }
                    
                    j++;
                } else if(!inScope && (j+1) < m && source[i].substring(j, j+2).equals("*/")) {
                    
                    if(j == m-2){
                       addTolist(str, newList); 
                    }
                    
                    j +=2;
                    inScope = true;
                    
                    
                    
                    System.out.println("Encountered */");
                } else {
                    j++;
                }
            }
        }
        
        return newList;
    }
    
    void addTolist(StringBuilder str, List<String> list) {
        System.out.println(str.toString());
        String stringToBeAdded = str.toString();
        if(!stringToBeAdded.isEmpty()){
           list.add(stringToBeAdded); 
        }
        
       str.setLength(0); 
    }
}

