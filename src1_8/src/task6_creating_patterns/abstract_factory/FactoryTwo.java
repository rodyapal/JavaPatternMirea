package task6_creating_patterns.abstract_factory;

public class FactoryTwo implements IAbstractFactory{
	@Override
	public IFamilyElementA makeA() {
		return () -> "Factory:Two Element:A";
	}

	@Override
	public IFamilyElementB makeB() {
		return () -> "Factory:Two Element:B";
	}
}
