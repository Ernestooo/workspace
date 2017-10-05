
public class Mathematics {
	
	public static boolean isPrime(int n) { // n >=1
		int x = 2;
		boolean result = true;
		while (x < n && result) {
			result = (n % x != 0);
			x++; 
		}
		if (n == 1) result = false;
		return result;
	}
	
	public static boolean isPerfect(int n) {
		int v = 1;
		int sum = 0;
		while ( v < n ) {
			if ( n % v == 0){
			sum += v;	
		}
			v++;
		}		
		return sum == n;
	}
	
	public static int factorialIt(int n){
		int x = 1;
		int fact = 1;
		while (x <= n){
			fact *= x;
			x++;
		}
		return fact;
	}
	
	public static int factorial(int n){
		int result;
		if (n == 0)
			result = 1;
		else
			result = n * factorial (n - 1);
		
		return result;
	}
	
	public static int fibonacci(int n) {
		int result;
		if (n <= 1)
			result = n;
		else
			result = fibonacci (n - 1) + fibonacci (n + 2);
		
		return result;
		
		
	}
/**
 * other way
 * 
 * public static boolean isPrime(int n) {
 * 		int v = 2;
 * 		while ((v < n) && ((n % v) ! = 0) {
 * 			v++; }
 * 		return (v==n)
 * }
 * 
 * or 
 * 
 * public static boolean isPrime(int n) {
 * 		int v = n - 1;
 * 		while ((v > 1) && ((n % v) ! = 0) {
 * 			v--; }
 * 		return (v==1)
 * }
 */
}
