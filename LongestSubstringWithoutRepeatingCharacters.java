import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {


    //Optimal solution for longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {

        //This is a sliding solution problem, so one pointer moves faster than the other, when a character is found
        //that is already stored in the hashset, we start removing characters from the hashset using the other slower 
        //pointer.
        
        int lastPointer = 0;
        int firstPointer = 0;
        
        int max = 0;
        
        HashSet<Character> set = new HashSet<Character>();
        while(lastPointer < s.length()){
            if(!set.contains(s.charAt(lastPointer))){
                set.add(s.charAt(lastPointer));
                lastPointer++;
                
                max = Math.max(set.size(), max);
            }else{
                set.remove(s.charAt(firstPointer));
                firstPointer++;
            }
        }
        
        return max;
    }
}
