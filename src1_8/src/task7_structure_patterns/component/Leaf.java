package task7_structure_patterns.component;

public class Leaf implements Component {
	@Override
	public void execute() {
		System.out.println(this);
	}
}
