package task5_singleton;

public class Singleton {
	private static Singleton INSTANCE = null;

	public void foo() {}

	private Singleton() {}

	public synchronized static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
}