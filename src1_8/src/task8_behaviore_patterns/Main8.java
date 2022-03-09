package task8_behaviore_patterns;

import task8_behaviore_patterns.command.DataEraseIntent;
import task8_behaviore_patterns.command.Intent;
import task8_behaviore_patterns.command.NotifyIntent;
import task8_behaviore_patterns.visitor.IVisitor;
import task8_behaviore_patterns.visitor.LocationVisitor;
import task8_behaviore_patterns.visitor.visitables.Bank;
import task8_behaviore_patterns.visitor.visitables.Factory;
import task8_behaviore_patterns.visitor.visitables.IVisitable;
import task8_behaviore_patterns.visitor.visitables.Residential;

import java.util.Arrays;
import java.util.List;

public class Main8 {
	public static void main(String[] args) {
		testVisitor();
		testCommand();
	}

	private static void testVisitor() {
		IVisitor visitor = new LocationVisitor();
		List<IVisitable> locations = Arrays.asList(new Factory(), new Residential(), new Bank());
		locations.forEach((it) -> it.accept(visitor));
	}

	private static void testCommand() {
		List<Intent> intents = Arrays.asList(new DataEraseIntent(1234), new NotifyIntent("Notification"));
		intents.forEach(Intent::execute);
	}
}
