package task6_creating_patterns.prototype;

import java.util.Random;

public class Prototype implements IPrototype {
	private int a = new Random().nextInt();

	@Override
	public Prototype getPrototype() {
		Prototype clone = new Prototype();
		clone.a = this.a;
		return clone;
	}

	@Override
	public String toString() {
		return "Prototype{" +
				"a=" + a +
				'}';
	}
}
