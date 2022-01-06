
/*

Given a string expression representing an expression of fraction addition and subtraction, 
return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, 
change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1. 

    Example 1:

    Input: expression = "-1/2+1/2"
    Output: "0/1"
    Example 2:

    Input: expression = "-1/2+1/2+1/3"
    Output: "1/3"
    Example 3:

    Input: expression = "1/3-1/2"
    Output: "-1/6"

    Constraints:

    The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
    Each fraction (input and output) has the format ±numerator/denominator.
     If the first input fraction or the output is positive, then '+' will be omitted.
    The input only contains valid irreducible fractions,
     where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
    The number of given fractions will be in the range [1, 10].
    The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

*/

class FractionAdditionAndSubtractionSolution {
    
    private int hcf(int a, int b){
        //Here, we're finding the highest common factor using recursion. Neat stuff.
        //e.a from the `computeFraction` function we could get 10/8
        //so a = 10, b = 8
        if(b==0) return a;
        
        //b != 0 so it'll be hcf(8, 10%8 = 2) i.e hcf(8, 2)
        
        //Next iteration: b != 0 so it'll be hcf(2, 8%2 = 0) i.e hcf(2, 0)
        
        //Next iteration: b == 0, so we'll return 2.
        return hcf(b, a%b);
    }
    
    private Fraction computeFraction(Fraction f1, Fraction f2){
        //To find the currentNumerator we add the multiplication of one numerator and the other
        //denominator e.g 1/2 + 3/4 == 1*4 + 3*2
        int curNumerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        
        //To find the currentDenominator, we muliply both denominators
        int curDenominator = f1.denominator * f2.denominator;
        if(curNumerator==0) return new Fraction(0,1);      
        
        //In order to compute the highest common factor, we use Math library
        //to get the bigger of the numerator and denominator and pass it into the hcf
        //function
        int bigger = Math.max(Math.abs(curNumerator), Math.abs(curDenominator));
        int smaller = Math.min(Math.abs(curNumerator), Math.abs(curDenominator));
        int hcf = hcf(bigger, smaller);
        
        //Then we divide the currentNumerator and currentDenominator by the hcf to get the 
        //fraction in it's lowest form
        return new Fraction(curNumerator/hcf, curDenominator/hcf);

    }
    
    public String fractionAddition(String expression) {
        char[] array = expression.toCharArray();
        
        boolean metSlash = false;
        StringBuilder sb = new StringBuilder();
        
        int numerator = 0;
        int denominator = 0;
        
        Fraction storedFraction = null;
        
        for(int i = 0; i < array.length; i++) {
            char ch = array[i];
            if(!metSlash && ch == '/'){
                //Here, we've met a slash and so the numerator stops
                //we parse the string already stored in the StringBuilder and reset the 
                //StringBuilder
                
                //After, we set the metSlash to true, so we know we are on the denominator now
                //Also, this branch also skips the "/" character
                numerator = Integer.parseInt(sb.toString());
                metSlash = true;
                sb = new StringBuilder();
            } else if(!metSlash){
                //Here, we're going through the numerator cause we haven't seen
                //any slash yet
                sb.append(ch);
            } else if (i == (array.length - 1) || (metSlash && (ch == '+' || ch == '-'))){
                //Here, we've met a slash already, so we have been saving the denominator for a
                //while now. So we just encountered a character that is "+" or "-". This                       //signifies the end of our fraction so we parse the currently saved value in
                //the denominator and reset the string builder and metSlash variable to 
                //prepare for a new fraction
                if(i == (array.length - 1)) {
                    sb.append(ch);  
                }
                
                denominator = Integer.parseInt(sb.toString()); 
                Fraction currentFraction = new Fraction(numerator, denominator);
                
                if(storedFraction != null){
                    currentFraction=computeFraction(storedFraction, currentFraction);
                }
                storedFraction = currentFraction;
        
                sb = new StringBuilder();
                //This is to add the negative/positive sign in front of the fraction
                sb.append(ch);
                metSlash = false;
                
            } else if(metSlash) {
                //Here, we're adding the denominators
                sb.append(ch);
            }
        }
        
        return storedFraction.toString();
            
    }
}

class Fraction {
    int numerator;
    int denominator;
    
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public String toString(){
        return String.valueOf(numerator)+"/"+denominator;
    }
}

/*

Performance:

time complexity: O(n), n is no. of characters of the input string
space complexity: O(m), m is no. of characters of one of the fractions of input string

*/
