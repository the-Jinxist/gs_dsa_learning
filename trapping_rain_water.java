/*Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.
    Example 1; 
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    
    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
    

    Constraints:

    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105

*/

class TrappingRainWaterSolution {
    public int trap(int[] height) {
        
        if(height.length < 2){
            return 0;
        }
        
        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];
        
        int total = 0;
        
        for(int i = 0; i < height.length; i++){
            if(i == 0){
                leftMaxArray[i] = height[i]; 
            } else {
                if(leftMaxArray[i - 1] > height[i]){
                    leftMaxArray[i] = leftMaxArray[i - 1];
                }else{
                    leftMaxArray[i] = height[i];
                }
            }
        }
        
        for (int i = height.length - 1; i >= 0; i--) {
            if(i == (height.length - 1)){
                rightMaxArray[i] = height[i];
            } else {
                if(rightMaxArray[i + 1] > height[i]){
                    rightMaxArray[i] = rightMaxArray[i + 1];
                } else {
                    rightMaxArray[i] = height[i];
                }
            }
        }
        
        for(int i = 0; i < height.length; i++){
            int waterLevel = 0;
            
            if(i == 0){
                waterLevel = Math.min(leftMaxArray[i], rightMaxArray[i+1])-height[i];
            } else if(i == (height.length - 1)){
                waterLevel = Math.min(leftMaxArray[i-1], rightMaxArray[i])-height[i];
            } else {
                waterLevel = Math.min(leftMaxArray[i-1], rightMaxArray[i+1])-height[i];
                
            }
            
            if(waterLevel >= 0){
                total += waterLevel;
            }
            
        }
        
        
        
        // System.out.println(leftMaxArray.toString());
        
        return total;
    }
}