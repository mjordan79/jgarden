package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

import java.util.ArrayList;
import java.util.List;

import it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces.Function;

public class UseFunction {

	public static void main(String[] args) {
		// List<String> strings = List.of("Renato", "Francesco", "Randolina");
		List<String> strings = new ArrayList<>();
		strings.add("Renato");
		strings.add("Francesco");
		strings.add("Randolina");
		List<Integer> results = map(strings, new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		});
		
		results.forEach(i -> System.out.print(i));

	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> results = new ArrayList<>();
		for (T t : list) {
			results.add(f.apply(t));
		}
		return results;
	}

}
