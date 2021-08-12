package eu.braincluster;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main
{
    private static int Sum1(List<Integer> numbers)
    {
        int sum =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        return sum;
    }

    private static int Sum2(List<Integer> numbers)
    {
        int sum =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .filter(x -> x % 2 == 0)
                        .sum();

        return sum;
    }

    private static int Sum3(List<Integer> numbers)
    {
        int sum =
                numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .sum();

        return sum;
    }

    private static int Sum4(List<Integer> numbers, Predicate<Integer> numberSelector)
    {
        int sum =
                numbers.stream()
                        .filter(numberSelector)
                        .mapToInt(Integer::intValue)
                        .sum();

        return sum;
    }

    public static void main(String[] args)
    {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30);

        System.out.println("Sum1 = " + Sum1(numbers));
        System.out.println();

        System.out.println("Sum2 = " + Sum2(numbers));
        System.out.println();

        System.out.println("Sum3 = " + Sum3(numbers));
        System.out.println();

        System.out.println("Sum4a = " + Sum4(numbers, number -> number % 2 != 0));
        System.out.println();

        System.out.println("Sum4b = " + Sum4(numbers, number -> number >= 10));
        System.out.println();
    }
}
