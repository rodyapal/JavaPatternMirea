package task2_stream_api;

import java.time.LocalDate;
import java.util.Random;

public record Human(
	int age,
	String firstName,
	String lastName,
	LocalDate birthDate,
	int weight
) {
	static Human getRandom() {
		Random random = new Random();
		return new Human(
			random.nextInt(120),
			String.format("firstName#%d", random.nextInt(5000)),
			String.format("lastName#%d", random.nextInt(5000)),
			LocalDate.now().minusDays(random.nextInt(3000)),
			random.nextInt(150)
		);
	}
}