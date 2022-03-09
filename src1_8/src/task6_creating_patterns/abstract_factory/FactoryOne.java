package task6_creating_patterns.abstract_factory;

public class FactoryOne implements IAbstractFactory{
	@Override
	public IFamilyElementA makeA() {
		return () -> "Factory:One Element:A";
	}

	@Override
	public IFamilyElementB makeB() {
		return () -> "Factory:One Element:B";
	}
}
