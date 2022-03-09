package task8_behaviore_patterns.visitor.visitables;

import task8_behaviore_patterns.visitor.IVisitor;

public class Bank implements IVisitable {
	@Override
	public void accept(IVisitor visitor) {
		visitor.visitBank();
	}
}
