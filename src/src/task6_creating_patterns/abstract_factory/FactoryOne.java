package task6_creating_patterns.abstract_factory;

public class FactoryOne implements IAbstractFactory{
	@Override
	public IFamilyElementA makeA() {
		return new IFamilyElementA() {
			@Override
			public String foo() {
				return "Factory:One Element:A";
			}
		};
	}

	@Override
	public IFamilyElementB makeB() {
		return new IFamilyElementB() {
			@Override
			public String bar() {
				return "Factory:One Element:B";
			}
		};
	}
}
