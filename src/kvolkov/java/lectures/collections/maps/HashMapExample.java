package kvolkov.java.lectures.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import kvolkov.java.lectures.collections.Utils;

/**
 * This is a {@link HashMap} timings comparison example.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class HashMapExample {
	
	static Map<String, String> mMap = new HashMap<>();
	static final int sMapCapacity = 1000000;
	
	private static void runInsertTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;

		for (int i = 0; i < sMapCapacity; ++i) {
			str = String.valueOf(i);
			tsStart = System.currentTimeMillis();
			mMap.put(str, str);
			tsEnd = System.currentTimeMillis();
			Utils.printTimeDiff(tsStart, tsEnd, "Insert of " + "\"" + str + "\"");
		}
		
		System.out.println("Final map size = " + mMap.size());
	}

	private static void runRemoveTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init map
		for (int i = 0; i < sMapCapacity; ++i) {
			str = String.valueOf(i);
			mMap.put(str, str);
		}

		// now remove random elements
		for (int i = 0; i < sMapCapacity; ++i) {
			str = String.valueOf(random.nextInt(sMapCapacity));

			tsStart = System.currentTimeMillis();
			final boolean found = mMap.remove(str, str);
			tsEnd = System.currentTimeMillis();
			
			if (found) {
				Utils.printTimeDiff(tsStart, tsEnd, "Remove of " + "\"" + str + "\"");
			}
		}

		System.out.println("Final map size = " + mMap.size());
	}

	private static void runFindTimingsComparsion() {
		long tsStart = 0L;
		long tsEnd = 0L;
		String str = null;
		Random random = new Random();

		// init map
		for (int i = 0; i < sMapCapacity; ++i) {
			str = String.valueOf(i);
			mMap.put(str, str);
		}

		// now find random elements
		for (int i = 0; i < sMapCapacity; ++i) {
			str = String.valueOf(random.nextInt(sMapCapacity));

			tsStart = System.currentTimeMillis();
			String item = mMap.get(str);
			tsEnd = System.currentTimeMillis();
			
			if (item != null) {
				Utils.printTimeDiff(tsStart, tsEnd, "Find value " + item + " with key " + "\"" + str + "\"");
			}
		}

		System.out.println("Final map size = " + mMap.size());
	}
	
	public static void execute() {
		mMap.clear();
		
		runInsertTimingsComparsion();
		runRemoveTimingsComparsion();
		runFindTimingsComparsion();
	}

}
