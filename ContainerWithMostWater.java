public class ContainerWithMostWater {
    /*
     * 
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.

        Notice that you may not slant the container.
     * 
     */

    //This is a two-pointer solution. You use each pointer to keep track of the two ends of the array. You have to keep in mind
    //to prioritize the highest heights, so the pointer on a column(columns are each element in the array) with the lower height is 
    //moved forward/backward depending on the pointer and the area it covers and total height is calculated via Math.max()

    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int firstPointer =0;
        int lastPointer = height.length - 1;
        
        while(firstPointer < lastPointer){
            if(height[firstPointer] < height[lastPointer]){
                maxArea = Math.max(maxArea, height[firstPointer] * (lastPointer - firstPointer));
                firstPointer++;
            } else{
                maxArea = Math.max(maxArea, height[lastPointer] * (lastPointer - firstPointer));
                lastPointer--;
            }
        }
        
        return maxArea;
    }
}
