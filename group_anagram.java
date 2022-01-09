import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once. 

    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example 2:

    Input: strs = [""]
    Output: [[""]]
    Example 3:

    Input: strs = ["a"]
    Output: [["a"]]
    

    Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.

*/

class GroupAnagramSolution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Anagrams are basically the same words but rearranged letters
        //So this solution takes these words, sort the undelying characters so..
        //abc, bac, and cba are always sorted to "abc"
        
        //This hashmap is for storing anagrams
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        List<List<String>> answer = new ArrayList<List<String>>();
        
        for(int i = 0; i < strs.length; i++){
            //Here we're going through all the words
            String word = strs[i];
            
            //Converting them to a character array so we can sort them
            char[] ar = word.toCharArray();
            
            //Sorting them
            Arrays.sort(ar);
            String key = String.valueOf(ar);
            System.out.println("sorted value: " + key);
            
            //Here we're getting the key that correspond to the sorted character array
            List<String> values = anagrams.get(key);
            
            //if the word correspond to this sorted array, add it to the list
            if(values == null){
                List<String> value = new ArrayList<String>();
                value.add(word);
                anagrams.put(key, value);
                
            } else {
                values.add(word);
                anagrams.put(key, values);
            }
        }
        
        //Store each list to the answers list..
        System.out.println(anagrams);
        answer.addAll(anagrams.values());
        
        return answer;
    }
    
    
}

/*
Performance: 
    time: O(n m log m), n is no. of strings, m is no. of characters in a string
    space: O(n), n is no. of strings to store all given string in the extra hashmap

*/
