package task1_functional_interfaces;

import java.util.function.Predicate;

public class Main1 {

	public static void main(String[] args) {
		Predicate<String> checker = (pin) -> pin.matches("(\\d{4}$)|(\\d{6}$)");
		System.out.println(checker.test("1234"));
		System.out.println(checker.test("123456"));
		System.out.println(checker.test("qwer12345"));
	}
}
