 class BinarySearch {
    
    public int search(int[] nums, int target) {
        
        int mid = nums.length / 2;
        int start = 0;
        int end = nums.length -1;
        
        while(true) {
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(start == end){
                break;
            }
            
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            
            mid = start + (end - start) / 2;
            
            
            
        }
            
        
        return -1;
    }
    
}
