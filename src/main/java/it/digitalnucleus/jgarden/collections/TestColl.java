package it.digitalnucleus.jgarden.collections;

import java.util.Objects;
import java.util.function.Supplier;

public class TestColl {
	
	public static void main(String[] args) {
		
		String str = prova1(() -> "A message!");
		Objects.requireNonNull(str, "An exception!");

	}
	
	private static <T> T prova1(Supplier<T> s) {
		T t = s.get();
		System.out.println(t);
		return t;
	}

}
