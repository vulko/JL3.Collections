package kvolkov.java.lectures.collections;

import kvolkov.java.lectures.collections.lists.ArrayListExample;
import kvolkov.java.lectures.collections.maps.HashMapExample;

public class main {

	private enum JL3_EXAMPLE {
		HASHMAP_EXAMPLE,
		ARRAYLIST_EXAMPLE
	}
	
	public static void main(String[] args) {

		// Select an example to run
		final JL3_EXAMPLE executedExample = JL3_EXAMPLE.ARRAYLIST_EXAMPLE;
		
		switch(executedExample) {
		case HASHMAP_EXAMPLE:
			// HashMap timings comparison example
			HashMapExample.execute();
			break;

		case ARRAYLIST_EXAMPLE:
			// ArrayList timings comparison example
			ArrayListExample.execute();
			break;

		default:
			System.out.println("No example selected");
		}
		
	}

}
