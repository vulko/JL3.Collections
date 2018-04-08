package kvolkov.java.lectures.designpatterns.creational;

import kvolkov.java.lectures.designpatterns.creational.singleton.Singleton;

/**
 * This is an example of Singleton creational pattern.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class SingletonExample {

	public static void execute() {
		Singleton singleton = Singleton.getInstance();
		
		if (singleton != Singleton.getInstance()) {
			System.out.println("This will never happen!");
		}
		
		System.out.println(singleton.toString());
	}

}
