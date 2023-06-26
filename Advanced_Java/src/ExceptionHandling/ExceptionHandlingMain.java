package ExceptionHandling;

public class ExceptionHandlingMain {
	public static void main(String[] args) {
		try {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int result = n1/n2;
		System.out.println(result); }
		catch(ArithmeticException e) {
			System.out.println("Enter non zero numbers");
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Enter atleast 2 numbers");
		}
		finally {
			System.out.println("Thankypu");
		}
		
	}
}
