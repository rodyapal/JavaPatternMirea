package task6_creating_patterns.factory;

public class FactoryB implements IFactory{
	@Override
	public IProduct make() {
		return new ProductB();
	}
}
