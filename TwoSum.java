import java.util.HashMap;

/*
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

public class TwoSum {
   
    //Here, I'm just keeping the current index and cycling through the whole array and check for individual sums.

    //Watch out for the "<=" in the for loop though.
    public int[] twoSum(int[] nums, int target) {
        int currentValue = 0;
        int foundElement = 0;
        
        while(currentValue <= nums.length - 1){
            for(int i = 1; i <= nums.length - 1; i++){
                if(i == currentValue){
                    continue;
                }
                
                
                int value = nums[currentValue] + nums[i];
                
                if(value == target){
                    foundElement = i;
                }
                
            }
            
            if(foundElement != 0){
                break;
            }
            
            currentValue++;
        }
        
        int[] myArray = {currentValue, foundElement};
        
        return myArray;
    }

    //Optimal solution.

    
    public int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            //Do this calculation to see the required number that must be added with the current item in this index to
            //make up the target
            int requiredNumber = target - nums[i]; 

            //Check if the hashmap already contains the required number, if it does, return the index which is the value(the required number being the key)
            //along with the current index.
            if(values.containsKey(requiredNumber)){
                int[] array = {values.get(requiredNumber), i};
                return array;
            }else{
                //Use the hashmap to store each value and index on your iteration
                values.put(nums[i], i);
            }
        }
        
        int[] array = {0};
        return array;
    }

}
