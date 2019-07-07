package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

import java.util.ArrayList;
import java.util.List;

public class UseConsumer {

	public static void main(String[] args) {
		// List<Integer> ints = List.of(1, 2, 3, 4, 5);
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		forEach(ints, new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}
	
}
