package task7_structure_patterns.flyweight;

public class Flyweight {

	public Flyweight(int repeatingState) {
		this.repeatingState = repeatingState;
	}

	public int getRepeatingState() {
		return repeatingState;
	}

	public void setRepeatingState(int repeatingState) {
		this.repeatingState = repeatingState;
	}

	private int repeatingState;

	public void doStuff(Object context) {
		System.out.println(this);
	}

//	@Override
//	public String toString() {
//		return "Flyweight{" +
//				"repeatingState=" + repeatingState +
//				'}';
//	}
}
