package task8_behaviore_patterns.command;

public class DataEraseIntent implements Intent {
	private int id = 0;
	private final Object database = null;

	public DataEraseIntent(int id) {
		this.id = id;
	}

	@Override
	public void execute() {
		//Database interaction code
		System.out.println("Data with id " + id + " erased from database");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
