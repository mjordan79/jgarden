package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

import java.util.ArrayList;
import java.util.List;

public class UsePredicate {

	public static void main(String[] args) {
		
		//List<Integer> ints = List.of(0, 0, 0, 0, 0, 1);
		List<Integer> ints = new ArrayList<>();
		ints.add(0);
		ints.add(0);
		ints.add(0);
		ints.add(0);
		ints.add(0);
		ints.add(1);
		
		List<Integer> results = filter(ints, new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0 ? Boolean.TRUE : Boolean.FALSE;
			}
		});
		
		List<Integer> results2 = filter(ints, new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0 ? Boolean.FALSE : Boolean.TRUE;
			}
		});
		
		System.out.println("Number of elements > 0: " + results.size());
		System.out.println("Number of elements <= 0: " + results2.size());
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T t : list) {
			if (p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}

}
