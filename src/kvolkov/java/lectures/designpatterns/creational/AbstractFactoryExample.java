package kvolkov.java.lectures.designpatterns.creational;

/**
 * This is an example of AbstractFactory creational pattern.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com)
 *         https://github.com/vulko
 *
 */
public class AbstractFactoryExample {
	
	public interface IButton {
		void paint();
	}

	public interface IGUIFactory {
		public IButton createButton();
	}

	public class WinFactory implements IGUIFactory {
		@Override
		public IButton createButton() {
			return new WinButton();
		}
	}

	public class OSXFactory implements IGUIFactory {
		@Override
		public IButton createButton() {
			return new OSXButton();
		}
	}

	public class WinButton implements IButton {
		@Override
		public void paint() {
			System.out.println("WinButton");
		}
	}

	public class OSXButton implements IButton {
		@Override
		public void paint() {
			System.out.println("OSXButton");
		}
	}
	
	public static void execute() throws Exception {
		IGUIFactory factory = null;
		
		final String appearance = randomAppearance();	// Current operating system

		if (appearance.equals("OSX")) {
			factory = new AbstractFactoryExample().new OSXFactory();
		} else if(appearance.equals("Windows")) {
			factory = new AbstractFactoryExample().new WinFactory();
		} else {
			throw new Exception("No such operating system");
		}
		
		final IButton button = factory.createButton();

		button.paint();
	}
	
	public static String randomAppearance() {
		final String[] appearanceArray = new String[3];

		appearanceArray[0] = "OSX";
		appearanceArray[1] = "Windows";
		appearanceArray[2] = "error";
		final java.util.Random random = new java.util.Random();

		final int randomNumber = random.nextInt(3);

		return appearanceArray[randomNumber];
	}

}
