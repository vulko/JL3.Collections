package kvolkov.java.lectures.designpatterns.behavioral.listener;

import kvolkov.java.lectures.designpatterns.behavioral.ListenerExample.BurgerReadyListener;

public class Client implements BurgerReadyListener {
	
	public interface KitchenObservable {
		void requestClassicBurger();
		void requestCheeseBurger();
		void setClient(BurgerReadyListener client);
	}

	public void orderClassicBurger(KitchenObservable kitchen) {
		kitchen.setClient(this);
		kitchen.requestClassicBurger();
	}
	
	public void orderCheeseBurger(KitchenObservable kitchen) {
		kitchen.setClient(this);
		kitchen.requestCheeseBurger();
	}

	@Override
	public void onBurgerReady(Burger result) {
		System.out.println("I've just got a " + result.toString());			
	}
	
}
