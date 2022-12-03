package io.github.cyklon73.cytils.utils;

@FunctionalInterface
public interface Function<T> {

    public abstract T run(Object... args);

}
