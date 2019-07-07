package it.digitalnucleus.jgarden.j8.lambdas.funcinterfaces;

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
