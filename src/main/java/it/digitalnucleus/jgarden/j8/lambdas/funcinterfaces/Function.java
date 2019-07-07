package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

@FunctionalInterface
public interface Function<T, R> {
	R apply(T t);
}
