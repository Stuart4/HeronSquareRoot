import java.util.Scanner;

/**
 * HeronSquareRoot
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 12, 2014
 */
public class Main {
	final static double PRECISION = 0.00000001;
	private static int loops = 0;

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (true) {
			System.out.print("Enter number to calculate square root of: ");
			if (sin.hasNextDouble()) {
				System.out.println(calcSquareRoot(sin.nextDouble()));
			}
		}
	}

	public static double calcSquareRoot(double input) {
		if (input == 0)
			return 0;

		if (input < 0) {
			System.err.println("Cannot take the square root of a negative number.");
			return -1;
		}

		double guess = input / 31.0;
		loops = 0;

		while (true) {
			double lastguess = guess;
			guess = (lastguess + (input / guess)) / 2;
			System.out.printf("guess: %f, lastguess: %f, loops: %d\n", guess, lastguess, loops);
			if (Math.abs(lastguess - guess) <= PRECISION)
				return guess;
			loops++;
		}
	}
}
