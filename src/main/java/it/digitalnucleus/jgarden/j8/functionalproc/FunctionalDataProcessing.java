package it.digitalnucleus.jgarden.j8.functionalproc;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.digitalnucleus.jgarden.j8.functionalproc.model.Dish;
import it.digitalnucleus.jgarden.j8.functionalproc.model.Dish.Type;

import java.util.Optional;

public class FunctionalDataProcessing {
	
	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH)
		);

		List<String> high3Calories = menu
				.stream()
				.filter(d -> d.getCalories() > 300)
				.sorted(Comparator.comparing(Dish::getName))
				.map(Dish::getName)
				.distinct()
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("Reduced List: " + high3Calories);

		Stream.iterate(1, n -> ++n)
			.limit(10)
			.forEach(System.out::println);

		/* Matching specialized methods.
		 * anyMatch() - Almeno un elemento matchato dal predicato. Operazione terminale.
		 * allMatch() - Controlla che il predicato matcha tutti gli elementi. Terminale.
		 * noneMatch() - Controlla che il predicato non matcha alcun elemento. Terminale.
		 * findAny() - Ritorna un elemento arbitrario dello stream incapsulato in un Optional<T>. Terminale.
		 * findFirst() - Il primo elemento di uno stream. Terminale.
		 */
		Boolean oneMeatDishAtLeast = 
			menu.stream()
				.anyMatch(dish -> dish.getType().equals(Dish.Type.MEAT));

		Boolean allMatchByPredicate = 
			menu.stream()
				.allMatch(dish -> dish.getCalories() < 1000);

		Boolean noneMatchByPredicate =
			menu.stream()
				.noneMatch(dish -> dish.getCalories() > 20000);
		System.out.println("anyMatch(): " + oneMeatDishAtLeast + 
					" allMatch(): " + allMatchByPredicate + 
					" noneMatch(): " + noneMatchByPredicate);
		
		menu.stream()
			.filter(Dish::isVegetarian)
			.findAny() // Ritorna un Optional<Dish>
			.ifPresent(dish -> System.out.println(dish.getName()));
				
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream()
			.map(x -> x * x)
			.filter(x -> x % 3 == 0)
			.findFirst()
			.ifPresent(System.out::println);

		// Qualche esperimento con Optional<T>
		@SuppressWarnings("unused")
		Optional<Dish> opt = Optional.ofNullable(new Dish("Caviar", false, 250, Type.FISH));
	}
	
}
