public class ValidParenthesis {
    
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> container = new Stack();
        for(char c: s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                System.out.println("pushed: " + c);
                container.push(c);
            }else if(c == ')' && !container.isEmpty() && container.peek() == '(' ){
                container.pop();
            }else if(c == '}' && !container.isEmpty() && container.peek() == '{' ){
                container.pop();
            }else if(c == ']'  && !container.isEmpty() && container.peek() == '['){
                container.pop();
            } else {
                return false;
            }
        }
        
        return container.isEmpty();
    
    }
}