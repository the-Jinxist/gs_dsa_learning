public class IsPalindrome {

    //Two pointer problem. One pointer to go from the beginning and one to go from the end.
    //Every element selected by each pointer must match
    public boolean isPalindrome(String s) {
        
        s = s.trim();
        if(s.length() == 0){
            return true;
        }
        
        int pointer1 = 0;
        int pointer2 = s.length() - 1;
        
        while(pointer1 <= pointer2){
            
            if(!Character.isLetterOrDigit(s.charAt(pointer1))){
                
                pointer1++;
                continue;
            }
             
            if(!Character.isLetterOrDigit(s.charAt(pointer2))){
                pointer2--;
                continue;
            }
               
            
            if(Character.toLowerCase(s.charAt(pointer1)) != Character.toLowerCase(s.charAt(pointer2))){
                return false;
            }else{
                
                
                pointer1++;
                pointer2--;
            }
        }
        
        return true;
    }
}
