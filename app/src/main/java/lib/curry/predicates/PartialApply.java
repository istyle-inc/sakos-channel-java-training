package lib.curry.predicates;

import java.util.function.Predicate;

public interface PartialApply<T> {
    Predicate<T> with(T target);
}
