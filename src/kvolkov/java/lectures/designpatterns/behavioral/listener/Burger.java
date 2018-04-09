package kvolkov.java.lectures.designpatterns.behavioral.listener;

public class Burger {
	
	public static class ClassicBurger extends Burger {
		public String toString() {
			return "Classic Burger";
		}
	}

	public static class CheeseBurger extends Burger {
		public String toString() {
			return "Cheese Burger";
		}
	}

}