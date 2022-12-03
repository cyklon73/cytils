package io.github.cyklon73.cytils.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListArray<T> {

    public static <E> ListArray<E> fromCollection(Collection<E> collection) {
        ListArray<E> la = new ListArray<>();
        collection.forEach(la::add);
        return la;
    }


    public static <E> ListArray<E> fromArray(E[] array) {
        ListArray<E> la = new ListArray<>();
        for (E e : array) {
            la.add(e);
        }
        return la;
    }

    private T[] array;

    public ListArray() {
        this.array = (T[]) new Object[0];
    }

    public void add(T t) {
        array = Arrays.copyOf(array, array.length+1);
        array[array.length-1] = t;
    }

    public void addAll(ListArray<T> la) {
        la.forEach(this::add);
    }

    public void addAll(Collection<T> collection) {
        addAll(fromCollection(collection));
    }

    public void addAll(T[] array) {
        addAll(fromArray(array));
    }

    /**
     * @return the removed element
     */
    public T remove(int i) {
        if (i >= getSize()) throw new IndexOutOfBoundsException("Index %i% out of bounds for length %l%".replace("%i%", i + "").replace("%l%", getSize() + ""));
        T element = get(i);
        array = Util.removeElementFromArray(array, i);
        return element;
    }

    public void remove(T t) {
        for (int i = 0; i < getSize(); i++) {
            if (get(i).equals(t)) remove(i);
        }
    }


    /**
     * @return array of removed elements
     */
    public T[] removeIf(Predicate<? super T> filter) {
        Objects.requireNonNull(filter);
        ListArray<T> la = new ListArray<>();
        boolean removed = false;
        for (int i = 0; i < getSize(); i++) {
            if (filter.test(get(i))) {
                la.add(remove(i));
            }
        }
        return la.toArray((T[]) new Object[la.getSize()]);
    }

    public void replace(int i, T replacement) {
        if (i >= getSize()) throw new IndexOutOfBoundsException("Index %i% out of bounds for length %l%".replace("%i%", i + "").replace("%l%", getSize() + ""));
        array[i] = replacement;
    }

    public int indexOf(T t) {
        for (int i = 0; i < getSize(); i++) {
            if (get(i).equals(t)) return i;
        }
        return -1;
    }

    public T get(int i) {
        return array[i];
    }

    public int getSize() {
        return array.length;
    }

    public void clear() {
        array = (T[]) new Object[0];
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isNull() {
        final boolean[] b = {true};
        this.forEach((t) -> {
            if (t!=null) b[0] = false;
        });
        return b[0];
    }

    public boolean contains(T t) {
        boolean[] contains = {false};
        forEach((e) -> {
            if (e.equals(t)) contains[0] = true;
        });
        return contains[0];
    }

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : array) {
            action.accept(t);
        }
    }

    public T[] toArray(T[] ar) {
        for (int i = 0; i < getSize(); i++) {
            ar[i] = get(i);
        }
        return ar;
    }
    private T[] toArray() {
        return array;
    }

    public Collection<T> toCollection() {
        Collection<T> c = new ArrayList<>();
        forEach(c::add);
        return c;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
