package project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        numbers.stream().sorted().forEach(System.out::println);

        System.out.println("Sorted Strings in descending order");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> words = Arrays.asList("banana", "apple", "orange", "kiwi");
        words.stream().sorted().forEach(System.out::println);
    }
}
