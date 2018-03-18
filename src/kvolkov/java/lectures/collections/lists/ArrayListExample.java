package kvolkov.java.lectures.collections.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kvolkov.java.lectures.collections.Utils;

/**
 * This is a {@link ArrayList} timings comparison example.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class ArrayListExample {
	
	static List<String> mList = new ArrayList<>();
	static final int sListCapacity = 1000000;
	static final int sHeavyOperationsIterations = 100;
	
	private static void runInsertTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;

		for (int i = 0; i < sListCapacity; ++i) {
			str = String.valueOf(i);
			tsStart = System.currentTimeMillis();
			mList.add(str);
			tsEnd = System.currentTimeMillis();
			Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Insert of " + "\"" + str + "\"");
		}
		
		System.out.println("Final list size = " + mList.size());
	}

	private static void runRemoveTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init map
		for (int i = 0; i < sListCapacity; ++i) {
			str = String.valueOf(i);
			mList.add(str);
		}

		// now remove random elements
		for (int i = 0; i < sHeavyOperationsIterations; ++i) {
			str = String.valueOf(random.nextInt(sListCapacity));

			tsStart = System.currentTimeMillis();
			final boolean found = mList.remove(str);
			tsEnd = System.currentTimeMillis();
			
			if (found) {
				Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Remove of " + "\"" + str + "\"");
			}
		}

		System.out.println("Final list size = " + mList.size());
	}

	private static void runFindTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init map
		for (int i = 0; i < sListCapacity; ++i) {
			str = String.valueOf(i);
			mList.add(str);
		}

		// now find random elements
		for (int i = 0; i < sHeavyOperationsIterations; ++i) {
			str = String.valueOf(random.nextInt(sListCapacity));

			tsStart = System.currentTimeMillis();
			String item = mList.get(mList.indexOf(str));
			tsEnd = System.currentTimeMillis();
			
			if (item != null) {
				Utils.printTimeDiffIfNotZero(tsStart, tsEnd, "Find value " + "\"" + str + "\"");
			}
		}

		System.out.println("Final list size = " + mList.size());
	}
	
	public static void execute() {
		mList.clear();
		
		runInsertTimingsComparsion();
		runRemoveTimingsComparsion();
		runFindTimingsComparsion();
	}

}
