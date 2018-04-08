package kvolkov.java.lectures.designpatterns.creational;

import kvolkov.java.lectures.designpatterns.creational.builder.SomeImmutableClass;

/**
 * This is an example of Builder creational pattern.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class BuilderExample {

	public static void execute() {
		SomeImmutableClass obj = SomeImmutableClass.Builder.setName("This is an object created with a builder").build();
		
		System.out.println(obj.toString());
	}

}
