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

}
