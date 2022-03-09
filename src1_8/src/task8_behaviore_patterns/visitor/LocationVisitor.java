package task8_behaviore_patterns.visitor;

public class LocationVisitor implements IVisitor{
	@Override
	public void visitResidential() {
		System.out.println("Residential location visited");
	}

	@Override
	public void visitFactory() {
		System.out.println("Factory visited");
	}

	@Override
	public void visitBank() {
		System.out.println("Bank visited");
	}
}
