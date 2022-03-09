package task4_exucution_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main4 {
	public static void main(String[] args) {
		Callable<String> task0 = () -> "0";
		Callable<String> task1 = () -> "1";
		Callable<String> task2 = () -> "2";
		Callable<String> task3 = () -> "3";
		Callable<String> task4 = () -> "4";
		Callable<String> task5 = () -> "5";
		Callable<String> task6 = () -> "6";
		Callable<String> task7 = () -> "7";
		Callable<String> task8 = () -> "8";
		List<Callable<String>> tasks = new ArrayList<>();
		tasks.add(task0); tasks.add(task1); tasks.add(task2);
		tasks.add(task3); tasks.add(task4); tasks.add(task5);
		tasks.add(task6); tasks.add(task7); tasks.add(task8);

		CustomExecutorService service = new CustomExecutorService(2);
		try {
			List<Future<String>> results = service.invokeAll(tasks);
			for (Future<String> item :
					results) {
				System.out.println(item.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
