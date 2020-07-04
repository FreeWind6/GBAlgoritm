package hw4;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Iter<K,V>{

    private final Iterator<K> iterator;
    private final Function<K, V> function;

    public static <K,V> Iter<K,V> fromIterator(Iterator<K> iterator) {
        return new Iter<>(iterator, k->(V)k);
    }

    private Iter(Iterator<K> iterator, Function<K, V> function) {
        this.iterator = iterator;
        this.function = function;
    }

    public void forEach(Consumer action) {
        while (hasNext()) action.accept(this.next());
    }

    public V next() {
        K element = iterator.next();
        return element==null ? null : function.apply(element);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

}