package task8_behaviore_patterns.visitor.visitables;

import task8_behaviore_patterns.visitor.IVisitor;

public interface IVisitable {
	void accept(IVisitor visitor);
}
