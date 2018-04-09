package kvolkov.java.lectures.collections.sets;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import kvolkov.java.lectures.collections.Utils;

/**
 * This is a {@link TreeSet} timings comparison example.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class TreeSetExample {
	
	static Set<String> mSet = new TreeSet<>();
	static final int sSetCapacity = 1000000;
	static final int sHeavyOperationsIterations = 100;
	
	private static void runInsertTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;

		for (int i = 0; i < sSetCapacity; ++i) {
			str = String.valueOf(i);
			tsStart = System.currentTimeMillis();
			mSet.add(str);
			tsEnd = System.currentTimeMillis();
			Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Insert of " + "\"" + str + "\"");
		}
		
		System.out.println("Final set size = " + mSet.size());
	}

	private static void runRemoveTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init tree
		for (int i = 0; i < sSetCapacity; ++i) {
			str = String.valueOf(i);
			mSet.add(str);
		}

		// now remove random elements
		for (int i = 0; i < sHeavyOperationsIterations; ++i) {
			str = String.valueOf(random.nextInt(sSetCapacity));

			tsStart = System.currentTimeMillis();
			final boolean found = mSet.remove(str);
			tsEnd = System.currentTimeMillis();
			
			if (found) {
				Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Remove of " + "\"" + str + "\"");
			}
		}

		System.out.println("Final set size = " + mSet.size());
	}

	private static void runFindTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init tree
		for (int i = 0; i < sSetCapacity; ++i) {
			str = String.valueOf(i);
			mSet.add(str);
		}

		// now find random elements
		for (int i = 0; i < sHeavyOperationsIterations; ++i) {
			str = String.valueOf(random.nextInt(sSetCapacity));

			tsStart = System.currentTimeMillis();
			String item = null;
			for (String string : mSet) {
				if (string.equals(str)) {
					item = string;
					break;
				}
			}
			tsEnd = System.currentTimeMillis();
			
			if (item != null) {
				Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Find value " + "\"" + str + "\"");
			}
		}

		System.out.println("Final set size = " + mSet.size());
	}
	
	public static void execute() {
		mSet.clear();
		
		runInsertTimingsComparsion();
		runRemoveTimingsComparsion();
		runFindTimingsComparsion();
	}

}
