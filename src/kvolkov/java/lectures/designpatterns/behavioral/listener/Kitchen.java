package kvolkov.java.lectures.designpatterns.behavioral.listener;

import kvolkov.java.lectures.designpatterns.behavioral.ListenerExample.BurgerReadyListener;
import kvolkov.java.lectures.designpatterns.behavioral.listener.Client.KitchenObservable;

public class Kitchen implements KitchenObservable {

	private BurgerReadyListener mBurgerReadyListener = null;

	@Override
	public void requestClassicBurger() {
		Burger classic = new Burger.ClassicBurger();
		if (mBurgerReadyListener != null) {
			mBurgerReadyListener.onBurgerReady(classic);			
		}
	}

	@Override
	public void requestCheeseBurger() {
		Burger cheese = new Burger.CheeseBurger();
		if (mBurgerReadyListener != null) {
			mBurgerReadyListener.onBurgerReady(cheese);			
		}
	}

	@Override
	public void setClient(BurgerReadyListener client) {
		mBurgerReadyListener = client;			
	}

}


