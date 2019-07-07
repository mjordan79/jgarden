package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
