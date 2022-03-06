package task7_structure_patterns;

import task7_structure_patterns.component.Component;
import task7_structure_patterns.component.Leaf;
import task7_structure_patterns.component.Node;
import task7_structure_patterns.flyweight.Flyweight;
import task7_structure_patterns.flyweight.FlyweightFactory;

import java.util.ArrayList;
import java.util.List;

public class Main7 {
	public static void main(String[] args) {
		testFlyweight();
		testComponent();
	}

	private static void testFlyweight() {
		FlyweightFactory factory = new FlyweightFactory();
		List<Flyweight> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(factory.getFlyweight(i));
		}
		for (int i = 1; i < 5; i++) {
			list.add(factory.getFlyweight(i));
		}
		list.forEach(System.out::println);
	}

	private static void testComponent() {
		Component head = new Node(
				new Leaf(), new Leaf(), new Leaf(),
				new Node(
						new Leaf(), new Node(new Leaf(), new Leaf()), new Leaf()
				),
				new Node(new Leaf(), new Leaf(), new Leaf()),
				new Leaf()
		);
		head.execute();
	}
}
