package task6_creating_patterns.abstract_factory;

public class FactoryTwo implements IAbstractFactory{
	@Override
	public IFamilyElementA makeA() {
		return new IFamilyElementA() {
			@Override
			public String foo() {
				return "Factory:Two Element:A";
			}
		};
	}

	@Override
	public IFamilyElementB makeB() {
		return new IFamilyElementB() {
			@Override
			public String bar() {
				return "Factory:Two Element:B";
			}
		};
	}
}
