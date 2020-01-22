package kvolkov.java.lectures.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsExample2 {
	
	public static class NumberHolder<T extends Number> {
		
		private final T mData;
		
		public NumberHolder(T data) {
			mData = data;
		}
		
		T getNumber() { return mData; }
		
		static boolean isValidNumber(NumberHolder<? extends Float> data) {
			return data.equals(Float.NaN);
		}
		
		void checkAll(List<T> data) {
		}
		
		void checkAll1(List<?> data) {
		}
		
	}
	
	static void fromArrayToCollectionInvalid(Object[] a, Collection<?> c) {
	    for (Object o : a) { 
//	        c.add(o);                         // compile-time error
	    }
	    Collection<? extends String> someCollection;
	}


	// GENERIC METHOD
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
	    for (T o : a) {
	        c.add(o);                         // Correct
	    }
	}

	
	public static void run() {
		NumberHolder<Integer> data;
		NumberHolder<Float> data1 = new NumberHolder<>(10.f / 0.f);
		
		
		// Generic method usage example
		
		Object[] objectArray = new Object[100];
		Collection<Object> collection = new ArrayList<Object>();

		// T inferred to be Object
		fromArrayToCollection(objectArray, collection); 

		String[] stringArray = new String[100];
		Collection<String> stringCollection = new ArrayList<String>();

		// T inferred to be String
		fromArrayToCollection(stringArray, stringCollection);

		// T inferred to be Object
		fromArrayToCollection(stringArray, collection);

		Integer[] intArray = new Integer[100];
		Float[] floatArray = new Float[100];
		Number[] numberArray = new Number[100];
		Collection<Number> numberCollection = new ArrayList<Number>();

		// T inferred to be Number
		fromArrayToCollection(intArray, numberCollection);

		// T inferred to be Number
		fromArrayToCollection(floatArray, numberCollection);

		// T inferred to be Number
		fromArrayToCollection(numberArray, numberCollection);

		// T inferred to be Object
		fromArrayToCollection(numberArray, collection);

		// compile-time error
//		fromArrayToCollection(numberArray, stringCollection);


	}

}
