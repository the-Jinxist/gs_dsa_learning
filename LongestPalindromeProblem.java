public class LongestPalindromeProblem {
    public String longestPalindrome(String s) {
        if(s == null){
            return "";
        }
        
        if(s.trim().length() == 0){
            return "";
        }
        
        int end = 0;
        int start = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            //it will consider each element in the array as the middle of a 
            //odd-lengthed palindrom and start building out from the middle
            int length1 = findPalindromLength(s, i, i);
            
            //it will consider each element in the array as the first member of the               //middle of an even-lengthed palindrom and use the element's index + 1
            //at the second member
            int length2 = findPalindromLength(s, i, i+1);
            
            int maxLength = Math.max(length1, length2);
            if(maxLength > (end - start)){
                end = i + (maxLength / 2);
                start = i - ((maxLength - 1) / 2);
            }
        }
        
        return s.substring((start), end + 1);
    }
    
    //This takes the other route for finding a palindrome by spreading ou from the 
    //middle of the possible palindromic string, until elements at both pointers 
    //don't match
    public int findPalindromLength(String s, int start, int end){
        if(start > end){
            return 0;
        }
        
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        
        return end - start - 1;
    }
}
