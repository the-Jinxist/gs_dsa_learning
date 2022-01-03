/*

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
    

    Constraints:

    1 <= n <= 45

*/

class ClimbingStairsSolution {

    //The solution to this is basically the solution to solving the fibonacci sequence
    //Basically: f(n) = f(n-2) + f(n-1)
    //Create variables to store f(n), f(n-2), f(n-1)
    //here, it's answer, firstAnser and secondAnswer respectively.

    //Calculate f(n) = f(n-2) + f(n-1)
    //Assign the answer of f(n-2) to f(n-1)'s variable
    //Assign the f(n) to f(n-2)'s variable

    public int climbStairs(int n) {
        
        if(n < 2){
            return 1;
        }
        
        int answer = 0;
      
        int firstAnswer = 1;
        int secondAnswer = 1;
        
        for (int i = 1; i < n; i++) {
            answer = firstAnswer + secondAnswer;
            firstAnswer = secondAnswer;
            secondAnswer = answer;
        }
        
        return answer;
    }
}
