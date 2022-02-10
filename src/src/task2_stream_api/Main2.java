package task2_stream_api;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	public static void main(String[] args) {
		List<Human> humans = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			humans.add(
					Human.getRandom()
			);
		}
		System.out.println(humans);
		System.out.println("---");
		humans
				.stream()
				.filter((it) -> it.weight() > it.age())
				.forEach(System.out::println);
		System.out.println("---");
		humans
				.stream()
				.sorted((lhs, rhs) -> lhs.lastName().compareTo(rhs.lastName()) * -1)
				.forEach(System.out::println);
		System.out.println("---");
		System.out.println(
				humans
						.stream()
						.mapToInt(Human::weight)
						.sum()
		);
	}
}
