package kvolkov.java.lectures.designpatterns;

import kvolkov.java.lectures.designpatterns.behavioral.ListenerExample;
import kvolkov.java.lectures.designpatterns.creational.AbstractFactoryExample;
import kvolkov.java.lectures.designpatterns.creational.BuilderExample;
import kvolkov.java.lectures.designpatterns.creational.SingletonExample;
import kvolkov.java.lectures.designpatterns.structural.AdapterExample;

public class main {

	private enum JL5_EXAMPLE {
		ABSTRACT_FACTORY,
		BUILDER,
		SINGLETON,
		ADAPTER,
		LISTENER
	}
	
	public static void main(String[] args) {

		// Select an example to run
		final JL5_EXAMPLE executedExample = JL5_EXAMPLE.LISTENER;
		
		switch(executedExample) {
		case ABSTRACT_FACTORY:
			try {
				AbstractFactoryExample.execute();
			} catch (Exception e) {
				System.out.println("Operating system is not supported");
			}
			break;

		case BUILDER:
			BuilderExample.execute();
			break;

		case SINGLETON:
			SingletonExample.execute();
			break;

		case ADAPTER:
			AdapterExample.execute();
			break;

		case LISTENER:
			ListenerExample.execute();
			break;

		default:
			System.out.println("No example selected");
		}
		
	}

}
