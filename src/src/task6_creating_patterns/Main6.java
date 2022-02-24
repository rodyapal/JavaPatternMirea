package task6_creating_patterns;

import task6_creating_patterns.abstract_factory.FactoryOne;
import task6_creating_patterns.abstract_factory.FactoryTwo;
import task6_creating_patterns.abstract_factory.IFamilyElementA;
import task6_creating_patterns.abstract_factory.IFamilyElementB;
import task6_creating_patterns.builder.ClassA;
import task6_creating_patterns.factory.*;
import task6_creating_patterns.prototype.Prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main6 {
	public static void main(String[] args) {
		testFactory();
		testAbstractFactory();
		testBuilder();
		testPrototype();
	}

	private static void testFactory() {
		FactoryA a = new FactoryA();
		FactoryB b = new FactoryB();
		List<IProduct> products = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				products.add(a.make());
			} else {
				products.add(b.make());
			}
		}
		products.forEach((item) -> {
			System.out.println(item.name());
		});
	}

	private static void testAbstractFactory() {
		FactoryOne one = new FactoryOne();
		FactoryTwo two = new FactoryTwo();
		Map<IFamilyElementA, IFamilyElementB> elements = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				elements.put(one.makeA(), one.makeB());
			} else {
				elements.put(two.makeA(), two.makeB());
			}
		}
		elements.forEach((key, value) -> {
			System.out.println("{\n\tkey: " + key.foo() + "\n\t" + value.bar() + "\n}");
		});
	}

	private static void testBuilder() {
		ClassA a = new ClassA.Builder()
				.putFieldOne()
				.putFieldThree()
				.putFieldFour()
				.putFieldTwo()
				.build();
		System.out.println(a);
	}

	private static void testPrototype() {
		Prototype origin = new Prototype();
		Prototype clone = origin.getPrototype();
		System.out.println(origin);
		System.out.println(clone);
	}
}
