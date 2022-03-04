package task7_structure_patterns.flyweight;

import task7_structure_patterns.flyweight.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	private final Map<Integer, Flyweight> cache = new HashMap<>();

	public Flyweight getFlyweight(int repeatingState) {
		if (!cache.containsKey(repeatingState)) {
			cache.put(
					repeatingState, new Flyweight(repeatingState)
			);
		}
		return cache.get(repeatingState);
	}
}