import java.util.Arrays;
/*

Given a string s, find the first non-repeating character in it and return its index. 
If it does not exist, return -1. 

    Example 1:

    Input: s = "leetcode"
    Output: 0
    Example 2:

    Input: s = "loveleetcode"
    Output: 2
    Example 3:

    Input: s = "aabb"
    Output: -1

*/

class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        
        //Initialize the array with -1
        Arrays.fill(array, -1);
        
        //The only way to convert a string into a array in java it seems
        char[] stringArray = s.toCharArray();
        
        //we're going through the char array to get the index each char occur in the actual             //string. Also we use char-'a' will give the index of the char in the alphabet
        //nifty stuff
        for(int i =0; i < stringArray.length; i++) {
            System.out.println("Value " + stringArray[i] + " Positon in alphabet: " + (stringArray[i]-'a'));
            if(array[stringArray[i]-'a'] == -1) {
                //first time meeting the value
                //let the array storing alphabets store the index, the lower the index
                //the early it occurs in the string
                array[stringArray[i]-'a'] = i;
                
            } else if(array[stringArray[i]-'a'] >= 0){
                //second time meeting value
                //update the index in the alphabet array, so we know we've seen this value
                //already
                array[stringArray[i]-'a'] = -2;
            }
        }
        
        //set a minimum of the highest possible of Integer.MAX_VALE
        int min=Integer.MAX_VALUE;
        for (int value : array){
            if(value >= 0){
                //If the value only occurs once, compare the value in the alphabet array
                //which is the index where it occurs in the original string
                //once again, the lower this value is, the earlier it occurs in the string
                min = Math.min(min, value);
            }
        }
        
        
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}

/*

Performance

time complexity: O(n), n is no. of char in the string
space complexity: O(1), an extra array to store the minimum index of character

*/