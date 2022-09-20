package lib.collectors;

import book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collector;

import static book.Book.sameBook;

public class NotDuplicateCollectors {

    public static <T extends Book> Collector<T, List<T>, List<T>> toBookList() {
        return Collector.of(
                ArrayList::new,
                (list, value) ->
                        list
                                .stream()
                                .filter(sameBook().with(value))
                                .findFirst()
                                .ifPresentOrElse(
                                        anything -> {
                                        },
                                        () -> list.add(value)),
                (soFar, element) -> {
                    soFar.addAll(element);
                    return soFar;
                },
                Collector.Characteristics.IDENTITY_FINISH);
    }

    public static <T> Collector<T, List<T>, List<T>> toList(BiFunction<T, T, Boolean> duplicateCondition) {
        return Collector.of(
                ArrayList::new,
                (list, value) ->
                        list
                                .stream()
                                .filter(l -> duplicateCondition.apply(l, value))
                                .findFirst()
                                .ifPresentOrElse(
                                        anything -> {
                                        },
                                        () -> list.add(value)),
                (soFar, element) -> {
                    soFar.addAll(element);
                    return soFar;
                },
                Collector.Characteristics.IDENTITY_FINISH);
    }
}
