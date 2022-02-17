package task3_concurrent_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main3 {
	public static void main(String[] args) {
		testList();
		testMap();
	}

	private static void testList() {
		ConcurrentList<Integer> concurrentList = new ConcurrentList<>();
		Runnable runnableConcurrent = () -> {
			for (int i = 0; i < 5; i++) {
				concurrentList.add(i);
			}
		};
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(runnableConcurrent, "Thread #" + i);
			thread.start();
		}
		concurrentList.forEach(System.out::println);

		System.out.println("---");

		List<Integer> list = new ArrayList<>();
		Runnable runnable = () -> {
			for (int i = 10; i < 15; i++) {
				list.add(i);
			}
		};
		for (int i = 4; i < 7; i++) {
			Thread thread = new Thread(runnable, "Thread #" + i);
			thread.start();
		}
		list.forEach(System.out::println);
	}

	private static void testMap() {
		SemaphoreMap<Integer, Double> semaphoreMap = new SemaphoreMap<>(new Semaphore(2));

		Runnable runnableOne = () -> {
			semaphoreMap.acquire();
			Random random = new Random();
			for (int i = 0; i < 4; i++) {
				semaphoreMap.put(i, random.nextDouble());
			}
			semaphoreMap.release();
		};
		Runnable runnableTwo = () -> {
			semaphoreMap.acquire();
			Random random = new Random();
			for (int i = 10; i < 14; i++) {
				semaphoreMap.put(i, random.nextDouble());
			}
			semaphoreMap.release();
		};
		Runnable runnableThree = () -> {
			semaphoreMap.acquire();
			Random random = new Random();
			for (int i = 20; i < 24; i++) {
				semaphoreMap.put(i, random.nextDouble());
			}
			semaphoreMap.release();
		};

		Thread thread0 = new Thread(runnableOne);
		Thread thread1 = new Thread(runnableTwo);
		Thread thread2 = new Thread(runnableThree);

		thread0.start();
		thread1.start();
		thread2.start();

		semaphoreMap.forEach(
				(key, value) -> {
					System.out.println("k: " + key + "\tv: " + value);
				}
		);
	}
}