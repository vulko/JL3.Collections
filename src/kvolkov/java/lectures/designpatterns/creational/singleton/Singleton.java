package kvolkov.java.lectures.designpatterns.creational.singleton;

/**
 * Threadsafe Singleton implementation.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public final class Singleton {
    
	private static volatile Singleton sInstance = null;

    private Singleton() {} // Disallow to instanciate an object

    public static Singleton getInstance() {
        if (sInstance == null) {
            synchronized(Singleton.class) {
                if (sInstance == null) {
                    sInstance = new Singleton();
                }
            }
        }
        return sInstance;
    }
    
    public String toString() {
    	return "I'm a singleton!";
    }
}
