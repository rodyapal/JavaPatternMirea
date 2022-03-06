package task8_behaviore_patterns.command;

public class NotifyIntent implements Intent {
	private String data = "";

	public NotifyIntent(String data) {
		this.data = data;
	}

	@Override
	public void execute() {
		System.out.println(data);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
