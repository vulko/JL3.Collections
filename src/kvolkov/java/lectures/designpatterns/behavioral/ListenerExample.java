package kvolkov.java.lectures.designpatterns.behavioral;

import kvolkov.java.lectures.designpatterns.behavioral.listener.Burger;
import kvolkov.java.lectures.designpatterns.behavioral.listener.Client;
import kvolkov.java.lectures.designpatterns.behavioral.listener.Kitchen;
import kvolkov.java.lectures.designpatterns.behavioral.listener.Client.KitchenObservable;

/**
 * This is an example of Listener behavioral pattern.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com) https://github.com/vulko
 *
 */
public class ListenerExample {
	
	public interface BurgerReadyListener {
		void onBurgerReady(Burger result);
	}

	public static void execute() {
		KitchenObservable kitchen = (KitchenObservable) new Kitchen();
		Client client = new Client();
		
		client.orderClassicBurger(kitchen);
		client.orderCheeseBurger(kitchen);
	}

}
