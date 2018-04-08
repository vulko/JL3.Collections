package kvolkov.java.lectures.designpatterns.creational.builder;

/**
 * This an immutable class with a Builder.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class SomeImmutableClass {
	
	/**
	 * Builder.
	 */
	public static class Builder {
		
		private static String mName;
		
		public static Builder setName(String name) {
			mName = name;
			return new Builder();
		}
		
		public static SomeImmutableClass build() {
			return new SomeImmutableClass(mName); 
		}
		
	}
	
	private final String mName;
	
	// stub
	private SomeImmutableClass() {
		mName = null;
	}
	
	private SomeImmutableClass(String name) {
		mName = name;
	}
	
	@Override
	public String toString() {
		return mName;		
	}
	
}


