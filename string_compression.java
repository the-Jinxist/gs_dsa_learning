/*

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. 
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space. 

    Example 1:

    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    Example 2:

    Input: chars = ["a"]
    Output: Return 1, and the first character of the input array should be: ["a"]
    Explanation: The only group is "a", which remains uncompressed since it's a single character.
    Example 3:

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
    

    Constraints:

    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

*/

class StringCompressionSolution {

    public int compress(char[] chars) {
        
        //Used this value to initialized the loop and to check for re-occurring values
        char prevChar = ' ';

        //The counter records everytime a reoccurence occurs, increasing the value by 1
        int counter = 0;
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        for (char value : chars) {
            if(prevChar != ' '){

                //Inside this IF, we are no longer working on the first value
                if(prevChar == value) {

                    //We have found an occurrence, checking the previously stored `prevChar` is equal to the
                    //newly-found `value`
                    counter++;
                    
                    if(i == (chars.length - 1) ) { 
                        //An edge case, we might still be counting occurrences at the end of the array so we make sure to
                        //append the value of the counter to the string builder
                        sb.append(String.valueOf(counter));
                    }
                    
                } else { 
                    //Here, we've encountered a new value
                    if(counter > 1) {
                        //so we append the count of the old value and reset the count variable
                        sb.append(String.valueOf(counter));
                        counter = 1; 
                    }
                    
                    //Here, we append the new value
                    sb.append(value);
                }
                
            } else {

                //This means this is the very first value
                sb.append(value);

                //Initializing the counter to show that we have at least once occurrence
                counter = 1;
            }
            
            prevChar = value;
            
            i++;
        }
        
        //Getting all the values
        for(int x = 0; x < sb.toString().toCharArray().length; x++) {
            char[] sortedArray = sb.toString().toCharArray();
            chars[x] = sortedArray[x];
        }
        
        return sb.toString().length();
    }
    
    
}
