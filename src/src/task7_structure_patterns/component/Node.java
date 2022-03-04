package task7_structure_patterns.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node implements Component {
	private final List<Component> children = new ArrayList<>();

	public Node(Component... components) {
		children.addAll(Arrays.asList(components));
	}

	@Override
	public void execute() {
		children.forEach(Component::execute);
	}
}
