package task6_creating_patterns.factory;

public class FactoryA implements IFactory {
	@Override
	public IProduct make() {
		return new ProductA();
	}
}
