package kvolkov.java.lectures.generics;

public class GenericsExample {
	
	public static class DataHolder {
		
		private final Object mData;
		
		public DataHolder(Object data) {
			mData = data;
		}
		
		Object getData() { return mData; }
		
	}
	
	public static class DataHolderTyped<T> {
		
		private final T mData;
		
		public DataHolderTyped(T data) {
			mData = data;
		}
		
		T getData() { return mData; }
		
	}
	
	public static void run() {
		DataHolder holder = new DataHolder(new String("Привет бобер!"));
		DataHolder holder1 = new DataHolder(new String("Какой сегодня день?"));
		DataHolder holder2 = new DataHolder(new Integer(20));
		
		System.out.println(holder.getData());
		System.out.println(holder1.getData());
		System.out.println(holder2.getData());
		
		if (holder.getData() instanceof String) {
			String data = (String) holder.getData();
		}
		
		try {
			String data = (String) holder2.getData();			
		} catch (Exception e) {
			System.out.println("FAIL!");
		}
		
		DataHolderTyped<String> holderTyped = new DataHolderTyped<>(new String("Привет бобер!"));
		DataHolderTyped<String> holderTyped1 = new DataHolderTyped<>(new String("Какой сегодня день?"));
		DataHolderTyped<Integer> holderTyped2 = new DataHolderTyped<>(new Integer(20));
		
		System.out.println(holderTyped.getClass());
		System.out.println(holderTyped1.getClass());
		System.out.println(holderTyped2.getClass());
		holderTyped2.getData();
		

	}

}
