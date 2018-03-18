package kvolkov.java.lectures.collections;

public class Utils {
	
	public static void printTimeDiff(final long start, final long end, String operation) {
		final long elapsed = end - start;
		System.out.println(operation + " took " + elapsed + "ms");
	}
	
	public static void printTimeDiffIfNotZero(final long start, final long end, String operation) {
		final long elapsed = end - start;
		if (elapsed > 0) {
			System.out.println(operation + " took " + elapsed + "ms");
		}
	}
}
