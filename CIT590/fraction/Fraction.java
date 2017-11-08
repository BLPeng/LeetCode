/*
Name: Bolu Peng
PennID: 16847239
Statement: I completed this assignment all by myself 
*/
package fraction;

public class Fraction {
	private int numerator;
	private int denominator;
	
    public Fraction(int numerator, int denominator){
    	// if numerator and denominator have GCD, normalize them
		int divisor = GreatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
		// if numerator==0 or denominator==0, normalize it 
    	if (numerator == 0 || denominator==0){
    		this.numerator = 0;
    		this.denominator = 1;
    	}
    	else{
    		this.numerator = denominator<0 ? (-1)*(numerator/divisor) : numerator/divisor;
    		this.denominator = denominator<0 ? (-1)*(denominator/divisor) : denominator/divisor;
    	}
    }
    
    public Fraction(int wholeNumber){
    	this.numerator = wholeNumber;
    	this.denominator = 1;
    }
    
    public Fraction(String fraction){
    	String[] temp = fraction.split("/");
    	if (temp.length==1){
    		this.numerator = Integer.parseInt(temp[0].trim());
    		this.denominator = 1;
    	}
    	else if (Integer.parseInt(temp[0].trim())==0 || Integer.parseInt(temp[1].trim())==0){
    		this.numerator = 0;
    		this.denominator = 1;
    	}
    	else{    	
    		// if numerator and denominator have GCD, normalize them
    		int divisor = GreatestCommonDivisor(Math.abs(Integer.parseInt(temp[0].trim())), Math.abs(Integer.parseInt(temp[1].trim())));
    		this.numerator = Integer.parseInt(temp[1].trim())<0 ? ((-1)*(Integer.parseInt(temp[0].trim())/divisor)) : (Integer.parseInt(temp[0].trim())/divisor);
    		this.denominator = Integer.parseInt(temp[1].trim())<0 ? ((-1)*(Integer.parseInt(temp[1].trim())/divisor)) : (Integer.parseInt(temp[1].trim())/divisor);
    	}
    }
    
    public int GreatestCommonDivisor(int a, int b){
    	if (b==0) return a;
    	return GreatestCommonDivisor(b, a%b);
    }
    
    public Fraction add(Fraction f){
    	return new Fraction(this.numerator*f.denominator+this.denominator*f.numerator, this.denominator*f.denominator);
    }
    
    public Fraction subtract(Fraction f){
    	return new Fraction(this.numerator*f.denominator-this.denominator*f.numerator, this.denominator*f.denominator);
    }
    
    public Fraction multiply(Fraction f){
    	return new Fraction(this.numerator*f.numerator, this.denominator*f.denominator);
    }
    
    public Fraction divide(Fraction f){
    	// if f == 0, print an error message, keep the original value of numerator and denominator
    	if (f.numerator==0){
    		System.out.println("Can't be divided by zero");
    		return new Fraction(this.numerator, this.denominator);
    	}
    	return new Fraction(this.numerator*f.denominator, this.denominator*f.numerator);
    }
    
    public Fraction abs(){
    	return new Fraction(Math.abs(numerator), Math.abs(denominator));
    }
    
    public Fraction negate(){
    	return new Fraction((-1)*numerator,denominator);
    }
    
    public Fraction inverse(){
    	// if numerator == 0, print an error message, keep the original numerator and denominator
    	if (numerator==0){
    		System.out.println("Can't inverse when numerator is zero");
    		return new Fraction(numerator, denominator);
    	}
    	return new Fraction(denominator, numerator);
    }
    
    public int compareTo(Fraction f){
    	if ((this.numerator*f.denominator - this.denominator*f.numerator)==0){
    		return 0;
    	}
    	return (this.numerator*f.denominator - this.denominator*f.numerator)>0 ? 1 : -1;
    }
    
    public String toString(){
    	// if both numerator and denominator are negative, normalize them
    	if (numerator<0 && denominator<0){
    		numerator *= -1;
    		denominator *= -1;
    	}
    	return denominator==1 ? String.valueOf(numerator) : String.valueOf(numerator)+"/"+String.valueOf(denominator);
    }
}
